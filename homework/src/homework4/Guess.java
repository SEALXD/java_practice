//package homework4;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*;
//
//public class Guess extends JFrame{
//	  JPanel p;//面板
//	  JButton b1,b2,b3;    //三个按钮
//	  JLabel l1,l2,l3;     //两个标签
//	  JTextField tf;     //文本框
//	  int num;//目标数字
//	  Guess()
//	  {
//		num = (int)(1+Math.random()*(1000-1+1));//生成一个随机数，范围1-1000
//		p = new JPanel();
//		p.setLayout(null);//设置布局为空，对每个组件手动输入坐标
//		p.setBackground(Color.white);
//		
//		l1 = new JLabel("你已经猜了0次");//标签 
//		l1.setBounds(80, 20, 100, 20);
//		l2 = new JLabel("---");//标签 
//		l2.setBounds(340, 60, 100, 20);
//		l3 = new JLabel("输入猜测的数");//标签 
//		l3.setBounds(80, 60, 80, 20);
//        
//		b1 = new JButton("确认");//按钮
//		b1.setBounds(80, 120, 60, 20);
//		b2 = new JButton("重新开始");
//		b2.setBounds(180, 120, 100, 20);
//		b3 = new JButton("退出");
//		b3.setBounds(300, 120, 60, 20);
//		Listener ourListener = new Listener(); // 共享一个listener       
//		b1.addActionListener(ourListener);
//		b2.addActionListener(ourListener);
//		b3.addActionListener(ourListener);
//          
//	    tf = new JTextField();//文本框
//	    tf.setBounds(180, 60, 150, 20);
//	    
//	    p.add(l1);p.add(l2);p.add(l3);
//	    p.add(tf);
//	    p.add(b1);p.add(b2);p.add(b3);
//
//	     this.add(p); 
//         this.setTitle("Guess Number");
//         this.setSize(500,200);
//         this.setLocation(200,200);
//         this.setResizable(false);
//         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         this.setVisible(true);
//	  }
//	  
//	  private class Listener implements ActionListener { //创建一个内部类来监听事件  
//		  int count = 0;
//		  public void actionPerformed(ActionEvent e)
//		  {
//			  String buttonName = e.getActionCommand();
//			  String input;
//			  if (buttonName.equals("确认")) {
//				  input =tf.getText();
//			  	  int inputnum = Integer.parseInt(input);//获取文本框输入的内容并转换为int
//			  	  if(inputnum>num) {
//			  		  l2.setText("太大");
//			  		  p.setBackground(Color.red);
//			  	  } 
//			  	  else if(inputnum<num) {
//			  		l2.setText("太小");  
//			  		p.setBackground(Color.blue);
//			  	  } 
//			  	  else {
//			  		  l2.setText("正确！");
//			  		  p.setBackground(Color.white);
//			  		  tf.setEditable(false);
//			  	  }
//			  	  count+=1;  
//			  	  l1.setText("你已经猜了"+String.valueOf(count)+"次");
//			  }
//			  else if (buttonName.equals("重新开始")) {
//				  num = (int)(1+Math.random()*(1000-1+1));
//				  count = 0;
//				  l1.setText("你已经猜了"+String.valueOf(count)+"次");
//				  tf.setText("");
//				  l2.setText("---");
//				  System.out.print("\n新的数");
//				  System.out.print(num);
//				  p.setBackground(Color.white);
//			  }
//			  else if (buttonName.equals("退出")) {
//				  System.out.print("\nout!!");
//				  System.exit(0);
//			  }
//			  else;
//
//		  }
//	  }
//	  
//	  public static void main(String[] args)
//	  {
//		  Guess test = new Guess();
//		  System.out.print(test.num);
//	  }
//	  
//}