package link.lycreate.blog.service;

import java.util.Map;

/**
 * MessageService
 *
 * @author LYcreate
 * @date 2019/2/4 22:54
 */
public interface MessageService {
    /**
     * description
     * @author LYcreate
     * @date 2019/2/14 10:44
     * @param pageNow
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> getAllMessage(Integer pageNow);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/12 21:46
     * @param catalogId
    pageNow
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> getPage(String mainSub,Integer catalogId,Integer pageNow);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/12 21:46
     * @param messageId
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> getMessage(String messageId);
}
