package github.com.datastructuresandalgorithms.list.linkedlist;

import android.util.Log;

import java.util.LinkedList;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/6
 * Version  1.0
 * Description: LinkedList 操作
 */

public class LinkedListUtil<T> {
    String TAG = "LinkedListUtil";


    public  void  reverseItems(LinkedList<T> list,int k){
        Log.e(TAG,"Before================");

        log(list);



    }


    public void log(LinkedList<T> list){
        for (T t : list) {
            Log.e(TAG,"items================"+t);
        }
    }
}
