package github.com.datastructuresandalgorithms.algorithms.search.exhaustive;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/16
 * Version  1.0
 * Description:穷举法--- 泊松算法---泊松分酒
 */

public class Poisson {


    private static final String TAG = "Poisson";
    //三个分酒容器的大小
    int  con_1 = 12;
    int  con_2 = 8;
    int  con_3 = 5;

    //要分出酒的多少
    int  target = 6;

    public Poisson() {
    }

    /**
     *
     * @param con_1  第一个酒容器
     * @param con_2  第二个酒容器
     * @param con_3  第三个酒容器
     * @param target 要分出酒的多少
     */
    public Poisson(int con_1, int con_2, int con_3, int target) {
        this.con_1 = con_1;
        this.con_2 = con_2;
        this.con_3 = con_3;
        this.target = target;
    }


    /**
     * 策略：
     * 1.三个容器循环倒 1->2->3->1
     * 2.从1->2 ， 2->3 要倒满
     * 3.当3满的时候，将3->1
     * @param c1  第一个酒容器中的酒
     * @param c2  第二个酒容器中的酒
     * @param c3  第三个酒容器中的酒
     */
    public void  run (int c1 , int c2,int c3){
        if(c1+c2+c3 < target){
            Log.e(TAG,"酒太少");
            return;
        }
        if(c1 == target || c2 == target || c3 == target){
            Log.e(TAG,"酒已经分好");
            return;
        }

        if(c2 != 0 && c3 != con_3){
            if(c2+c3 <= con_3){
                run(c1,0,c2+c3);
            }else {
                run(c1,c2-(con_3-c3),con_3);
            }

        }else if(c3 == con_3){
            if(c1 + c3 <= con_1 ){
                run(c1+c3,c2,0);
            }else {
                run(con_1,c2,c3-(con_1-c1));
            }
        }else if(c2 == 0) {
            if(c1 >= con_2){
                run(c1-con_2,con_2,c3);
            }else {
                run(0,c1,c3);
            }
        }
    }

}
