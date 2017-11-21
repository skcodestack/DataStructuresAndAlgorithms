package github.com.datastructuresandalgorithms.algorithms.search.recursion;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/17
 * Version  1.0
 * Description:欧几里得  --- 求最大公约数
 */

public class Euclid {


    public int run(int n,int m){

        if(n > m){
            return euclid(n,m);
        }else {
            return euclid(m,n);
        }
    }

    /**
     *
     * 最大公约数 = m 和 n % m 的最大公约数 (n > m)
     *
     * @param n 大数
     * @param m 小数
     * @return
     */
    private int euclid(int n,int m){

        if(m == 0){
            return n;
        }

        return run(m,n%m);
    }

}
