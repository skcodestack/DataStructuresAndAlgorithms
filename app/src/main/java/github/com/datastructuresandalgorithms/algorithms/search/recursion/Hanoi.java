package github.com.datastructuresandalgorithms.algorithms.search.recursion;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/17
 * Version  1.0
 * Description:汉诺塔
 */

public class Hanoi {

    private static final String TAG = "Hanoi";
    int i = 1;

    /**
     *  目的： 将n个盘子从A经过B移到C
     *  步骤：
     *  1.先将n-1个盘子从A利用C挪到B
     *  2.将第n-1个盘子从A移到C
     *  3.先将n-1个盘子从B利用A挪到C
     *
     * @param n        要运盘的数量
     * @param from     开始的柱子
     * @param dependon  中间柱子
     * @param to       目标柱子
     */
    public void  run(int n,char from , char dependon,char to){

        if(n == 1){
            move(n,from,to);
        }else {
            run(n-1,from,to,dependon);
            move(n,from,to);
            run(n-1,dependon,from,dependon);
        }


    }

    private void move(int n, char from, char to) {
        Log.e(TAG,"第"+i+++"步从"+from+"------>"+to);
    }


    /**
     * 测试
     * @param count
     */
    public static void test(int count){
        Hanoi hanoi = new Hanoi();
        hanoi.run(count,'A','B','C');

    }

}
