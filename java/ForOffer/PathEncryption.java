package ForOffer;
/*
假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。
*/
public class PathEncryption {
    public String pathEncryption(String path) {
        if(path.length()==0){
            return new String();
        }
        String head=path.replace(".", " ");
        // String []parts=path.split(".");
        // String head=parts[0];
        // for(int i=1;i<parts.length;++i){
        //     head+=" ";
        //     head+=parts[i];
        // }
        return head;
    }
    public static void main(String[] args) {
        PathEncryption solution = new PathEncryption();
        String path = "a.b.c.d";
        System.out.println(solution.pathEncryption(path)); // Output: "a b c d"
    }
}
