package github.com.datastructuresandalgorithms.algorithms.search.divide;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/20
 * Version  1.0
 * Description: 分治算法----
 */

public class SportsSchedule {

    public void run(int[][] table , int n){

        if(n == 1){
            table[0][0] = 1;
        }else {
            int m = n / 2;
            run(table,m);
            //填充右上区域矩阵
            for(int i = 0;i<m;i++){
                for(int j = m;j<n;j++){
                    table[i][j] = table[i][j-m]+m;
                }
            }

            //填充左下区域矩阵
            for(int i = m;i<n;i++){
                for(int j=0;j<m;j++){
                    table[i][j] = table[i-m][j]+m;
                }
            }
            //填充右下区域矩阵
            for(int i = m;i<n;i++){
                for(int j= m;j<n;j++){
                    table[i][j] = table[i-m][j-m];
                }
            }


        }


    }

}
