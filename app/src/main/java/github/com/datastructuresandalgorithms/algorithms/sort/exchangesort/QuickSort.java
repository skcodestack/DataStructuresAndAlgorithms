package github.com.datastructuresandalgorithms.algorithms.sort.exchangesort;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/15
 * Version  1.0
 * Description: 快速排序（不稳定）   最差：O(N^2)  平均：O(NlogN)
 */

public class QuickSort {


    private static final String TAG = "QuickSort";

    public void sort(int[] array){

        sort(array,0,array.length-1);

        for (int i : array) {
            Log.e(TAG,"排序后的数组："+i);
        }
    }

    private void sort(int[] array, int start, int end) {

        int i = start;
        int j = end;
        int key = array[start];

        while (i < j){

            while (i < j && array[j] >= key) j--;

            if(i < j){
                array[i] = array[j];
                i++;
            }

            while (i < j && array[i] <= key) i++;

            if(i < j){
                array[j] = array[i];
                j--;
            }
        }

        //i == j
        array[i] = key;

        //key 左边
        sort(array,start,i-1);

        //key 右边
        sort(array,j+1,end);




    }

}
