package github.com.datastructuresandalgorithms.graph;

import android.util.Log;

import java.util.Stack;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/13
 * Version  1.0
 * Description: 拓扑排序------AOV活动网（Activity On Vertex Network）
 */

public class Topological {

    private static final String TAG = "Topological";

    VertexNode[] vertexList = null;
    int vertexSize = 0;

    public Topological(VertexNode[] vertexList) {
        this.vertexList = vertexList;
        this.vertexSize = vertexList.length;
    }

    /**
     * 拓扑排序
     */
    public void topoLogicalOrder(){

        //保存下标
        Stack<Integer> stack  = new Stack<>();
        int count = 0;
        //将入度为0的顶点入栈
        for (int i = 0; i < vertexSize; i++) {
            if(vertexList[i].in == 0){
                stack.push(i);
            }
        }

        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            Log.e(TAG,"顶点："+vertexList[pop].data);
            count++;
            for (EdgeNode node = vertexList[pop].fristedge;node != null;node = node.next){
                int adjvex = node.adjvex;
                //入度减一
                vertexList[adjvex].in -= 1;
                if(vertexList[adjvex].in == 0){
                    ////入度为0  入栈
                    stack.push(adjvex);
                }
            }
        }

        if(count < vertexSize){
            Log.e(TAG,"拓扑排序失败！");
        }else {
            Log.e(TAG,"拓扑排序成功！");
        }


    }




    /**
     * 顶点
     */
    public  static class VertexNode{




        public int in;
        public String data;
        public EdgeNode fristedge;

    }


    /**
     * 邻接点
     */
    public static class EdgeNode{

        public int adjvex;
        public EdgeNode next;



    }



}
