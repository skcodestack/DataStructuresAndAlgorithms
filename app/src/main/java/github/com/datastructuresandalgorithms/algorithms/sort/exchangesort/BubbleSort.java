package github.com.datastructuresandalgorithms.algorithms.sort.exchangesort;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/14
 * Version  1.0
 * Description: 冒泡排序
 */

public class BubbleSort {


    private static final String TAG = "BubbleSort";

    public void sort(int[] array){


        int length = array.length;
        int tem = 0;
        boolean isSwap = false;
        for (int i = 0; i < length-1; i++) {
            isSwap = false;
            for (int j = 0; j < length-i-1; j++) {
                if(array[j] > array[j+1]){
                    tem = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tem;
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
        for (int i : array) {
            Log.e(TAG,"排序后的数组："+i);
        }

    }

}
