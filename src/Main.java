public class Main {

    public static void main(String[] args) {
        final int ROWS = 10;        //10阶方阵
        int start = 1;              //左上角的起始值
        int a[][] = new int[ROWS][ROWS];
        char direction = 'R';         //初始方向向右
        int i = 0, j = 0;

        while (a[i][j] == 0){
            a[i][j] = start++;                //后置自增
            switch (direction){               //根据方向判断下一步的位置
                case 'R':                     //右
                    if(j + 1 < ROWS && a[i][j+1] == 0){           //未走到最右且未走过
                        j++;                   //向右走
                    }else {                    //走到最右或已走过
                        i++;                   //下转
                        direction = 'D';       //修改方向
                    }
                    break;
                case 'D':                     //下
                    if(i + 1 < ROWS && a[i+1][j] == 0){
                        i++;
                    }else {
                        j--;
                        direction = 'L';
                    }
                    break;
                case 'L':                      //左
                    if(j > 0 && a[i][j-1] == 0){
                        j--;
                    }else {
                        i--;
                        direction = 'U';
                    }
                    break;
                case 'U':                      //上
                    if(i > 0 && a[i-1][j] == 0){
                        i--;
                    }else {
                        j++;
                        direction = 'R';
                    }
            }//switch结束
        }//while结束
        for (int m = 0; m < ROWS; m++){                   //打印方阵
            for (int n = 0; n < ROWS; n++){
                System.out.printf("%-4d", a[m][n]);
            }
            System.out.println();
        }
    }
}
