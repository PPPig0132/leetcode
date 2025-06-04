package Math;
/*遍历每两个点之间的斜率 */
public class MaxPoints {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if(len == 1){
            return 1;
        }
        
        int maxLen = 1;
        
        for(int left = 0; left<len-1; left++){
            for(int right = left+1; right<len; right++){
                int[] base = points[left];
                int up = points[right][1]-base[1];
                int down = points[right][0]-base[0];
                int nowLen = 2;
                for(int check = right+1; check<len; check++){
                    if((points[check][1]-base[1])*down == (points[check][0]-base[0])*up){
                        nowLen++;
                    }
                }
                if(nowLen > maxLen){
                    maxLen = nowLen;
                    if(len/maxLen < 2){
                        return maxLen;
                    }
                }
            }
        }

        return maxLen;
    }
}
