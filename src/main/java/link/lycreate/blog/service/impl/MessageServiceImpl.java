package link.lycreate.blog.service.impl;

import link.lycreate.blog.dao.MessageMapper;
import link.lycreate.blog.model.Brief;
import link.lycreate.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MessageServiceImpl
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/2/4 22:57
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    /**
     * description
     * @author LYcreate
     * @date 2019/2/14 10:44
     * @param pageNow
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @Override
    public Map<String, Object> getAllMessage(Integer pageNow) {
        Integer totalMessage=messageMapper.selectCount();
        Integer pageSize=10;
        Integer startPos=(pageNow-1)*pageSize;
        Integer querySize=((totalMessage-startPos)>=pageSize)?pageSize:(totalMessage-startPos);
        System.out.println("totalMessage:"+totalMessage+"\nstartPos:"+startPos+"\nquerySize:"+querySize);
        List<Brief> briefList=messageMapper.selectAllBrief(startPos,querySize);
        HashMap<String,Object> pageMap=new HashMap<>();
        System.out.println(briefList);
        pageMap.put("briefList",briefList);
        pageMap.put("totalMessage",totalMessage);
        return pageMap;
    }

    /**
     * description
     * @author LYcreate
     * @date 2019/2/12 21:52
     * @param catalogId
    pageNow
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @Override
    public Map<String, Object> getPage(String mainSub,Integer catalogId,Integer pageNow) {
        Integer totalMessage;
        Integer pageSize=10;
        Integer startPos=(pageNow-1)*pageSize;
        List<Brief> briefList;
        if (mainSub.equals("main")) {
            totalMessage=messageMapper.selectCountByMain(catalogId);
            Integer querySize=((totalMessage-startPos)>=pageSize)?pageSize:(totalMessage-startPos);
            briefList = messageMapper.selectBriefByMain(catalogId, startPos, querySize);
        }else {
            totalMessage=messageMapper.selectCountBySub(catalogId);
            Integer querySize=((totalMessage-startPos)>=pageSize)?pageSize:(totalMessage-startPos);
            briefList = messageMapper.selectBriefBySub(catalogId, startPos, querySize);
        }
        Map<String,Object> pageMap=new HashMap<>();
        pageMap.put("briefList",briefList);
        pageMap.put("totalMessage",totalMessage);
        return pageMap;
    }

    @Override
    public Map<String, Object> getMessage(String messageId) {
        return null;
    }
}
