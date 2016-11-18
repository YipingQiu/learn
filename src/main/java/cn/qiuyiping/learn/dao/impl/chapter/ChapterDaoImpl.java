package cn.qiuyiping.learn.dao.impl.chapter;

import cn.qiuyiping.learn.dao.chapter.ChapterDao;
import cn.qiuyiping.learn.modal.base.chapter.ChapterBase;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
@Repository("chapterDaoImpl")
public class ChapterDaoImpl implements ChapterDao {

    @Resource
    private HibernateTemplate hibernateTemplate;

    public List<ChapterBase> queryAllTree() {
        return hibernateTemplate.loadAll(ChapterBase.class);
    }
}
