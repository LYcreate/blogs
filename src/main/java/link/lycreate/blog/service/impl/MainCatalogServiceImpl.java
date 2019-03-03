package link.lycreate.blog.service.impl;

import link.lycreate.blog.dao.MainCatalogMapper;
import link.lycreate.blog.model.MainCatalog;
import link.lycreate.blog.service.MainCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MainCatalogServiceImpl
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/2/4 22:56
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class MainCatalogServiceImpl implements MainCatalogService {
    @Autowired
    private MainCatalogMapper mainCatalogMapper;
    @Override
    public List<MainCatalog> getMainCatalog() {
        List<MainCatalog> mainCatalogList=mainCatalogMapper.selectAllMainCatalog();
        return mainCatalogList;
    }

    @Override
    public int addMainCatalog(String name) {
        return mainCatalogMapper.insertMainCatalog(name);
    }

    @Override
    public int updateMainCatalog(String name, int mainCatalogId) {
        MainCatalog mainCatalog=new MainCatalog(mainCatalogId,name);
        return mainCatalogMapper.updateMainCatalog(mainCatalog);
    }

    @Override
    public int deleteMainCatalog(int mainCatalogId) {
        return mainCatalogMapper.deleteMainCatalogByMainCatalogId(mainCatalogId);
    }
}
