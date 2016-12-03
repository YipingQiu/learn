package cn.qiuyiping.learn.dao.impl.example;

import cn.qiuyiping.learn.dao.example.ExampleDao;
import cn.qiuyiping.learn.modal.base.example.ExampleBase;
import cn.qiuyiping.learn.modal.base.example.ExampleLearnBase;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
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
        return (List<ExampleBase>) hibernateTemplate.find("select new ExampleBase(title) from ExampleBase elb where elb.id = 10");
//        return (List<ExampleBase>) hibernateTemplate.find("select new ExampleLearnBase(createTime) from ExampleLearnBase elb, ExampleBase eb where elb.example.id = eb.id");
//        return hibernateTemplate.loadAll(ExampleBase.class);
    }

    public void addExampleLearn(ExampleLearnBase elb) {
        hibernateTemplate.save(elb);
    }

    public List<ExampleLearnBase> queryElbAll() {

        return (List<ExampleLearnBase>) hibernateTemplate.find("select new ExampleLearnBase(elb.id,elb.chapterId,elb.createTime,elb.updateTime,elb.deleted,eb.id,eb.title,eb.content,eb.translation) from ExampleLearnBase elb, ExampleBase eb where elb.example.id = eb.id");
    }

    public ExampleLearnBase fetchExampleLearnById(Long id) {
        List<ExampleLearnBase> list = (List<ExampleLearnBase>) hibernateTemplate.find("select new ExampleLearnBase(elb.id,elb.chapterId,elb.createTime,elb.updateTime,elb.deleted,eb.id,eb.title,eb.content,eb.translation) from ExampleLearnBase elb, ExampleBase eb where elb.example.id = eb.id and elb.id = ?",id);
        if(list == null || list.size() == 0){
            return new ExampleLearnBase();
        }else{
            return list.get(0);
        }
    }

    public void save(ExampleBase el) {
        hibernateTemplate.update(el);
    }

}
