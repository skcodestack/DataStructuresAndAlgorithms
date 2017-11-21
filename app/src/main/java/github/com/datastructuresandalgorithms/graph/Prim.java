package github.com.datastructuresandalgorithms.graph;

import android.util.Log;

import java.util.LinkedList;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/12
 * Version  1.0
 * Description: 普里姆算法---求连通网最小生成树
 */

public class Prim {
    private static final String TAG = "Prim";
    //定点个数
    private int vertexSize;

    //顶点数组
    private int[] vertexs;
    //边或者弧二维数组
    private int[][] matrix;
    //有向图 中的 无穷大 符号
    private static  final  int MAX_WEIGHT= 9999;


    public  void  make(){

        int [] lowcost = new int[vertexSize];//最小代价顶点权值的数组,为0表示已经获取最小权值
        int [] adjvex = new int[vertexSize]; //放顶点权值
        LinkedList<Integer> verOrder = new LinkedList<>();

        for (int i = 0; i < vertexSize; i++) {
            lowcost[i] = matrix[0][i];
            adjvex[i] = 0;
        }
        verOrder.offer(0);

        //行中的最小值
        int  min = MAX_WEIGHT;
        //最小值的下标
        int minId = 0;
        //行
        for (int i = 1; i < vertexSize; i++) {

            for (int j = 1; j < vertexSize; j++) {
                if(lowcost[j] < min && lowcost[j] > 0){
                    min = lowcost[j];
                    minId = j;
                }
            }

            lowcost[minId] = 0;
            adjvex[minId] = min;
            verOrder.offer(minId);

            for (int j = 1; j < vertexSize; j++) {

                if(lowcost[j] != 0 && lowcost[j] > matrix[minId][j]){
                    lowcost[j] = matrix[minId][j];
                }
            }
        }


        while (!verOrder.isEmpty()){
            Integer peek = verOrder.peek();

            Log.e(TAG ,"图链接："+peek);
        }


        int sum = 0;
        for (int i : adjvex) {
            sum += i;
        }

        Log.e(TAG ,"总的权值是："+sum);

    }


}
