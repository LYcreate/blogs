package link.lycreate.blog.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 *MainCatalog
 *
 * @author LYcreate
 * @date 2019/2/2
 *
 * */
@Entity
@Table(name = "maincatalog")
public class MainCatalog implements Serializable {
    private Integer mainCatalogId;
    private String name;

    public MainCatalog(Integer mainCatalogId, String name) {
        this.mainCatalogId = mainCatalogId;
        this.name = name;
    }

    public Integer getMainCatalogId() {
        return mainCatalogId;
    }

    public void setMainCatalogId(Integer mainCatalogId) {
        this.mainCatalogId = mainCatalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MainCatalog{" +
                "mainCatalogId=" + mainCatalogId +
                ", name='" + name + '\'' +
                '}';
    }
}
