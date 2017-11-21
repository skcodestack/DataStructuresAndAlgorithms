package github.com.datastructuresandalgorithms.algorithms.search.dynamicprogramming;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/20
 * Version  1.0
 * Description: 动态规划法---最长公共子序列
 */

public class CommonSubsequence {

    /**
     *
     *
     *
     *          1. 0                             , i=0 j=0
     * c[i,j] = 2. c[i-1][j-1] + 1               , i,j>0  [i] == [j]
     *          3. max(c[i-1][j],c[i][j-1])      , i,j>0  [i]!=[j]
     *
     *
     * @return 最长公共子序列的长度
     */
    public int run(String N,String M){
        int nLen = N.length();
        int mLen = M.length();

        char[] n = N.toCharArray();
        char[] m = M.toCharArray();

        int [][] dp = new int[nLen][mLen];
        //第一列
        for (int i = 0; i < nLen; i++) {
            if(n[i] == m[0]){
                dp[i][0] =1;
                for (int j = 0; j < nLen; j++) {
                    dp[j][0] = 1;
                }
                break;
            }
        }
        //第一行
        for (int i = 0; i < mLen; i++) {
            if(n[0] == m[i]) {
                dp[0][i] = 1;
                for (int j = i + 1; j < mLen; j++) {
                    dp[0][j] = 1;
                }
                break;
            }
        }

        //其他
        for (int i = 1; i < nLen; i++) {
            for (int j = 1; j < mLen; j++) {
                if(n[i] == m[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[nLen-1][mLen-1];

    }

}
