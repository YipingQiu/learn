package cn.qiuyiping.learn.service.impl.chapter;

import cn.qiuyiping.learn.dao.chapter.ChapterDao;
import cn.qiuyiping.learn.modal.base.chapter.ChapterBase;
import cn.qiuyiping.learn.service.chapter.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
@Service(value = "chapterServiceImpl")
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDaoImpl;

    public List<ChapterBase> queryAllTree() {
        return chapterDaoImpl.queryAllTree();
    }

    public void deleteNode(ChapterBase chapter) {
        chapterDaoImpl.deleteNode(chapter);
    }

    public Long updateNode(ChapterBase chapter) {
        return chapterDaoImpl.updateNode(chapter);
    }
}
