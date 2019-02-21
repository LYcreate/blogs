package link.lycreate.blog.dao;

import link.lycreate.blog.model.Brief;
import link.lycreate.blog.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * MessageMapper
 *
 * @author LYcreate
 * @date 2019/2/2 17:25
 */
public interface MessageMapper {
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 23:42
     * @param messageId
     * @return link.lycreate.blog.model.Message
     */
    public Message selectMessageByMessageId(int messageId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 23:42
     * @param createTime
     * @return java.util.List<link.lycreate.blog.model.Message>
     */
    public List<Message> selectMessageByCreateTime(Date createTime);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 23:42
     * @param messageId
     * @return int
     */
    public int deleteMessageByMessageId(Integer messageId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 23:42
     * @param message
     * @return int
     */
    public int updateMessage(Message message);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 23:42
     * @param message
     * @return int
     */
    public int insertMessage(Message message);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/12 11:38
     * @param
     * @return int
     */
    public int selectCount();
    /**
     * description
     * @author LYcreate
     * @date 2019/2/14 11:15
     * @param mainCatalogId
     * @return int
     */
    public int selectCountByMain(int mainCatalogId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/14 11:16
     * @param subCatalogId
     * @return int
     */
    public int selectCountBySub(int subCatalogId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/14 11:14
     * @param startPos
    pageSize
     * @return java.util.List<link.lycreate.blog.model.Brief>
     */
    public List<Brief> selectAllBrief(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/12 21:42
     * @param mainCatalogId
    startPos
    pageSize
     * @return java.util.List<link.lycreate.blog.model.Brief>
     */
    public List<Brief> selectBriefByMain(@Param(value = "mainCatalogId") Integer mainCatalogId,@Param(value = "startPos") Integer startPos,@Param(value = "pageSize") Integer pageSize);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/12 21:42
     * @param subCatalogId
    startPos
    pageSize
     * @return java.util.List<link.lycreate.blog.model.Brief>
     */
    public List<Brief> selectBriefBySub(@Param(value = "subCatalogId") Integer subCatalogId,@Param(value = "startPos") Integer startPos,@Param(value = "pageSize") Integer pageSize);
}
