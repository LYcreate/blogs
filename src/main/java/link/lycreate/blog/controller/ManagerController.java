package link.lycreate.blog.controller;

import link.lycreate.blog.model.Manager;
import link.lycreate.blog.service.ManagerService;
import link.lycreate.blog.utils.NetResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName ManagerController
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/2/16 20:27
 */
@RequestMapping(value = "/manage")
@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @RequestMapping("/loginrequest")
    public @ResponseBody NetResult managerLogin(HttpServletRequest request){
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        System.out.println(userName);
        HttpSession session=request.getSession();
        String sessionId=session.getId();
        NetResult netResult=managerService.login(userName,password,sessionId);
        if(netResult.getStatus()==1){
            session.setAttribute("managerName",userName);
        }
        return netResult;
    }
    @RequestMapping("/")
    public String managerIndex(HttpServletRequest request){
        HttpSession session=request.getSession();
        String sessionId=session.getId();
        String userName=(String)session.getAttribute("managerName");
        if (userName!=null){
            Boolean isLogin=managerService.isLogin(userName,sessionId);
            if (isLogin){
                return "/manage/manager";
            }else{
                return "/manage/login";
            }
        }else{
            return "/manage/login";
        }
    }
    @RequestMapping("/login")
    public String loginPage(){
        return "/manage/login";
    }
}
