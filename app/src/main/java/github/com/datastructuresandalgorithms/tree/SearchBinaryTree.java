package github.com.datastructuresandalgorithms.tree;

import java.util.Comparator;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/9
 * Version  1.0
 * Description: 查找二叉树
 */

public class SearchBinaryTree<T extends Comparable<? super T>>{

    private String TAG = "SearchBinaryTree";


    //根节点
    private TreeNode<T> rootTree;


    /**
     * 带顺序的插入
     * @param val
     * @return
     */
    public TreeNode<T> insert(T val){

        return insert(val,rootTree);
    }
    /**
     * 带顺序的插入
     * @param val
     * @return
     */
    public TreeNode<T> insert(T val, TreeNode<T> t){

        if(t == null){
            return new TreeNode(0, val);
        }

        int compareTo = val.compareTo(t.data);

        if(compareTo < 0){
            t.lchild = insert(val,t.lchild);
        }else if(compareTo > 0){
            t.rchild = insert(val,t.rchild);
        }else {

        }

        return t;

    }


    /**
     *  不带顺序的插入
     * @param val
     * @return
     */
    public TreeNode<Integer> insertNoOrder(int val){

        TreeNode<Integer> node = null;
        TreeNode<Integer> parent = null;

        if(rootTree == null ){
            //创建根节点
            node = new TreeNode(0,val);
            rootTree = (TreeNode<T>) node;
        }else {
            //添加子节点
            node = (TreeNode<Integer>) rootTree;


            while (node != null){
                parent = node;
                int data = node.data;

                if(val < data){
                    node = parent.lchild;
                }else if(val > data){
                    node = parent.rchild;
                }else {
                    return node;
                }
            }

            if(parent != null){

                node = new TreeNode<Integer>(0,val);

                int data = parent.data;
                if(val < data){
                    parent.lchild = node;
                }else if(val > data){
                    parent.rchild = node;
                }

                return node;

            }
        }
        return node;
    }

    /**
     * 删除指定节点，并且调整树结构
     * @param val
     * @return
     */
    public TreeNode<T> remove(T val){
        return remove(val,rootTree);
    }


    public TreeNode<T> remove(T val,TreeNode<T> t){
        if(t == null){
            return t;
        }

        int compareTo = val.compareTo(t.data);

        if(compareTo < 0){
            t.lchild = remove(val,t.lchild);
        }else if(compareTo > 0){
            t.rchild = remove(val,t.rchild);
        }else if(t.lchild != null && t.rchild != null){
            t.data = (T) findMin(t.rchild).data;
            t.rchild = remove(t.data,t.rchild);

        }else {
            t = (t.lchild != null)?t.lchild:t.rchild;
        }

        return t;
    }

    /**
     * 查找当前节点中最小的节点
     * @param t
     * @return
     */
    public TreeNode<T> findMin(TreeNode<T> t){
        if(t != null){
            while (t.lchild != null){
                t = t.lchild;
            }
        }
        return t;
    }


    /**
     * 树结点
     * @param <T>
     */
    public static class TreeNode<T>{

        public int index;
        public T data;
        public TreeNode lchild;
        public TreeNode rchild;


        public TreeNode(int index, T data, TreeNode lchild, TreeNode rchild) {
            this.index = index;
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
        }

        public TreeNode(int index,T data) {
            this.index = index;
            this.data = data;
        }

    }

}
