package link.lycreate.blog.controller;

import link.lycreate.blog.model.Comment;
import link.lycreate.blog.model.MainCatalog;
import link.lycreate.blog.model.Message;
import link.lycreate.blog.service.CommentService;
import link.lycreate.blog.service.MainCatalogService;
import link.lycreate.blog.service.MessageService;
import link.lycreate.blog.service.SubCatalogService;
import link.lycreate.blog.utils.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PageController
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/2/8 20:55
 */
@Controller
public class PageController {
    @Autowired
    private SubCatalogService subCatalogService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private CommentService commentService;
    /**
     * description
     * @author LYcreate
     * @date 2019/2/8 21:08
     * @param
     * @return java.lang.String
     */
    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String goIndex(){
        return "index";
    }
    /**
     * description
     * @author LYcreate
     * @date 2019/2/8 21:08
     * @param
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("/catalog")
    public @ResponseBody Map<String,Object> getCatalog(){
        System.out.println("catalog");
        HashMap<String,Object> resultMap=subCatalogService.getCatalog();
        System.out.println("controller:"+resultMap);
        return resultMap;
    }
    @RequestMapping("/getAllMessage")
    public @ResponseBody Map<String,Object> getAllMessage(Integer pageNow){
        Map<String,Object> pageMap=messageService.getAllMessage(pageNow);
        return pageMap;
    }
    /**
     * description
     * @author LYcreate
     * @date 2019/2/12 11:03
     * @param request
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("/messageListByMain")
    public @ResponseBody Map<String,Object> getMessageListByMain(HttpServletRequest request){
        String sMainCatalogId=request.getParameter("mainCatalogId");
        String sPageNow=request.getParameter("pageNow");
        Integer mainCatalogId=Integer.parseInt(sMainCatalogId);
        Integer pageNow=Integer.parseInt(sPageNow);
        System.out.println(sPageNow);
        Map<String,Object> pageMap=messageService.getPage("main",mainCatalogId,pageNow);
        return pageMap;
    }
    @RequestMapping("/messageListBySub")
    public @ResponseBody Map<String,Object> getMessageListBySub(HttpServletRequest request){
        String sSubCatalogId=request.getParameter("subCatalogId");
        String sPageNow=request.getParameter("pageNow");
        Integer subCatalogId=Integer.parseInt(sSubCatalogId);
        Integer pageNow=Integer.parseInt(sPageNow);
        System.out.println(sPageNow);
        Map<String,Object> pageMap=messageService.getPage("sub",subCatalogId,pageNow);
        return pageMap;
    }
    @RequestMapping("/message")
    public ModelAndView getMessageById(int messageId){
        ModelAndView mav=new ModelAndView();
        Message message=messageService.getMessage(messageId);
        System.out.println(message);
        mav.addObject("blog",message);
        mav.setViewName("article");
        return mav;
    }
    @RequestMapping("/getMessage")
    public @ResponseBody Message getMessages(int messageId){
        System.out.println(messageId);
        return messageService.getMessage(messageId);
    }
    @RequestMapping("/submitComment")
    public @ResponseBody
    NetResult addComment(HttpServletRequest request){
        String userName=request.getParameter("userName");
        String email=request.getParameter("emailAddress");
        String content=request.getParameter("content");
        String sMessageId=request.getParameter("messageId");
        int messageId=Integer.parseInt(sMessageId);
        Comment comment=new Comment();
        comment.setMessageId(messageId);
        comment.setContent(content);
        comment.setUserName(userName);
        comment.setEmail(email);
        Date time=new Date();
        Timestamp createTime=new Timestamp(time.getTime());
        comment.setCreateTime(createTime);
        int count=commentService.insertComment(comment);
        NetResult netResult=new NetResult();
        netResult.setStatus(count);
        String result=count==1?"评论成功":"评论失败！";
        netResult.setResult(result);
        return netResult;
    }

    @RequestMapping("/getComments")
    public @ResponseBody
    List<Comment> getComments(int messageId){
        return commentService.getCommentByMessageId(messageId);
    }

}
