package cn.qiuyiping.learn.dao.chapter;

import cn.qiuyiping.learn.modal.base.chapter.ChapterBase;

import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
public interface ChapterDao {

    public List<ChapterBase> queryAllTree();
}
