package link.lycreate.blog.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
*
* Manager
* @author LYcreate
* @date 2019/2/2
* */
@Entity
@Table(name = "manager")
public class Manager implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String sessionId;

    public Manager(Integer id, String name, String password, String sessionId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sessionId = sessionId;
    }

    public Manager() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
