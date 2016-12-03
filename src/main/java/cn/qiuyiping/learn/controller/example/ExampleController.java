package cn.qiuyiping.learn.controller.example;

import cn.qiuyiping.learn.modal.base.example.ExampleBase;
import cn.qiuyiping.learn.modal.base.example.ExampleLearnBase;
import cn.qiuyiping.learn.service.example.ExampleService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
    public String index() {
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
    public Object exampleLearnList() {
//        List<ExampleBase> list = exampleServiceImpl.queryAll();
        List<ExampleLearnBase> list = exampleServiceImpl.queryElbAll();
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/resBody")
    public String resBody(String zh) {
        System.out.println(zh);
        return "我的天坑！！！";
    }

    @ResponseBody
    @RequestMapping(value = "/exampleLearnAdd")
    public Object exampleLearnAdd(String chapter, String example) {
        ExampleBase el = new ExampleBase();
        el.setTitle(example);
        exampleServiceImpl.add(el);
        ExampleLearnBase elb = new ExampleLearnBase();
        elb.setCreateTime(new Date());
        elb.setChapterId(Long.parseLong(chapter));
        elb.setDeleted((byte) 1);
        elb.setExample(el);
        exampleServiceImpl.addExampleLearn(elb);
        JsonObject jo = new JsonObject();
        jo.addProperty("success", "true");
        return jo;
    }

    //    exampleLearnDetailSubmit
    @ResponseBody
    @RequestMapping(value = "/exampleLearnDetailSubmit")
    public Object exampleLearnDetailSubmit(Long id, String content, String translation) {
        ExampleBase el = new ExampleBase();
        el.setId(id);
        el.setContent(content);
        el.setTranslation(translation);
        exampleServiceImpl.save(el);
        JsonObject jo = new JsonObject();
        jo.addProperty("success", "true");
        return jo;
    }


    @ResponseBody
    @RequestMapping(value = "/fetchExampleLearnById")
    public Object fetchExampleLearnById(Long id) {
        return new Gson().toJson(exampleServiceImpl.fetchExampleLearnById(id));
    }


//    @RequestMapping("/addElb")
//    public String addElb(){
//        ExampleLearnBase elb = new ExampleLearnBase();
//        elb.setCreateTime(new Date());
//        elb.setChapterId(1L);
//        elb.setDeleted((byte)1);
//        elb.setExample(new ExampleBase());
//        exampleServiceImpl.addExampleLearn(elb);
//        return "/example/addElb";
//    }
}
