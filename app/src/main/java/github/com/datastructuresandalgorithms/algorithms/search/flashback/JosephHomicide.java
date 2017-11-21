package github.com.datastructuresandalgorithms.algorithms.search.flashback;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/20
 * Version  1.0
 * Description:约瑟夫杀人
 */

public class JosephHomicide {


    /**
     *
     * @param head  头节点
     * @param M     数到几杀人
     */
    public void run(Node head,int M){

        if(head == null){
            return;
        }

        Node next = head.next;
        while (next != next.next){

            for (int i = 1; i < M; i++) {
                next = next.next;
            }
            //被杀掉的点
            Node node = next.next;
            next.next = node.next;

            System.out.println("被杀掉："+node.index);

        }

    }




    class Node {

        public  int index;
        public Node next;


        public Node(int index, Node next) {
            this.index = index;
            this.next = next;
        }
    }


}
