package github.com.datastructuresandalgorithms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

import github.com.datastructuresandalgorithms.algorithms.sort.exchangesort.BubbleSort;
import github.com.datastructuresandalgorithms.algorithms.sort.insertsort.BinaryInsertSort;
import github.com.datastructuresandalgorithms.algorithms.sort.insertsort.HeerSort;
import github.com.datastructuresandalgorithms.algorithms.sort.insertsort.InsertSort;
import github.com.datastructuresandalgorithms.algorithms.sort.selectionsort.HeapSort;
import github.com.datastructuresandalgorithms.algorithms.sort.selectionsort.SelectSort;
import github.com.datastructuresandalgorithms.map.hashmap.StoneHashMap;
import github.com.datastructuresandalgorithms.stack.InversePolandExpression;
import github.com.datastructuresandalgorithms.tree.BinaryTree;


/**
 * Alt + 7
 * Ctrl + H
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 测试 hashmap
     * @param view
     */
    public void btn_hashmap(View view){



        StoneHashMap<String,String> map =new StoneHashMap<>();

        map.put("111","aaaa");
        map.put("222","aaaa");
        map.put("333","aaaa");
        map.put("444","aaaa");
        map.put("555","aaaa");
        map.put("666","aaaa");
        map.put("777","aaaa");
        map.put("888","aaaa");
        map.put("999","aaaa");
        map.put("000","aaaa");

        Log.e("MainActivity","=================>"+map.get("555")+"-----size："+map.size());
        //看存储结构
        map.showStorgeStructure();

    }

    /**
     * 使用栈计算数学表达式
     * @param view
     */
    public void InversePolandExpression(View view){

//        Queue

        String expression_str = "9+(3-1)*3+10/2";
        InversePolandExpression  expression = new InversePolandExpression(expression_str);
        String s = expression.calculateExpression();
        Log.e("MainActivity","InversePolandExpression=================>"+s);
    }

    /**
     *          A
     *      B       C
     *   D    E   F   G
     *
     * @param view
     */
    public void binaryTree(View view){


        BinaryTree.TreeNode<String> DTree  = new BinaryTree.TreeNode(4,"D",null,null);
        BinaryTree.TreeNode<String> ETree  = new BinaryTree.TreeNode(5,"E",null,null);
        BinaryTree.TreeNode<String> FTree  = new BinaryTree.TreeNode(6,"F",null,null);
        BinaryTree.TreeNode<String> GTree  = new BinaryTree.TreeNode(7,"G",null,null);
        BinaryTree.TreeNode<String> BTree  = new BinaryTree.TreeNode(2,"B",DTree,ETree);
        BinaryTree.TreeNode<String> CTree  = new BinaryTree.TreeNode(2,"C",FTree,GTree);
        BinaryTree.TreeNode<String> ATree  = new BinaryTree.TreeNode(1,"A",BTree,CTree);



        BinaryTree<String> tree = new BinaryTree(ATree);
//        tree.preOrderTraverse();
//        tree.midOrderTraverse();

        BinaryTree<String> ctree = new BinaryTree();
//        ctree.createBinaryTreePre("ABD###CF##G##");
//        ctree.preOrderTraverse();

        int[] val = new int[]{50,30,20,44,88,33,87,16,7,77};
        for (int i : val) {
//            ctree.putTreeNode(i);
        }
        ctree.midOrderTraverse();



    }


    public void sort(View view){

        int[] val = new int[]{50,30,20,44,88,33,87,16,7,77};


//        SelectSort selectSort = new SelectSort();
//        selectSort.sort(val);

//        BubbleSort bubbleSort  = new BubbleSort();
//        bubbleSort.sort(val);

//        InsertSort insertSort = new InsertSort();
//        insertSort.sort(val);


//        BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
//        binaryInsertSort.sort(val);

//        HeerSort heerSort = new HeerSort();
//        heerSort.sort(val);


        HeapSort heapSort = new HeapSort();
        heapSort.sort(val);

    }

}
