package link.lycreate.blog.dao;

import link.lycreate.blog.model.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * ManagerMapper
 *
 * @author LYcreate
 * @date 2019/2/2 17:25
 */
public interface ManagerMapper {
    /**
     * description
     * @author LYcreate
     * @date 2019/2/17 14:00
     * @param name
     * @return link.lycreate.blog.model.Manager
     */
    public Manager selectManagerByName(String name);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/17 14:00
     * @param password
     * @return java.lang.String
     */
    public String selectPasswordByName(String password);

    /**
     * description
     * @author LYcreate
     * @date 2019/2/20 21:07
     * @param sessionId
    id
     * @return int
     */
    public int updateSessionId(@Param("sessionId") String sessionId,@Param("id") int id);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/20 21:18
     * @param userName
     * @return java.lang.String
     */
    public String getSessionIdByUserName(String userName);
}
