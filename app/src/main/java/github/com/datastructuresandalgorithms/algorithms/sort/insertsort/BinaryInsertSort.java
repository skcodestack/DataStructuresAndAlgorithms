package github.com.datastructuresandalgorithms.algorithms.sort.insertsort;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/14
 * Version  1.0
 * Description: 二分法插入排序
 */

public class BinaryInsertSort {


    private static final String TAG = "BinaryInsertSort";

    public void sort(int[] array){

        int length = array.length;

        for (int i = 0; i < length; i++) {
            int tem = array[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right){
                mid = (left+right)/2;
                if(tem < array[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }

            for (int j = i-1; j >= left; j--) {
                array[j+1] = array[j];
            }

            if(left != i){
                array[left] = tem;
            }

        }
        for (int i : array) {
            Log.e(TAG,"排序后的数组："+i);
        }
    }

}
