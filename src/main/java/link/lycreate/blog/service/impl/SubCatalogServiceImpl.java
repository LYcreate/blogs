package link.lycreate.blog.service.impl;

import link.lycreate.blog.dao.MainCatalogMapper;
import link.lycreate.blog.dao.SubCatalogMapper;
import link.lycreate.blog.model.MainCatalog;
import link.lycreate.blog.model.SubCatalog;
import link.lycreate.blog.service.SubCatalogService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName SubCatalogServiceImpl
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/2/4 22:57
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SubCatalogServiceImpl implements SubCatalogService {
    @Autowired
    private SubCatalogMapper subCatalogMapper;
    @Autowired
    private MainCatalogMapper mainCatalogMapper;
    @Override
    public HashMap<String,Object> getCatalog(){
        System.out.println("service");
        HashMap<String,Object> catalogMap=new HashMap<>();
        List<MainCatalog> mainCatalogList=mainCatalogMapper.selectAllMainCatalog();
        System.out.println("mainCatalog"+mainCatalogList
        );
        Iterator<MainCatalog> iterator=mainCatalogList.iterator();
        while (iterator.hasNext()){
            MainCatalog mainCatalog=iterator.next();
            List<SubCatalog> subCatalogList=subCatalogMapper.selectSubcatalogByMainCatalogId(mainCatalog.getMainCatalogId());
            HashMap<String,String> subCatalogMap=new HashMap<>();
            Iterator<SubCatalog> iterator1=subCatalogList.iterator();
            while (iterator1.hasNext()){
                SubCatalog subCatalog=iterator1.next();
                subCatalogMap.put(new Integer(subCatalog.getSubCatalogId()).toString(),subCatalog.getName());
            }
            HashMap<String,Object> mainCatalogMap=new HashMap<>();
            mainCatalogMap.put("name",mainCatalog.getName());
            mainCatalogMap.put("subCatalog",subCatalogMap);
            catalogMap.put(new Integer(mainCatalog.getMainCatalogId()).toString(),mainCatalogMap );
        }
        catalogMap.put("result","success");
        System.out.println(catalogMap);
        return catalogMap;
    }

    @Override
    public List<SubCatalog> getSubCatalog(Integer mainCatalogId) {
        List<SubCatalog> list=subCatalogMapper.selectSubcatalogByMainCatalogId(mainCatalogId);
        return list;
    }

    @Override
    public int addSubCatalog(String name,int mainCatalogId) {
        return subCatalogMapper.inserSubCatalog(name,mainCatalogId);
    }

}
