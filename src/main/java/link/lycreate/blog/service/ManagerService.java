package link.lycreate.blog.service;

import link.lycreate.blog.utils.NetResult;

/**
 * ManagerService
 *
 * @author LYcreate
 * @date 2019/2/4 22:53
 */
public interface ManagerService {
    /**
     * description
     * @author LYcreate
     * @date 2019/2/17 14:48
     * @param userName
    password
    sessionId
     * @return link.lycreate.blog.utils.NetResult
     */
    public NetResult login(String userName,String password,String sessionId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/20 21:13
     * @param userName
    sessionId
     * @return java.lang.Boolean
     */
    public Boolean isLogin(String userName,String sessionId);
}
