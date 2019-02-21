package link.lycreate.blog.controller;

import link.lycreate.blog.model.MainCatalog;
import link.lycreate.blog.service.MainCatalogService;
import link.lycreate.blog.service.MessageService;
import link.lycreate.blog.service.SubCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
}
