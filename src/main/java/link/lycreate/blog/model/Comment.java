package link.lycreate.blog.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * CommentServiceImpl
 * @author LYcreate
 * @date 2019/2/2
 * */
@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    private int commentId;
    private String userName;
    private String email;
    private Integer messageId;
    private Timestamp createTime;
    private String content;

    public Comment() {
    }

    public Comment(int commentId, String userName, String email, Integer messageId, Timestamp createTime, String content) {
        this.commentId = commentId;
        this.userName = userName;
        this.email = email;
        this.messageId = messageId;
        this.createTime = createTime;
        this.content=content;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", messageId=" + messageId +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                '}';
    }
}
