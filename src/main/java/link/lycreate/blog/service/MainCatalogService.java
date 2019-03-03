package link.lycreate.blog.service;

import link.lycreate.blog.model.MainCatalog;

import java.util.List;
import java.util.Map;

/**
 * MainCatalogService
 *
 * @author LYcreate
 * @date 2019/2/4 22:54
 */
public interface MainCatalogService {
    public List<MainCatalog> getMainCatalog();
    public int addMainCatalog(String name);
    public int updateMainCatalog(String name,int mainCatalogId);
    public int deleteMainCatalog(int mainCatalogId);
}
