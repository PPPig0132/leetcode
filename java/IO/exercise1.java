package IO;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.*;
import java.util.*;

public class exercise1 {
    public static void main(String[] args) {
        FileOp fileOp = FileOp.createFileOp("./IO/IOtest", "test2.txt");
        // try {
        //     fileOp.createFile();
        // } catch (IOException e) {
        //     System.out.println("创建文件时发生异常：" + e.getMessage());
        // }
        fileOp.filePrint();
    }
    
}
class FileOp{
    public String parent;
    public String fileName;
    private int MAX_SIZE=1024;

    public FileOp(String parent, String fileName) {
        this.parent = parent;
        this.fileName = fileName;
    }

    public static FileOp createFileOp(String parent,String fileName){
        return new FileOp(parent, fileName);
    }
    public void  createFile() throws IOException {
        Path file = Paths.get(parent, fileName);
        try {
            if (Files.exists(file) && Files.isRegularFile(file)) {
                System.out.println("文件已存在");
            } else {
                System.out.println("文件不存在，创建中...");
                Files.createFile(file);
            }
        } catch (IOException e) {
            System.out.println("发生异常：" + e.getMessage());
        }
    }
    public void listDir() {
        Path dir = Paths.get(parent);
        try {
            Files.walk(dir)               // 深度优先
                .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("遍历目录时发生异常：" + e.getMessage());
        }
    }
    public void listJava(){
         Path dir = Paths.get(parent);
        try {
            Files.walk(dir)
                .filter(s->s.toString().endsWith(".java"))       
                .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("遍历目录时发生异常：" + e.getMessage());
        }
    }
    public void filePrint(){
        Path file = Paths.get(parent, fileName);
        try{
            if(Files.size(file)<MAX_SIZE){
                    List<String> lines = Files.readAllLines(file);
                    lines.forEach(System.out::println);
            }
            else{
                BufferedReader reader = Files.newBufferedReader(file);
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }
        catch (IOException e) {
            System.out.println("读取文件时发生异常：" + e.getMessage());
        }
       
    }
    public void fileWrite(String content) {
        Path file = Paths.get(parent, fileName);
        try {
            Files.writeString(file, content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("写入文件时发生异常：" + e.getMessage());
        }
    }
}
