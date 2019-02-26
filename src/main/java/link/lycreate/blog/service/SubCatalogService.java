package link.lycreate.blog.service;
import link.lycreate.blog.model.SubCatalog;

import java.util.HashMap;
import java.util.List;

/**
 * SubCatalogService
 *
 * @author LYcreate
 * @date 2019/2/4 22:54
 */
public interface SubCatalogService {
    public HashMap<String,Object> getCatalog();
    public List<SubCatalog> getSubCatalog(Integer mainCatalogId);
}
