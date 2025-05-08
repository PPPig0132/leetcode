package ForOffer;
/*
package ForOffer;

public class ConsArray {
    
}

*/
import java.util.Scanner;

public class ArrayClass {
    private int[] array;

    // 构造函数
    public ArrayClass(int size, int[] elements) {
        if (size != elements.length) {
            throw new IllegalArgumentException("数组大小与输入的元素数量不匹配");
        }
        this.array = elements;
    }

    // 输出数组
    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组大小
        System.out.println("请输入数组的大小：");
        int n = scanner.nextInt();
        scanner.nextLine(); // 跳过回车符

        // 读取数组元素
        System.out.println("请输入数组的元素：");
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = scanner.nextInt();
        }

        // 创建数组类对象
        ArrayClass arrayClass = new ArrayClass(n, elements);

        // 输出数组
        arrayClass.printArray();

        scanner.close();
    }
}