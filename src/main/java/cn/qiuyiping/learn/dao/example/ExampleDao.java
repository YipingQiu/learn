package cn.qiuyiping.learn.dao.example;

import cn.qiuyiping.learn.modal.base.example.ExampleBase;
import cn.qiuyiping.learn.modal.base.example.ExampleLearnBase;

import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
public interface ExampleDao {

    public void add(ExampleBase exampleBase);

    public List<ExampleBase> queryAll();

    public void addExampleLearn(ExampleLearnBase elb);

    public List<ExampleLearnBase> queryElbAll();

    public ExampleLearnBase fetchExampleLearnById(Long id);

    public void save(ExampleBase el);
}
