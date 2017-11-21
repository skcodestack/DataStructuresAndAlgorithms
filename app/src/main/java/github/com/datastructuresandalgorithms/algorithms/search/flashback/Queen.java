package github.com.datastructuresandalgorithms.algorithms.search.flashback;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/11/20
 * Version  1.0
 * Description:
 */

public class Queen {

    public static int num = 0;//累计方案
    public static final int MAXQUEEN = 8;
    public static int[] cols = new int[MAXQUEEN];//定义cols数组，表示8列棋子皇后摆放的位置

    public void run(int n){
        boolean [] rows = new boolean[MAXQUEEN];//记录每列每个方格是否可以放皇后
        for (int i = 0; i < n; i++) {
            rows[cols[i]] = true;
            int d = n - i;
            //正斜方向
            if(cols[i]-d>=0){
                rows[cols[i] -d] = true;
            }
            //反斜方向
            if(cols[i]+d<=(MAXQUEEN-1)){
                rows[cols[i]+d] = true;
            }
        }
        //到此知道了哪些位置不能放皇后
        for(int i = 0;i<MAXQUEEN;i++){
            if(rows[i]){
                //不能放
                continue;
            }
            cols[n] = i;
            if(n<MAXQUEEN-1){
                run(n+1);
            }else{
                //找到完整的一套方案
                num++;
                printQueen();
            }
            //下面可能仍然有合法位置
        }

    }

    private void printQueen() {
        System.out.println("第"+num+"种方案");
        for(int i = 0;i<MAXQUEEN;i++){
            for(int j = 0;j<MAXQUEEN;j++){
                if(i == cols[j]){
                    System.out.print("0 ");
                }else{
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
    }

}
