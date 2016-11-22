package cn.qiuyiping.learn.controller.chapter;

import cn.qiuyiping.learn.modal.base.chapter.ChapterBase;
import cn.qiuyiping.learn.modal.base.example.ExampleBase;
import cn.qiuyiping.learn.service.chapter.ChapterService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public String index() {
        ExampleBase example = new ExampleBase();
        return "/chapter/index";
    }

    @ResponseBody
    @RequestMapping("/chapterTree")
    public Object chapterTree() {
        List<ChapterBase> list = chapterServiceImpl.queryAllTree();
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping("/saveTree")
    public Object saveTree(
            HttpServletRequest request,
            @RequestParam("deleteNodes") String deleteNodes,
            @RequestParam("tree") String tree
    ) {
        JsonParser parser = new JsonParser();
        JsonArray delNotes = parser.parse(deleteNodes).getAsJsonArray();
        JsonObject root = parser.parse(tree).getAsJsonObject();
        deleteNode(delNotes);
        updateNode(root, null, 0);
        return null;
    }

    public Long updateNode(JsonObject node, Long parentId, int level){
        JsonArray children = node.getAsJsonArray("children");
        if(parentId == null){
            parentId = 0l;
        }else {
            Long id = null;
            try {
                id = node.get("id").getAsLong();
            } catch (Exception e) {

            }
            int order = node.get("order").getAsInt();
            String title = node.get("title").getAsString();
            ChapterBase chapter = new ChapterBase();
            chapter.setId(id);
            chapter.setOrder(order);
            chapter.setTitle(title);
            chapter.setParentId(parentId);
            chapter.setLevel(level);
            parentId = chapterServiceImpl.updateNode(chapter);
        }

        for(JsonElement el : children){
            JsonObject jo = el.getAsJsonObject();
            updateNode(jo, parentId, ++level);
        }


        return null;
    }

    public void deleteNode(JsonArray nodes){
        for(JsonElement el : nodes ){
            try {
                JsonObject obj = el.getAsJsonObject();
                String idStr = obj.get("id").getAsString();
                long id = Long.parseLong(idStr);
                JsonArray children = obj.getAsJsonArray("children");
                deleteNode(children);
                ChapterBase chapter = new ChapterBase(id);
                chapterServiceImpl.deleteNode(chapter);
            }catch (NumberFormatException e){

            }
        }
    }

}
