package github.com.datastructuresandalgorithms.algorithms.sort.mergesort;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/15
 * Version  1.0
 * Description: 归并算法
 */

public class MergeSort {

    public void sort(int[] array){

        sort(array,0,array.length-1);

    }

    private void sort(int[] array, int left, int right) {

        if (left < right){

            int mid = (left+right)/2;

            sort(array,left,mid);
            sort(array,mid+1,right);
            merge(array,left,mid,right);


        }
    }

    /**
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int[] array, int left, int mid, int right) {
        int[] temArray = new int[right - left + 1];
        int tem = left;
        int rightStart = mid + 1;
        int k = 0;

        while (left <= mid && rightStart <= right){

            if(array[left] <= array[rightStart]){
                temArray[k++] = array[left++];
            }else {
                temArray[k++] = array[rightStart++];
            }
        }

        while (left <= mid){
            temArray[k++] = array[left++];
        }
        while (rightStart <= right){
            temArray[k++] = array[rightStart++];
        }

        k = 0;
        while (tem <= right){
            array[tem++] = temArray[k++];
        }

    }
}
