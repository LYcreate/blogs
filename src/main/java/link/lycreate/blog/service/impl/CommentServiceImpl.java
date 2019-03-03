package link.lycreate.blog.service.impl;

import link.lycreate.blog.dao.CommentMapper;
import link.lycreate.blog.model.Comment;
import link.lycreate.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CommentServiceImpl
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/2/4 22:55
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> getCommentByMessageId(int messageId) {
        List<Comment> commentList=commentMapper.selectCommentByMessageId(messageId);
        return commentList;
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public boolean deleteCommentByMessageId(int messageId) {
        return false;
    }

    @Override
    public boolean addComment(Comment comment) {
        return false;
    }
}
