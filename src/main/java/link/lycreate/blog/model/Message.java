package link.lycreate.blog.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * Message
 * @author LYcreate
 * @date 2019/2/2
 * */
@Entity
@Table(name = "message")
public class Message implements Serializable {
    private int messageId;
    private String title;
    private int mainCatalogId;
    private int subCatalogId;
    public String content;
    private Timestamp createTime;
    private String summary;

    public Message(int messageId, String title, Integer mainCatalogId, Integer subCatalogId, String content, Timestamp createTime, String summary) {
        this.messageId = messageId;
        this.title = title;
        this.mainCatalogId = mainCatalogId;
        this.subCatalogId = subCatalogId;
        this.content = content;
        this.createTime = createTime;
        this.summary = summary;
    }

    public Message(String title, Integer mainCatalogId, Integer subCatalogId, String content, Timestamp createTime, String summary) {
        this.title = title;
        this.mainCatalogId = mainCatalogId;
        this.subCatalogId = subCatalogId;
        this.content = content;
        this.createTime = createTime;
        this.summary = summary;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMainCatalogId() {
        return mainCatalogId;
    }

    public void setMainCatalogId(Integer mainCatalogId) {
        this.mainCatalogId = mainCatalogId;
    }

    public Integer getSubCatalogId() {
        return subCatalogId;
    }

    public void setSubCatalogId(Integer subCatalogId) {
        this.subCatalogId = subCatalogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", title='" + title + '\'' +
                ", mainCatalogId='" + mainCatalogId + '\'' +
                ", subCatalogId='" + subCatalogId + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", summary='" + summary + '\'' +
                '}';
    }
}
