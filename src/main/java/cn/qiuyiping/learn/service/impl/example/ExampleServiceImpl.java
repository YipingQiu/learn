package cn.qiuyiping.learn.service.impl.example;

import cn.qiuyiping.learn.dao.example.ExampleDao;
import cn.qiuyiping.learn.modal.base.example.ExampleBase;
import cn.qiuyiping.learn.modal.base.example.ExampleLearnBase;
import cn.qiuyiping.learn.service.example.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
@Service(value = "exampleServiceImpl")
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleDao exampleDaoImpl;

    public void add(ExampleBase exampleBase) {
        exampleDaoImpl.add(exampleBase);
    }

    public List<ExampleBase> queryAll() {
        return exampleDaoImpl.queryAll();
    }

    public void addExampleLearn(ExampleLearnBase elb) {
        exampleDaoImpl.addExampleLearn(elb);
    }
}
