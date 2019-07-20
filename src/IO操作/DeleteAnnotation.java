package IO操作;

import java.io.*;

public class DeleteAnnotation {
    public static void main(String[] args) {
        File file = new File("F:/cong/code/java_learn/cong-javaMiddle/src/io/NumberStringChange.java");
        removeComments(file);
    }
    //设计一个方法，用于移除Java文件中以//k开头的注释
    private static void removeComments(File javaFile){
        File resFile = new File(javaFile.getParent(),"new"+javaFile.getName());
        System.out.printf("选中的java文件为：%s%n", javaFile.getAbsolutePath());
        try (
                FileReader fileReader = new FileReader(javaFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(resFile);
                PrintWriter printWriter = new PrintWriter(fileWriter);
        ) {
            while (true){
                String s = bufferedReader.readLine();
                if(s==null)
                    break;
                if(!s.trim().startsWith("//"))
                    printWriter.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.format("去除%s中以//开头的的注释行%n并且生成了新的文件%s",javaFile.getName(),resFile.getName());
    }
}
