package link.lycreate.blog.service.impl;

import link.lycreate.blog.dao.ManagerMapper;
import link.lycreate.blog.model.Manager;
import link.lycreate.blog.service.ManagerService;
import link.lycreate.blog.utils.MD5Encode;
import link.lycreate.blog.utils.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName ManagerServiceImpl
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/2/4 22:56
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public NetResult login(String userName, String password,String sessionId) {
        String md5Password=MD5Encode.encode(password);
        Manager manager=managerMapper.selectManagerByName(userName);
        NetResult netResult=new NetResult();
        if(manager!=null){
            if (md5Password.equals(manager.getPassword())){
                //invalid password
                netResult.setStatus(0);
                netResult.setResult("密码不正确！");
            }
            else{
                //success
                manager.setSessionId(sessionId);
                managerMapper.updateSessionId(manager.getSessionId(),manager.getId());
                netResult.setResult("登录成功！");
                netResult.setStatus(1);
            }
        }else {
            //No User
            netResult.setResult("用户名不存在！");
            netResult.setStatus(0);
        }
        return netResult;
    }

    @Override
    public Boolean isLogin(String userName, String sessionId) {
        String dbSessionId=managerMapper.getSessionIdByUserName(userName);
        return dbSessionId.equals(sessionId);
    }
}
