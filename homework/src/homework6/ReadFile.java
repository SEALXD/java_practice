//package homework6;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.util.Scanner;
//
//public class ReadFile {
//    /**
//     * ��ȡtxt�ļ�������
//     * @param file ��Ҫ��ȡ���ļ�����
//     * @return �����ļ�����
//     */
//    public static String reading(File file){
//        StringBuilder result = new StringBuilder();
//        try{
//        	FileReader readfile = new FileReader(file);
//            BufferedReader br = new BufferedReader(readfile);//����һ��BufferedReader������ȡ�ļ�
//            String s = null;
//            while((s = br.readLine())!=null)//һ�ζ�һ��
//                result.append(System.lineSeparator()+s); //���з�
//            br.close(); //�ر��ļ�   
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return result.toString();//�����ַ�����ʽ
//    }
//    
//    public static void main(String[] args){
//    	System.out.println("�������ȡ�ļ���·�������ƣ�");
//    	Scanner input=new Scanner(System.in);
//    	String str=input.next();
//        File file = new File(str);  //"E:/test.txt"
//        String result = reading(file);
//        String[] words = result.split(" ");//�ո�ָ�
//        System.out.println("���ļ��ĵ�����Ϊ��"+words.length); 
//        int letternum = 0;
//        for(int i=0; i<words.length; i++) {
//        	letternum += words[i].length();
//        }
//        System.out.println("���ļ����ַ���Ϊ��"+letternum); //��������
//        
//    }
//}