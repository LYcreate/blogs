package link.lycreate.blog.model;

/**
 * @ClassName Brief
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/2/12 12:25
 */
public class Brief {
    private Integer messageId;
    private String title;
    private String summary;

    public Brief(Integer messageId, String title, String summary) {
        this.messageId = messageId;
        this.title = title;
        this.summary = summary;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Brief{" +
                "messageId=" + messageId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
