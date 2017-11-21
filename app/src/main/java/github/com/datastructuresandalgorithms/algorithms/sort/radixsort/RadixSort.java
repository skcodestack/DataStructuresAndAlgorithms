package github.com.datastructuresandalgorithms.algorithms.sort.radixsort;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/15
 * Version  1.0
 * Description:基数排序
 */

public class RadixSort {


    private static final String TAG = "RadixSort";

    public void sort(int[] array){


        int length = array.length;

        int count = 0;
        for (int i = 0; i < length; i++) {
            if(array[i]<0){
                count ++;
            }
        }
        if(count == 0){
            sort(array,true);
        }else {

            int[] nA = new int[count];
            int[] A = new int[length - count];

            int nC = 0,C = 0;
            for (int i = 0; i < length; i++) {
                if(array[i]<0){
                    nA[nC++] = -array[i];
                }else {
                    A[C++] = array[i];
                }
            }

            sort(A,true);
            sort(nA,false);
            int t = 0;
            for (int i = 0; i < nA.length; i++) {
                array[t++] = nA[i];
            }
            for (int i = 0; i < A.length; i++) {
                array[t++] = A[i];
            }

        }




        for (int i : array) {
            Log.e(TAG,"排序后的数组："+i);
        }



    }

    public void   sort(int[] array,boolean b){

        int length = array.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }

        int times = 0;
        while (max > 0){
            max = max / 10;
            times++;
        }

        List<ArrayList> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList());
        }

        for (int i = 0; i < times; i++) {
            int mod = (i+1)*10;
            for (int j = 0; j < length; j++) {
                int m = array[j] % mod / (int)Math.pow(10,i);
                ArrayList arrayList = list.get(m);
                arrayList.add(array[j]);
                list.set(m,arrayList);
            }

            int tem = 0;
            for (int k = 0; k < list.size(); k++) {
                ArrayList<Integer> arrayList = list.get(k);
                while (arrayList.size() > 0){
                    int o = arrayList.get(0);
                    array[tem++] = o;
                    arrayList.remove(0);
                }
            }


        }
        if(!b){

            for (int i = 0; i < length; i++) {
                array[i] = -array[i];
            }

            int i = 0;
            int tem = 0;
            while (i <= length/2){
                int last = length-1-i;
                tem = array[i];
                array[i] = array[last];
                array[last] = tem;
                i++;
            }
        }
    }


}
