package cn.qiuyiping.learn.modal.base.example;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/2.
 */
@Entity
@Table(name = "example")
public class ExampleBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //范例id

    private String title;   //范例标题

    private String content; //范例内容

    private String translation; //范例中文翻译

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
