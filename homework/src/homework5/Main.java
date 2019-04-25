//package homework5;
//import java.util.Random;
//
//import javax.swing.*;
//
//class Storage
//{
//	String s1 = null;
//	String s2 = null;
//	String s3 = null; //��������
//	int[] arr = {0,0,0}; //���λ
//	int count = 0;
//	public synchronized void put(int id) {
//		System.out.println("�ֿ�״̬p"+arr[0]+arr[1]+arr[2]);
//		if(arr[0]==1 && arr[1]==1 && arr[2]==1)//���û�п�
//		  {
//			  try{ wait();}
//			  catch(InterruptedException e){e.printStackTrace();}
//		  }
//		final double d = Math.random();
//		final int i = (int)(d*7); //��������ַ�������
//		String str = getRandomString(i);
//		System.out.println("p"+id+"����"+str);
//		
//		if(arr[0]==0) {
//			s1 = str;
//			arr[0]=1;
//			System.out.print("����s1\n");
//		}
//		else if(arr[1]==0) {
//			s2 = str;
//			arr[1]=1;
//			System.out.print("����s2\n");
//		}
//		else{
//			s3 = str;
//			arr[2]=1;
//			System.out.print("����s3\n");
//		}
//		notify();
//	}//end put
//	
//    public synchronized void get(int id) {
//		String restr;
//		System.out.println("�ֿ�״̬g"+arr[0]+arr[1]+arr[2]);
//		if(arr[0]==0 && arr[1]==0 && arr[2]==0)//����գ���ȴ�
//		  {
//			  try{ wait();}
//			  catch(InterruptedException e){e.printStackTrace();}
//		  }
//		
//		if(arr[0] != 0) {
//			System.out.print("ȡ��s1\n");
//			restr = new StringBuilder(s1).reverse().toString();
//	 	    System.out.println("tread"+id+"���ã�"+restr);
//			arr[0] = 0;
//			s1 = null;
//		 }
//		else if(arr[1] != 0) {
//			System.out.print("ȡ��s2\n");
//			restr = new StringBuilder(s2).reverse().toString();
//	 	    System.out.println("tread"+id+"���ã�"+restr);
//			arr[1] = 0;
//			s2 = null;
//			}
//		else  {
//			System.out.print("ȡ��s3\n");
//			restr = new StringBuilder(s3).reverse().toString();
//	 	    System.out.println("tread"+id+"���ã�"+restr);
//			arr[2] = 0;
//			s3 = null;
//			}
//		notify();
//
//	}//end get
//		
//    public static String getRandomString(int length){
//        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        Random random=new Random();
//        StringBuffer sb=new StringBuffer();
//        for(int i=0;i<length;i++){
//          int number=random.nextInt(62);
//          sb.append(str.charAt(number));
//        }
//        return sb.toString();
//    } //��������ַ�������
//}
//
////������
//class Producer implements Runnable
//{
// private boolean tag=true;//Ĭ������run
// private Storage storage = null;
// private int id;
// public Producer(Storage storage,int id)
// {
//   this.storage=storage;
//   this.id=id;
// }
//	 public void run()
//	{ while(tag)
//		{
//		try {
//			Thread.sleep(100);//ÿ��100��������һ��
//		} catch (InterruptedException e) {e.printStackTrace();}
//		storage.put(id); 
//		}    
//	}//end run 
//
// public void setTag(boolean tag)
// {
//	   this.tag=tag;
// }
//}//end class
//
//
////������
//class Consumer implements Runnable
//{
// private boolean tag=true;//Ĭ������run
// private Storage storage = null;
// private int id;
// public Consumer(Storage storage,int id)
// {
//   this.storage=storage;
//   this.id = id;
// }
// public void run()
// {
//	   while(tag)
//	   {   
//	 	    storage.get(id); //�Ӳֿ�ȡ����
//		}
// }//end run
//  public void setTag(boolean tag)
// {
// 	   this.tag=tag;
// }
//  
//}
//
//public class Main
//{
//public static void main(String [] args)
//{
//   Storage storage=new Storage();
//   Producer producer1=new  Producer(storage,1);
//   Producer producer2=new  Producer(storage,2);
//   Consumer consumer1=new Consumer(storage,1);
//   Consumer consumer2=new Consumer(storage,2);
//   new Thread(producer1).start();
//   new Thread(producer2).start();
//   new Thread(consumer1).start();
//   new Thread(consumer2).start();
//   
//   String input=JOptionPane.showInputDialog("����stop��ֹ����");
//   if(input.equals("stop"))
//   {
//		 producer1.setTag(false);
//		 producer2.setTag(false);
//		 consumer1.setTag(false);
//		 consumer2.setTag(false);
//	 }
//}
//}
//
//
//
