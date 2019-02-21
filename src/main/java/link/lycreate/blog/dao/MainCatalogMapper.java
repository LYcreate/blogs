package link.lycreate.blog.dao;

import link.lycreate.blog.model.MainCatalog;

import java.util.List;

/**
 * MainCatalogMapper
 *
 * @author LYcreate
 * @date 2019/2/2 17:25
 */
public interface MainCatalogMapper {
    /**
     * description
     * @author LYcreate
     * @date 2019/2/4 14:03
     * @param
     * @return java.util.List<link.lycreate.blog.model.MainCatalog>
     */
    public List<MainCatalog> selectAllMainCatalog();
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:38
     * @param name
     * @return link.lycreate.blog.model.MainCatalog
     */
    public MainCatalog selectMainCatalogByName(String name);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:39
     * @param mainCatalogId
     * @return link.lycreate.blog.model.MainCatalog
     */
    public MainCatalog selectMainCatalogByMainCatalogId(int mainCatalogId);

    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:40
     * @param mainCatalog
     * @return int
     */
    public int insertMainCatalog(MainCatalog mainCatalog);

    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:40
     * @param name
     * @return int
     */
    public int deleteMainCatalogByName(String name);

    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:41
     * @param mainCatalogId
     * @return int
     */
    public int deleteMainCatalogByMainCatalogId(int mainCatalogId);

    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:43
     * @param mainCatalog
     * @return int
     */
    public int updateMainCatalog(MainCatalog mainCatalog);
}
