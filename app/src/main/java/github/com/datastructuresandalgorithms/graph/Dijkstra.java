package github.com.datastructuresandalgorithms.graph;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/13
 * Version  1.0
 * Description: 迪杰斯特拉算法 -----求最短路径
 * */

public class Dijkstra {

    private static final String  TAG = "Dijkstra";


    //定点个数
    private int vertexSize;
    //顶点数组
    private int[] vertexs;
    //边或者弧二维数组
    private int[][] matrix;
    //有向图 中的 无穷大 符号
    private static  final  int MAX_WEIGHT= 9999;

    private int[] shortTablePath = new int[vertexSize];

    /**
     * 最短路径
     */
    public void shortestPathDijkstra(){

        boolean[] isGetPath  =  new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            shortTablePath[i] = matrix[0][i];
        }

        shortTablePath[0] = 0;
        isGetPath[0] = true;
        int min = 0;
        int minId = 0;
        for (int i = 1; i < vertexSize; i++) {
            min = MAX_WEIGHT;
            for (int j = 0; j < vertexSize; j++) {
                if(!isGetPath[j] && shortTablePath[j] < min){
                    min = shortTablePath[j];
                    minId = j;
                }
            }

            isGetPath[minId] = true;

            for (int j = 0; j < vertexSize; j++) {
                if(!isGetPath[j] && (min+matrix[minId][j]) < shortTablePath[j]){
                    shortTablePath[j] = min + matrix[minId][j];
                }
            }
        }
        for (int i = 0; i < shortTablePath.length; i++) {
            Log.e(TAG,"V0--->V"+i+":"+shortTablePath[i]);
        }

    }

}
