package github.com.datastructuresandalgorithms.graph;

import android.util.Log;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/10
 * Version  1.0
 * Description: 图
 */

public class Graph<T> {

    private static final String  TAG = "Graph";


    //定点个数
    private int vertexSize;
    //顶点数组
    private T[] vertexs;
    //边或者弧二维数组
    private int[][] matrix;
    //有向图 中的 无穷大 符号
    private static  final  int MAX_WEIGHT= 9999;

    private boolean[]  isVisited;

    public Graph(int vertexSize){
        this.vertexSize = vertexSize;
        vertexs = (T[]) new Object[vertexSize];
        matrix = new int[vertexSize][vertexSize];
        isVisited = new boolean[vertexSize];

        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }
    }


    /**
     * 深度优先遍历
     * @param i
     */
    private void depthfristsearch(int i){

        isVisited[i] = true;
        Log.e(TAG,"元素的值====>"+vertexs[i]);
        for (int j = 0; j < vertexSize; j++) {
            int item = matrix[i][j];

            if(item > 0 && item < MAX_WEIGHT && !isVisited[i]){
                Log.e(TAG,"<"+vertexs[i]+","+vertexs[j]+"> 权重====>"+item);
                depthfristsearch(j);
            }
        }

    }
    /**
     * 深度优先遍历 depth frist search
     */
    public void DFSTraverse(){

        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }

        for (int i = 0; i < vertexSize; i++) {

            if(!isVisited[i]){
                depthfristsearch(i);
            }

        }

    }

    /**
     * 广度优先遍历 border  frist search
     */
    public void BFSTraverse() {
        //队列
        LinkedList<Integer> queue = new LinkedList<>();


        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }

        for (int i = 0; i < vertexSize; i++) {

            if(!isVisited[i]){

                isVisited[i] = true;

                Log.e(TAG,"ITEM  VALUE =====>"+vertexs[i]);
                //入队
                queue.offer(i);

                while (!queue.isEmpty()){
                    //出队
                    int  pop = queue.peek();
                    for (int j = 0; j <vertexSize; j++) {
                        int item = matrix[pop][j];
                        if(item > 0 && item < MAX_WEIGHT && !isVisited[j]){
                            //Log.e(TAG,"<"+vertexs[i]+","+vertexs[j]+"> 权重====>"+item);
                            isVisited[j] = true;
                            //入队
                            queue.offer(j);
                        }
                    }

                }

            }

        }


    }


}
