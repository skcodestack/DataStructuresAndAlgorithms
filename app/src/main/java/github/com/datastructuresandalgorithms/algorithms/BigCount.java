package github.com.datastructuresandalgorithms.algorithms;

import android.util.Log;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/20
 * Version  1.0
 * Description: 大数相乘
 */

public class BigCount {


    private static final String TAG = "BigCount";


    /**
     *
     * 126 * 138 = 17388
     * 3 + 2 + 8= 3
     * r[i] = a[i]*b[i-1] + a[i-1]*b[i-1]
     *
     * @param a
     * @param b
     * @return
     */
    private void multiply(String a, String b){

        Log.e(TAG,"乘数一:"+a);
        Log.e(TAG,"乘数二:"+b);


        int aLen = a.length();
        int bLen = b.length();

        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();

        // 高低位对调
        covertdata(s1,aLen);
        covertdata(s2,bLen);
        //两数乘
        multiply(s1,aLen,s2,bLen);

    }



    private void multiply(char[] a ,int nLen,char[] b,int mLen){

        int size = nLen + mLen +1;
        int[] re = new int[size];

        for (int i = 0; i < nLen; i++) {
            for (int j = 0; j < mLen; j++) {
                re[i + j] = Integer.parseInt(String.valueOf(a[i]))* Integer.parseInt(String.valueOf(b[j]));
            }
        }
        int m = 0;
        // 进位处理
        for (m = 0; m < size; m++) {
            int carry = re[m] / 10;
            re[m] = re[m] % 10;
            if (carry > 0)
                re[m + 1] += carry;
        }

        // 找到最高位
        for (m = size - 1; m >= 0;) {
            if (re[m] > 0)
                break;
            m--;
        }

        // 由最高位开始打印乘积
        System.out.print("乘积：");
        for (int i = 0; i <= m; i++) {
            System.out.print(re[m - i]);
        }
        System.out.println("");

    }

    /**
     * 方便计算
     * @param data
     * @param len
     */
    private static void covertdata(char data[], int len) {
        //高低位对调
        for (int i = 0; i < len / 2; i++) {
            data[i] += data[len - 1 - i];
            data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);
            data[i] = (char) (data[i] - data[len - 1 - i]);
        }
    }



    public void run(){

        String a = "54656564451213232656454112";
        String b = "3651248796532156465845212565589545";
        multiply(a, b);


    }


}
