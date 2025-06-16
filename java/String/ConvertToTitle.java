package String;
/*20进制，将int整数转换为字母*/


public class ConvertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb= new StringBuilder();
        while(columnNumber>0){
            int cur=(columnNumber-1)%26;
            sb.append((char)('A'+cur));
            columnNumber=(columnNumber-cur-1)/26;
        }
        return sb.reverse().toString();
        
    }
    public static void main(String[] args) {
        // Example usage
        ConvertToTitle solution = new ConvertToTitle();
        int columnNumber = 701; // Example input
        String result = solution.convertToTitle(columnNumber);
        
        // Print the result
        System.out.println("Column Title: " + result); // Output: Column Title: AB
    }
}
