package github.com.datastructuresandalgorithms.algorithms.sort.selectionsort;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/14
 * Version  1.0
 * Description:堆排序
 */

public class HeapSort {

    private static final String TAG = "HeapSort";

    public void sort(int[] array){

        //大堆
        buildMaxHeap(array);

        int length = array.length;
        for (int i = length-1; i >= 0; i--) {
            swap(array,0,i);
            heapAdjust(array,0,i);
        }

        for (int i : array) {
            Log.e(TAG,"排序后的数组："+i);
        }
    }

    /**
     * 创建大堆
     * left  =  2i + 1
     * right =  2i + 2
     * @param array
     */
    private void buildMaxHeap(int[] array) {
        int half = (array.length-1)/2;
        for (int i = half; i >= 0; i--) {
            heapAdjust(array,i,array.length);
        }


    }

    /**
     * 大堆调整
     * @param array
     * @param i      当前节点下标
     * @param length  需要调整数组长度
     */
    private void heapAdjust(int[] array, int i, int length) {

        int left  =  2*i + 1 ;
        int  right =  2*i + 2;
        int largest = i;

        if(left < length && array[left] > array[largest]){
            largest = left;
        }
        if(right < length && array[right] > array[largest]){
            largest = right;
        }

        if(largest != i){
            swap(array,largest,i);
            heapAdjust(array,largest,length);
        }



    }

    private void swap(int[] array, int largest, int i) {

//        a=a^b,                异或后a=11^10=01
//
//        b=a^b,                异或后b=01^10=11(此时b为开始a的值)
//
//                a=a^b                 异或后a=01^11=10(此时a为开始b的值)

       int tem  = array[i];
        array[i] = array[largest];
        array[largest] = tem;


    }


}
