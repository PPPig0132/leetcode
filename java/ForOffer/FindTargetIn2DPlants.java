package ForOffer;
/*
m*n 的二维数组 plants 记录了园林景观的植物排布情况，具有以下特性：
每行中，每棵植物的右侧相邻植物不矮于该植物；
每列中，每棵植物的下侧相邻植物不矮于该植物。
 
请判断 plants 中是否存在目标高度值 target。

从左上角开始向右下角开始z字型搜索
*/
public class FindTargetIn2DPlants {
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        if(plants.length==0 || plants[0].length==0){
            return false;
        }
        int m=plants.length,n=plants[0].length;
        if(n==0){
            return false;
        }
        int i=0,j=n-1;
        while(i<m&&j>-1){
            if(plants[i][j]==target){
                return true;
            }
            else if(plants[i][j]<target){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        FindTargetIn2DPlants solution = new FindTargetIn2DPlants();
        int[][] plants = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int target = 5;
        System.out.println(solution.findTargetIn2DPlants(plants, target)); // Output: true
    }
    
}
