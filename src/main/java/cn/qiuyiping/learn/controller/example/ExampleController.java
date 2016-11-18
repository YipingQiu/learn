package cn.qiuyiping.learn.controller.example;

import cn.qiuyiping.learn.modal.base.example.ExampleBase;
import cn.qiuyiping.learn.modal.base.example.ExampleLearnBase;
import cn.qiuyiping.learn.service.example.ExampleService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
@Controller
@RequestMapping("/example")
public class ExampleController {

    @Autowired
    private ExampleService exampleServiceImpl;

    @RequestMapping("/index")
    public String index(){
        ExampleBase example = new ExampleBase();
//        example.setTitle("新增一条数据");
//        example.setContent("这是数据");
//        example.setTranslation("这是翻译");
//        exampleServiceImpl.add(example);
//        List<ExampleBase> list = exampleServiceImpl.queryAll();
        return "/example/index";
    }

    @ResponseBody
//    @RequestMapping(value = "/exampleLearnList", produces = "application/json; charset=utf-8")
    @RequestMapping("/exampleLearnList")
    public Object exampleLearnList(){
        List<ExampleBase> list = exampleServiceImpl.queryAll();
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/resBody")
    public String resBody(String zh){
        System.out.println(zh);
        return "我的天坑！！！";
    }

    @ResponseBody
    @RequestMapping(value = "/exampleLearnAdd")
    public Object exampleLearnAdd(String chapter, String example){
        System.out.println(chapter);
        System.out.println(example);
        ExampleLearnBase elb = new ExampleLearnBase();
        elb.setCreateTime(new Date());
        elb.setChapterId(1L);
        elb.setDeleted((byte)1);
        elb.setExampleId(1L);
        exampleServiceImpl.addExampleLearn(elb);
        JsonObject jo = new JsonObject();
        jo.addProperty("success","true");
        return jo;
    }


    @RequestMapping("/addElb")
    public String addElb(){
        ExampleLearnBase elb = new ExampleLearnBase();
        elb.setCreateTime(new Date());
        elb.setChapterId(1L);
        elb.setDeleted((byte)1);
        elb.setExampleId(1L);
        exampleServiceImpl.addExampleLearn(elb);
        return "/example/addElb";
    }
}
