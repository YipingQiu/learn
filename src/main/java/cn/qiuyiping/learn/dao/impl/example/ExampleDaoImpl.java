package cn.qiuyiping.learn.dao.impl.example;

import cn.qiuyiping.learn.dao.example.ExampleDao;
import cn.qiuyiping.learn.modal.base.example.ExampleBase;
import cn.qiuyiping.learn.modal.base.example.ExampleLearnBase;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
//@Component("")
@Repository("exampleDaoImpl")
public class ExampleDaoImpl implements ExampleDao {

    @Resource
    private HibernateTemplate hibernateTemplate;

    public void add(ExampleBase exampleBase) {
        hibernateTemplate.save(exampleBase);
    }

    public List<ExampleBase> queryAll() {
        return hibernateTemplate.loadAll(ExampleBase.class);
    }

    public void addExampleLearn(ExampleLearnBase elb) {
        hibernateTemplate.save(elb);
    }
}
