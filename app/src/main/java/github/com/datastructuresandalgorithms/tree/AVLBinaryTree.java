package github.com.datastructuresandalgorithms.tree;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/9
 * Version  1.0
 * Description: 带有平衡条件的查找二叉树 
 *              目的是：解决查找二叉树中频繁的插入和删除导致二叉树不平衡
 */

public class AVLBinaryTree<T extends Comparable<? super T>> {

    private String TAG = "AVLBinaryTree";


    //根节点
    private TreeNode<T> rootTree;


    //单旋转
    //双旋转


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
