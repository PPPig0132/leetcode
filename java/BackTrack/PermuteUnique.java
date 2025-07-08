package BackTrack;
/*给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。*/
import java.util.*;
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0,set);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first,Set set) {
        // 所有数都填完了
        if (first == n) {
            int code=0;
            for(int m: output){
                code=code*10+m; //将数组转换为数字
            }
            if(set.contains(code)) return; //如果已经存在，则返回
            res.add(new ArrayList<Integer>(output));
            set.add(code);
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1,set);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
    public static void main(String[] args) {
        PermuteUnique pu = new PermuteUnique();
        int[] nums = {1, 1, 2}; // 示例输入
        List<List<Integer>> result = pu.permuteUnique(nums);
        for (List<Integer> list : result) {
            System.out.println(list); // 输出结果
        }
    }
}
