package link.lycreate.blog.service.impl;

import link.lycreate.blog.model.Comment;
import link.lycreate.blog.service.CommentService;
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
    @Override
    public List<Comment> getCommentByMessageId(int messageId) {
        return null;
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
