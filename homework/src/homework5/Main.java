//package homework5;
//import java.util.Random;
//
//import javax.swing.*;
//
//class Storage
//{
//	String s1 = null;
//	String s2 = null;
//	String s3 = null; //三个容量
//	int[] arr = {0,0,0}; //标记位
//	int count = 0;
//	public synchronized void put(int id) {
//		System.out.println("仓库状态p"+arr[0]+arr[1]+arr[2]);
//		if(arr[0]==1 && arr[1]==1 && arr[2]==1)//如果没有空
//		  {
//			  try{ wait();}
//			  catch(InterruptedException e){e.printStackTrace();}
//		  }
//		final double d = Math.random();
//		final int i = (int)(d*7); //随机生成字符串长度
//		String str = getRandomString(i);
//		System.out.println("p"+id+"输入"+str);
//		
//		if(arr[0]==0) {
//			s1 = str;
//			arr[0]=1;
//			System.out.print("存入s1\n");
//		}
//		else if(arr[1]==0) {
//			s2 = str;
//			arr[1]=1;
//			System.out.print("存入s2\n");
//		}
//		else{
//			s3 = str;
//			arr[2]=1;
//			System.out.print("存入s3\n");
//		}
//		notify();
//	}//end put
//	
//    public synchronized void get(int id) {
//		String restr;
//		System.out.println("仓库状态g"+arr[0]+arr[1]+arr[2]);
//		if(arr[0]==0 && arr[1]==0 && arr[2]==0)//如果空，则等待
//		  {
//			  try{ wait();}
//			  catch(InterruptedException e){e.printStackTrace();}
//		  }
//		
//		if(arr[0] != 0) {
//			System.out.print("取出s1\n");
//			restr = new StringBuilder(s1).reverse().toString();
//	 	    System.out.println("tread"+id+"倒置："+restr);
//			arr[0] = 0;
//			s1 = null;
//		 }
//		else if(arr[1] != 0) {
//			System.out.print("取出s2\n");
//			restr = new StringBuilder(s2).reverse().toString();
//	 	    System.out.println("tread"+id+"倒置："+restr);
//			arr[1] = 0;
//			s2 = null;
//			}
//		else  {
//			System.out.print("取出s3\n");
//			restr = new StringBuilder(s3).reverse().toString();
//	 	    System.out.println("tread"+id+"倒置："+restr);
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
//    } //随机生成字符串函数
//}
//
////生产者
//class Producer implements Runnable
//{
// private boolean tag=true;//默认允许run
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
//			Thread.sleep(100);//每隔100毫秒输入一次
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
////消费者
//class Consumer implements Runnable
//{
// private boolean tag=true;//默认允许run
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
//	 	    storage.get(id); //从仓库取数据
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
//   String input=JOptionPane.showInputDialog("输入stop终止程序");
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
