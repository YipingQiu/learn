package cn.qiuyiping.learn.service.example;

import cn.qiuyiping.learn.modal.base.example.ExampleBase;
import cn.qiuyiping.learn.modal.base.example.ExampleLearnBase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
public interface ExampleService {

//    @Transactional(readOnly = false)
    public void add(ExampleBase exampleBase);

    public List<ExampleBase> queryAll();

    public void addExampleLearn(ExampleLearnBase elb);
}
