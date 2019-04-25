//package homework6;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.util.Scanner;
//
//public class ReadFile {
//    /**
//     * 读取txt文件的内容
//     * @param file 想要读取的文件对象
//     * @return 返回文件内容
//     */
//    public static String reading(File file){
//        StringBuilder result = new StringBuilder();
//        try{
//        	FileReader readfile = new FileReader(file);
//            BufferedReader br = new BufferedReader(readfile);//构造一个BufferedReader类来读取文件
//            String s = null;
//            while((s = br.readLine())!=null)//一次读一行
//                result.append(System.lineSeparator()+s); //换行符
//            br.close(); //关闭文件   
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return result.toString();//返回字符串格式
//    }
//    
//    public static void main(String[] args){
//    	System.out.println("请输入读取文件的路径和名称：");
//    	Scanner input=new Scanner(System.in);
//    	String str=input.next();
//        File file = new File(str);  //"E:/test.txt"
//        String result = reading(file);
//        String[] words = result.split(" ");//空格分割
//        System.out.println("该文件的单词数为："+words.length); 
//        int letternum = 0;
//        for(int i=0; i<words.length; i++) {
//        	letternum += words[i].length();
//        }
//        System.out.println("该文件的字符数为："+letternum); //含标点符号
//        
//    }
//}