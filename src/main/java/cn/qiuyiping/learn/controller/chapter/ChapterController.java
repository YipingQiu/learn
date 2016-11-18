package cn.qiuyiping.learn.controller.chapter;

import cn.qiuyiping.learn.modal.base.chapter.ChapterBase;
import cn.qiuyiping.learn.modal.base.example.ExampleBase;
import cn.qiuyiping.learn.service.chapter.ChapterService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterServiceImpl;

    @RequestMapping("/index")
    public String index(){
        ExampleBase example = new ExampleBase();
        return "/chapter/index";
    }

    @ResponseBody
    @RequestMapping("/chapterTree")
    public Object chapterTree(){
        List<ChapterBase> list = chapterServiceImpl.queryAllTree();
        return new Gson().toJson(list);
    }

}
