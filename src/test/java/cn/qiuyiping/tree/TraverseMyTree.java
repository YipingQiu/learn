package cn.qiuyiping.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/17.
 */
public class TraverseMyTree {
    public static void main(String[] args){
        ArrayList<TreeModel> treeList = new ArrayList<TreeModel>();
        treeList.add(new TreeModel(1, 0, 1, "1"));
        treeList.add(new TreeModel(2, 0, 2, "2"));
        treeList.add(new TreeModel(3, 0, 3, "3"));
        treeList.add(new TreeModel(4, 1, 1, "1.1"));
        treeList.add(new TreeModel(5, 1, 2, "1.2"));
        treeList.add(new TreeModel(6, 2, 1, "2.1"));
        TreeModel lastTree = treeSort(treeList);
        traverseTree(lastTree);

    }

    private static void traverseTree(TreeModel tree) {
        List<TreeModel> list = tree.getChildren();
        if(list != null){
            for(int i = 0; i < list.size(); i++){
                TreeModel child = list.get(i);
                traverseTree(child);
            }
        }
        System.out.println(tree.getText());

    }

    private static TreeModel treeSort(ArrayList<TreeModel> treeList) {
        TreeModel root = new TreeModel(-1, -1, -1, "root");
        root.setChildren(new ArrayList<TreeModel>());
        Map<Integer, TreeModel> map = new HashMap<Integer, TreeModel>();
        for(int i = 0; i < treeList.size(); i++){
            TreeModel tree = treeList.get(i);
            map.put(tree.getId(), tree);
        }
        for(int i = 0; i < treeList.size(); i++){
            TreeModel tree = treeList.get(i);
            TreeModel pTree = map.get(tree.getPid());
            if(pTree == null){
                root.getChildren().add(tree);
            }else{
                if(pTree.getChildren() == null){
                    pTree.setChildren(new ArrayList<TreeModel>());
                }
                pTree.getChildren().add(tree);
            }
        }
        return root;
    }
}
