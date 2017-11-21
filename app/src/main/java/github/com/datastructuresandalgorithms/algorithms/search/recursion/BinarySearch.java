package github.com.datastructuresandalgorithms.algorithms.search.recursion;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/15
 * Version  1.0
 * Description:递归--- 二分查找法
 */

public class BinarySearch {

    public int search(int val , int[] array){

        return search(val,array,0,array.length);

    }

    private int search(int val, int[] array, int left, int right) {

        if(left < right){
            return -1;
        }
        int  mid = (left+right)/2;
        if(val == array[mid]){
            return mid;
        }else if(val > array[mid]){
            return search(val,array,mid+1,right);
        }else if(val < array[mid]){
            return search(val,array,left,mid-1);
        }
        return  -1;
    }

    private int nSearch(int val, int[] array, int left, int right){

        while (left < right){

            int mid =  (left+right)/2;

            if(val > array[mid]){
                left=mid+1;
            }else if(val < array[mid]){
                right = mid - 1;
            }else if(val == array[mid]){
                return mid;
            }

        }

        return -1;
    }


}
