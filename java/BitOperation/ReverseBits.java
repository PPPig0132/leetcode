package BitOperation;

public class ReverseBits {
    public int reverseBits(int num) {
        int result = 0; // 初始化结果变量
        for (int i = 0; i < 32; i++) { // 遍历 32 位
            result = result << 1; // 左移结果变量
            result = result | (num & 1); // 添加最低位
            num = num >> 1; // 右移给定整数
        }
        return result; // 返回结果
    }
    
}
