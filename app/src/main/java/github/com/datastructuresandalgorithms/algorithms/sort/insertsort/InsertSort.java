package github.com.datastructuresandalgorithms.algorithms.sort.insertsort;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/14
 * Version  1.0
 * Description: 直接插入排序
 */

public class InsertSort {


    private static final String TAG = "InsertSort";

    public  void sort(int[] array){
        int length = array.length;

        int tem = 0;
        for (int i = 1; i < length; i++) {
            tem = array[i];
            int j =  0;
            for (j = i-1; j >= 0; j--) {

                if(tem < array[j]){
                    array[j+1] = array[j];
                }else {
                    break;
                }

            }
            array[j+1] = tem;

        }
        for (int i : array) {
            Log.e(TAG,"排序后的数组："+i);
        }
    }

}
