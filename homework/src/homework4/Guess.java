//package homework4;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*;
//
//public class Guess extends JFrame{
//	  JPanel p;//���
//	  JButton b1,b2,b3;    //������ť
//	  JLabel l1,l2,l3;     //������ǩ
//	  JTextField tf;     //�ı���
//	  int num;//Ŀ������
//	  Guess()
//	  {
//		num = (int)(1+Math.random()*(1000-1+1));//����һ�����������Χ1-1000
//		p = new JPanel();
//		p.setLayout(null);//���ò���Ϊ�գ���ÿ������ֶ���������
//		p.setBackground(Color.white);
//		
//		l1 = new JLabel("���Ѿ�����0��");//��ǩ 
//		l1.setBounds(80, 20, 100, 20);
//		l2 = new JLabel("---");//��ǩ 
//		l2.setBounds(340, 60, 100, 20);
//		l3 = new JLabel("����²����");//��ǩ 
//		l3.setBounds(80, 60, 80, 20);
//        
//		b1 = new JButton("ȷ��");//��ť
//		b1.setBounds(80, 120, 60, 20);
//		b2 = new JButton("���¿�ʼ");
//		b2.setBounds(180, 120, 100, 20);
//		b3 = new JButton("�˳�");
//		b3.setBounds(300, 120, 60, 20);
//		Listener ourListener = new Listener(); // ����һ��listener       
//		b1.addActionListener(ourListener);
//		b2.addActionListener(ourListener);
//		b3.addActionListener(ourListener);
//          
//	    tf = new JTextField();//�ı���
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
//	  private class Listener implements ActionListener { //����һ���ڲ����������¼�  
//		  int count = 0;
//		  public void actionPerformed(ActionEvent e)
//		  {
//			  String buttonName = e.getActionCommand();
//			  String input;
//			  if (buttonName.equals("ȷ��")) {
//				  input =tf.getText();
//			  	  int inputnum = Integer.parseInt(input);//��ȡ�ı�����������ݲ�ת��Ϊint
//			  	  if(inputnum>num) {
//			  		  l2.setText("̫��");
//			  		  p.setBackground(Color.red);
//			  	  } 
//			  	  else if(inputnum<num) {
//			  		l2.setText("̫С");  
//			  		p.setBackground(Color.blue);
//			  	  } 
//			  	  else {
//			  		  l2.setText("��ȷ��");
//			  		  p.setBackground(Color.white);
//			  		  tf.setEditable(false);
//			  	  }
//			  	  count+=1;  
//			  	  l1.setText("���Ѿ�����"+String.valueOf(count)+"��");
//			  }
//			  else if (buttonName.equals("���¿�ʼ")) {
//				  num = (int)(1+Math.random()*(1000-1+1));
//				  count = 0;
//				  l1.setText("���Ѿ�����"+String.valueOf(count)+"��");
//				  tf.setText("");
//				  l2.setText("---");
//				  System.out.print("\n�µ���");
//				  System.out.print(num);
//				  p.setBackground(Color.white);
//			  }
//			  else if (buttonName.equals("�˳�")) {
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