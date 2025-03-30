package Graph;
import java.util.*;
public class NumIslands {
    public static void main(String []args){
        char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},
        {'1','1','0','0','0'},{'0','0','0','0','0'}};
        char [][]grid1={{'1','1','0','0','0'},{'1','1','0','0','0'},
        {'0','0','1','0','0'},{'0','0','0','1','1'}};
        char [][]grid2={{'1','1','0','0','0'},{'1','1','0','0','0'},
        {'1','0','1','0','0'},{'1','1','1','0','1'}};
        NumIslands obj=new NumIslands();
        System.out.println(obj.numIslands(grid2));
    }
     public int numIslands(char[][] grid) {
        int ans=0;
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    ++ans;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    public boolean check(int i,int j,char[][] grid){
        return 0<=i && i<grid.length && 0<=j && j<grid[0].length;
    }
    public void dfs(char[][] grid,int i,int j){
        if(!check(i,j,grid )){
            return;
        }
        if(grid[i][j]!='1'){
            return;
        }
        grid[i][j]='2';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
    
}
