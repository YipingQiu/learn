package cn.qiuyiping.learn.dao.impl.chapter;

import cn.qiuyiping.learn.dao.chapter.ChapterDao;
import cn.qiuyiping.learn.modal.base.chapter.ChapterBase;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
@Repository("chapterDaoImpl")
public class ChapterDaoImpl implements ChapterDao {

    @Resource
    private HibernateTemplate hibernateTemplate;

    public List<ChapterBase> queryAllTree() {
        return (List<ChapterBase>) hibernateTemplate.find("from ChapterBase chapter where chapter.deleted=0");
//        return hibernateTemplate.loadAll(ChapterBase.class);
    }

    public void deleteNode(ChapterBase chapter) {
        String hql = "update ChapterBase chapter set chapter.deleted=-1 where chapter.id=?";
        hibernateTemplate.bulkUpdate(hql, chapter.getId());
    }

    public Long updateNode(ChapterBase chapter) {
//        hibernateTemplate.saveOrUpdate(chapter);
        Long id = null;
        if(chapter.getId() == null) {
            Serializable s = hibernateTemplate.save(chapter);
            id = Long.parseLong(s.toString());
        }else{
            hibernateTemplate.update(chapter);
            id = chapter.getId();
        }

        return id;
    }
}
