package link.lycreate.blog.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * SubCatalog
 *
 * @author LYcreate
 * @date 2019/2/2
 *
 * */
@Entity
@Table(name = "subcatalog")
public class SubCatalog {
    private Integer subCatalogId;
    private String name;
    private Integer mainCatalogId;

    public SubCatalog(Integer subCatalogId, String name,Integer mainCatalogId) {
        this.subCatalogId = subCatalogId;
        this.name = name;
        this.mainCatalogId=mainCatalogId;
    }

    public Integer getSubCatalogId() {
        return subCatalogId;
    }

    public void setSubCatalogId(Integer subCatalogId) {
        this.subCatalogId = subCatalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMainCatalogId() {
        return mainCatalogId;
    }

    public void setMainCatalogId(Integer mainCatalogId) {
        this.mainCatalogId = mainCatalogId;
    }

    @Override
    public String toString() {
        return "SubCatalog{" +
                "subCatalogId=" + subCatalogId +
                ", name='" + name + '\'' +
                ", mainCatalogId=" + mainCatalogId +
                '}';
    }
}
