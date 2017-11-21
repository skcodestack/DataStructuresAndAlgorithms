package github.com.datastructuresandalgorithms.algorithms.sort.selectionsort;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/14
 * Version  1.0
 * Description: 选择排序
 */

public class SelectSort {

    private static final String TAG = "SelectSort";

    public void sort(int[] array){
        for (int i : array) {
            Log.e(TAG,"排序前的数组："+i);
        }


        int length = array.length;

        int min,tem = 0;
        for (int i = 0; i < length; i++) {
            min = array[i];
            for (int j = i; j < length; j++) {
                if(array[j] < min){
                    tem = array[j];
                    array[j] = min;
                    array[i] = min = tem;
                }
            }

        }

        for (int i : array) {
            Log.e(TAG,"排序后的数组："+i);
        }
    }


}
