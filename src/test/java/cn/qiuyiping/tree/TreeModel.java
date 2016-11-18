package cn.qiuyiping.tree;

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */
public class TreeModel {

    private int id;
    private int pid;
    private int order;
    private String text;
    private TreeModel parentId;
    private TreeModel leftChild;
    private TreeModel rightChild;
    private List<TreeModel> children;

    public TreeModel(int id){
        this.id = id;
    }

    public TreeModel(int id, int pid, int order, String text) {
        this.id = id;
        this.pid = pid;
        this.order = order;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TreeModel getParentId() {
        return parentId;
    }

    public void setParentId(TreeModel parentId) {
        this.parentId = parentId;
    }

    public TreeModel getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeModel leftChild) {
        this.leftChild = leftChild;
    }

    public TreeModel getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeModel rightChild) {
        this.rightChild = rightChild;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<TreeModel> getChildren() {
        return children;
    }

    public void setChildren(List<TreeModel> children) {
        this.children = children;
    }
}
