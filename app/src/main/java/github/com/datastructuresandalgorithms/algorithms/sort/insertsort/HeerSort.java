package github.com.datastructuresandalgorithms.algorithms.sort.insertsort;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/14
 * Version  1.0
 * Description:希尔排序
 * 根据步长将数组划分成多个小的组，然后对每个组进行插入排序
 */

public class HeerSort {


    private static final String TAG = "HeerSort" ;

    /**
     * 根据步长将数组划分成多个小的组，然后对每个组进行插入排序
     */
    public void sort(int[] array){

        int length = array.length;
        int d = length;
        int tem = 0;
        while (true){
            d/=2;
            for (int i = 0; i < d; i++) {

                for (int k = i+d; k < length; k+=d) {
                    tem = array[k];
                    int j = 0;
                    for (j = k-d ; j >= 0 && tem < array[j]; j-=d) {
                        array[j+d] = array[j];
                    }
                    array[j+d] = tem;
                }
            }

            if(d == 1){
                break;
            }
        }

        for (int i : array) {
            Log.e(TAG,"排序后的数组："+i);
        }

    }


}
