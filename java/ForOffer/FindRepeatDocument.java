package ForOffer;

/*
设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。
*/

public class FindRepeatDocument {
    public int findRepeatDocument(int[] documents) {
       int ans[]=new int [documents.length];
         for (int i = 0; i < documents.length; i++) {
            ans[documents[i]]++;
            if( ans[documents[i]]>1){
                return documents[i];
            }
         }
         return -1;
    }
    public static void main(String[] args) {
        FindRepeatDocument solution = new FindRepeatDocument();
        int[] documents = {2, 5, 3, 0, 5, 0};
        System.out.println(solution.findRepeatDocument(documents)); // Output: 2 (The duplicate number is 2.)
       
    }
}
