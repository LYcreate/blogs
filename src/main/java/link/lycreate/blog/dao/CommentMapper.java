package link.lycreate.blog.dao;

import link.lycreate.blog.model.Comment;

import java.util.Date;
import java.util.List;

/**
 * CommentMapper
 *
 * @author LYcreate
 * @date 2019/2/2 17:25
 */
public interface CommentMapper {
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 17:40
     * @param
     * @return java.util.List<link.lycreate.blog.model.CommentServiceImpl>
     */
    public List<Comment> selectAllComment();

    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 17:40
     * @param userName user's name
     * @return link.lycreate.blog.model.CommentServiceImpl
     */
    public Comment selectCommentByUserName(String userName);

    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 17:38
     * @param email the email-address of user
     * @return link.lycreate.blog.model.CommentServiceImpl
     */
    public Comment selectCommentByEmail(String email);

    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 17:38
     * @param messageId messageId
     * @return link.lycreate.blog.model.CommentServiceImpl
     */
    public List<Comment> selectCommentByMessageId(int messageId);

    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 17:17
     * @param commentId commentId
     * @return java.lang.String
     */
    public String selectUserNameByCommentId(int commentId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 17:17
     * @param commentId commentId
     * @return java.lang.String
     */
    public String seletcEmailByCommentId(int commentId);

    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:34
     * @param commandId commandId
     * @return int
     */
    public int deleteCommentByCommentId(int commandId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:36
     * @param comment
     * @return int
     */
    public int insertComment(Comment comment);

}
