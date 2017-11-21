package github.com.datastructuresandalgorithms.graph;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/12
 * Version  1.0
 * Description:克鲁斯卡尔算法
 */

public class Kruskal {

    private static final String TAG = "Kruskal";
    //边
    private Edge[] edges;
    //总的边数
    private int edgeSize;


    public Kruskal(Edge[] edges, int edgeSize) {
        this.edges = edges;
        this.edgeSize = edgeSize;
    }

    public void miniSpanTreeKruskal(){

        int sum = 0;
        int[] parent = new int[edgeSize];//神奇的数组，下标为起点，值为终点
        for(int i = 0 ;i<edgeSize;i++){
            parent[i] = 0;
        }
        int b,e = 0;
        for (int i = 0; i < edgeSize; i++) {

            b = find(parent,edges[i].begin);
            e = find(parent,edges[i].end);

            if(b != e){
                parent[b] = e;
                sum += edges[i].weight;
            }

        }

        Log.e(TAG ,"总的权值是："+sum);


    }

    /**
     * 寻找当前路径最后一个节点（判断是否有回环）
     * @param parent
     * @param index
     * @return
     */
    private int find(int[] parent, int index) {
        while (parent[index] > 0){
            index = parent[index];
        }
        return index;
    }


    /**
     * 边
     */
    public static class Edge{

        public int begin;
        public int end;
        public int weight;




    }

}
