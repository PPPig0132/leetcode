package Graph;
import java.util.*;
import java.util.ArrayDeque;
import java.util.HashMap;

class OrangesRotting {
    int []dr=new int []{-1,0,1,0};
    int []dc=new int[]{0,-1,0,1};

    public static void main(String args[]){


    }
    public int orangesRotting(int [][]grid){
        int R=grid.length,C=grid[0].length;
        Queue<Integer> queue=new ArrayDeque<Integer>();
        Map<Integer,Integer>depth=new HashMap<Integer,Integer>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==2){
                    int code=i*C+j;
                    queue.add(code);
                    depth.put(code,0);
                }
            }
        }
        int ans=0;
        while(!queue.isEmpty()){
            int code=queue.remove();
            int r=code/C,c=code%C;
            for(int k=0;k<4;k++){
                int nr=r+dr[k];
                int nc=c+dc[k];
                if(0<=nr&&nr<R&&0<=nc&&nc<C&&grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    int ncode=nr*C+nc;
                    queue.add(ncode);
                    depth.put(ncode,depth.get(code)+1);
                    ans=depth.get(ncode);
                }
            }
        }
        for(int[]row:grid){
            for(int v :row){
                if (v==1){
                    return -1;
                }
            }
        }
        return ans;
    }
     
}