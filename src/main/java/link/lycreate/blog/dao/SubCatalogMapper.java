package link.lycreate.blog.dao;

import link.lycreate.blog.model.MainCatalog;
import link.lycreate.blog.model.SubCatalog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SubCatalogMapper
 *
 * @author LYcreate
 * @date 2019/2/3 18:43
 */
public interface SubCatalogMapper {
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:49
     * @param
     * @return java.util.List<link.lycreate.blog.model.SubCatalog>
     */
    public List<SubCatalog> selectAllSubCatalog();
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:49
     * @param subCatalogId
     * @return link.lycreate.blog.model.SubCatalog
     */
    public SubCatalog selectSubCatalogBySubCatalogId(Integer subCatalogId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:49
     * @param name
     * @return link.lycreate.blog.model.SubCatalog
     */
    public SubCatalog selectSubcatalogByName(String name);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/4 22:03
     * @param mainCatalogId
     * @return java.util.List<link.lycreate.blog.model.SubCatalog>
     */
    public List<SubCatalog> selectSubcatalogByMainCatalogId(Integer mainCatalogId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/4 22:05
     * @param subCatalogId
     * @return int
     */
    public Integer selectMainCatalogIdBySubCatalogId(Integer subCatalogId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:49
     * @param subCatalogId
     * @return int
     */
    public Integer deleteSubCtalogBySubCatalogId(Integer subCatalogId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:49
     * @param name
     * @return int
     */
    public int deleteSubCatalogByName(String name);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:49
     * @param name
      mainCatalogId
     * @return int
     */
    public int inserSubCatalog(@Param("name") String name, @Param("mainCatalogId") int mainCatalogId);
    /**
     * description
     * @author LYcreate
     * @date 2019/2/3 18:49
     * @param subCatalog
     * @return int
     */
    public int updateSubCatalog(SubCatalog subCatalog);
}
