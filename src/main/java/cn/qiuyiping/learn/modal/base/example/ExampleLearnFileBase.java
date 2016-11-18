package cn.qiuyiping.learn.modal.base.example;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/2.
 */
@Entity
@Table(name = "examplelearnfile")
public class ExampleLearnFileBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //附件Id

    private Long exampleLearnBaseId;    //附件对应的范例学习Id

    private byte deleted;   //是否删除，1为未删除，可展示，0为已删除，不在前端中展示

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public Long getExampleLearnBaseId() {
        return exampleLearnBaseId;
    }

    public void setExampleLearnBaseId(Long exampleLearnBaseId) {
        this.exampleLearnBaseId = exampleLearnBaseId;
    }
}
