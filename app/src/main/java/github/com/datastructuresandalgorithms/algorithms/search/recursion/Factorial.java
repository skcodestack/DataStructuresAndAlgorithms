package github.com.datastructuresandalgorithms.algorithms.search.recursion;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/17
 * Version  1.0
 * Description:阶乘
 */

public class Factorial {

    /**
     *  求 n 阶乘  n!
     * @param n
     * @return
     */
    public int run(int n){

        if(n == 1){
            return 1;
        }
        return n*run(n-1);

    }
}
