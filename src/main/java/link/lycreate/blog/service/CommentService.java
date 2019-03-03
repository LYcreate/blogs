package link.lycreate.blog.service;

import link.lycreate.blog.model.Comment;

import java.util.List;

/**
 * CommentService
 *
 * @author LYcreate
 * @date 2019/2/4 22:54
 */
public interface CommentService {
    /**
     * description
     * @author LYcreate
     * @date 2019/2/4 23:14
     * @param messageId
     * @return java.util.List<link.lycreate.blog.model.Comment>
     */
    public List<Comment> getCommentByMessageId(int messageId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/4 23:25
     * @param messageId
     * @return boolean
     */
    public boolean deleteCommentByMessageId(int messageId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/4 23:39
     * @param comment
     * @return boolean
     */
    public boolean addComment(Comment comment);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/2 18:53
     * @param comment
     * @return int
     */
    public int insertComment(Comment comment);
}
