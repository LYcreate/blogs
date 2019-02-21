package link.lycreate.blog.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * CommentServiceImpl
 * @author LYcreate
 * @date 2019/2/2
 * */
@Entity
@Table(name = "comment")
public class Comment {
    private int commentId;
    private String userName;
    private String email;
    private int messageId;
    private Date createTime;

    public Comment(int commentId, String userName, String email, int messageId, Date createTime) {
        this.commentId = commentId;
        this.userName = userName;
        this.email = email;
        this.messageId = messageId;
        this.createTime = createTime;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "CommentServiceImpl{" +
                "commentId=" + commentId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", messageId=" + messageId +
                ", createTime=" + createTime +
                '}';
    }
}
