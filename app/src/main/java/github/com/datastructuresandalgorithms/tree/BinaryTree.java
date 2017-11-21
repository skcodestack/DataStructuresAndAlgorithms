package github.com.datastructuresandalgorithms.tree;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/7
 * Version  1.0
 * Description: 二叉树
 */

public class BinaryTree<T> {

    private String TAG = "BinaryTree";


    //根节点
    private TreeNode<T> rootTree;

    public BinaryTree() {
    }

    public BinaryTree(TreeNode<T> rootTree) {
        this.rootTree = rootTree;
    }


    /**
     * 获取当前树结点的大小
     * @return
     */
    public int getSize(){
        return getSize(rootTree);
    }
    /**
     * 获取指定结点下的大小
     * @param node
     * @return
     */
    public int getSize(TreeNode node){

        if(node == null){
            return 0;
        }

        return 1 + getSize(node.lchild) + getSize(node.rchild);

    }


    /**
     * 获取当前树的深度
     * @return
     */
    public int getDeepHeight(){
      return   getDeepHeigth(rootTree);
    }

    /**
     * 获取指定结点的深度
     * @param node
     * @return
     */
    public int  getDeepHeigth(TreeNode node){

        if(node == null){
            return 0;
        }

        int ldeepHeigth = getDeepHeigth(node.lchild);
        int rdeepHeigth = getDeepHeigth(node.rchild);

        return Math.max(ldeepHeigth,rdeepHeigth)+1;


    }


    /**
     * 前序遍历
     */
    public void preOrderTraverse(){
        preOrderTraverse(rootTree);
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrderTraverse(TreeNode node){
        if(node == null){
            Log.e(TAG,"data=======> null ");
            return;
        }

        Log.e(TAG,"data=======>"+node.data);
        preOrderTraverse(node.lchild);
        preOrderTraverse(node.rchild);

    }

    /**
     * 前序遍历----非迭代
     * @param node
     */
    public void nonPreOrderTraverse(TreeNode node){

        Stack<TreeNode> stack = new Stack<>();
        if(node == null){
            return;
        }

        stack.push(node);

        while (!stack.isEmpty()){

            TreeNode pop = stack.pop();
            Log.e(TAG,"data=======>"+pop);
            if(pop.rchild != null){
                stack.push(pop.rchild);
            }
            if(pop.lchild != null){
                stack.push(pop.lchild);
            }
        }

    }

    /**
     * 中序遍历
     */
    public void midOrderTraverse(){
        midOrderTraverse(rootTree);
    }
    /**
     * 中序遍历
     * @param node
     */
    public void midOrderTraverse(TreeNode node){
        if(node == null){
            return;
        }

        midOrderTraverse(node.lchild);
        Log.e(TAG,"data=======>"+node.data);
        midOrderTraverse(node.rchild);

    }

    /**
     * 中序遍历----非迭代
     * @param node
     */
    public void nonMidOrderTraverse(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();
        if(node == null){
            return;
        }

        TreeNode lchild = node.lchild;

        TreeNode rchild = node.rchild;

    }


    /**
     * 后序遍历
     * @param node
     */
    public void postOrderTraverse(TreeNode node){

        if(node == null){
            return;
        }

        postOrderTraverse(node.lchild);
        postOrderTraverse(node.rchild);
        Log.e(TAG,"data=======>"+node.data);

    }

    /**
     * 后序遍历----非迭代
     * @param node
     */
    public void nonPostOrderTraverse(TreeNode node){

    }


    /**
     * 根据前序遍历结果  生成对应的二叉树
     *
     *
     *               A
     *           B       C
     *        D    #   F   G
     *     #    #     # # # #
     *
     *     ABD###CF##G##
     *
     */
    public void createBinaryTreePre(String data){

        LinkedList<String> linkedList = new LinkedList<>();

        char[] chars = data.toCharArray();
        for (char c : chars) {
            //入队列
            linkedList.offer(String.valueOf(c));
        }

        createBinaryTreePre(linkedList.size(),linkedList);


    }

    /**
     * 根据前序遍历结果  生成对应的二叉树
     * @param size
     * @param linkedList
     * @return
     */
    private TreeNode createBinaryTreePre(int size, LinkedList<String> linkedList) {

        if(linkedList == null || linkedList.isEmpty()){
            return null;
        }
        int currentSize = linkedList.size();
        int index = size - currentSize;
        //出队列
        String poll = linkedList.poll();
        if("#".equals(poll)){
            return null;
        }

        TreeNode node = new TreeNode(0,poll);
        if(index == 0 ){
            rootTree =   node;
        }
        node.lchild = createBinaryTreePre(size,linkedList);
        node.rchild = createBinaryTreePre(size,linkedList);

        return node;
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


        public TreeNode(int index,T data, TreeNode lchild, TreeNode rchild) {
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
