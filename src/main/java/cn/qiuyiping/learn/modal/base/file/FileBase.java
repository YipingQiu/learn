package cn.qiuyiping.learn.modal.base.file;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/2.
 */
@Entity
@Table(name = "file")
public class FileBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //文件id

    private String storeName;   //文件存储名称

    private String realName;    //文件真实名称

    private String storePath;   //文件存储路径

    private Date uploadTime;    //文件上传时间

    private byte deleted;   //是否删除，1为未删除，可展示，0为已删除，不在前端中展示

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }
}
