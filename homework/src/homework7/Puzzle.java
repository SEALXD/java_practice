package homework7;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Puzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
	}

}

class Game extends JFrame {
	JButton start,end,up,down,left,right;
	JLabel win;
	List <Piece> pic ;
	int empty_index;
	int[][] arr = new int[3][3];
	
	public Game() {//构造函数
		 setTitle("图像测试");
         JPanel panel = new JPanel();
         panel.setLayout(null);//设置布局为空，对每个组件手动输入坐标
         
         /*设置按钮格式*/
         start = new JButton("开始");
         start.setBorder(BorderFactory.createRaisedBevelBorder());//凸起
         start.setBounds(650, 400, 60, 30);//位置
         end = new JButton("退出");
         end.setBorder(BorderFactory.createRaisedBevelBorder());//凸起
         end.setBounds(650, 450, 60, 30);//位置
         up = new JButton("↑");
         up.setBorder(BorderFactory.createRaisedBevelBorder());//凸起
         up.setBounds(820, 400, 60, 30);//位置
         down = new JButton("↓");
         down.setBorder(BorderFactory.createRaisedBevelBorder());//凸起
         down.setBounds(820, 500, 60, 30);//位置
         left = new JButton("←");
         left.setBorder(BorderFactory.createRaisedBevelBorder());//凸起
         left.setBounds(750, 450, 60, 30);//位置
         right = new JButton("→");
         right.setBorder(BorderFactory.createRaisedBevelBorder());//凸起
         right.setBounds(890, 450, 60, 30);//位置
         
         /*监听按钮*/
         Listener ourListener = new Listener(); // 共享一个listener  
         start.addActionListener(ourListener);
         end.addActionListener(ourListener);
         up.addActionListener(ourListener);
         down.addActionListener(ourListener);
         left.addActionListener(ourListener);
         right.addActionListener(ourListener);
         
         
         /*设置图片*/
         pic = new ArrayList<>();
         int choose = (int)(1+Math.random()*(3));//随机选择一张图片

         ImageIcon icon=new ImageIcon("images/pic"+choose+"/"+choose+".jpg");
         JLabel example = new JLabel(icon, JLabel.CENTER);
         example.setBounds(650, 20, 300, 300);
         
         for(int i = 0;i < 3; i++) {
        	 for(int j=0;j<3;j++) {
        		 int picnum = i*3+j+1;
        		 //System.out.println(id);
        		 String picpath = "images/pic"+choose+"/"+choose+"_0"+picnum+".jpg";
        		 Piece p = new Piece(200*j,200*i,picnum-1,picpath);
        		 pic.add(p);
        	 }
         }
         pic.remove(8); //去掉最后一张图片
         Piece p = new Piece(400,400,-1,"images/blank.jpg");//加入一张空白图
         pic.add(p);
         empty_index = 8;//从0开始最后一张是空白图
         
         
         System.out.println("pic:"+pic.size());
         /*生成位置矩阵 把id 赋值给矩阵*/
         for(int i = 0;i < 3; i++) {
        	 for(int j=0;j<3;j++) {
        		 arr[i][j] = pic.get(i*3+j).pic_id;
        	 }
         }
        	 
         win = new JLabel("拼图完成！ヽ(°▽°)ノ");
         win.setBounds(680, 600, 300, 60);
         win.setFont(new java.awt.Font("Dialog", 0, 26));
         win.setVisible(false);
        
         /*添加到panel*/
         for(int i = 0;i < 9; i++) {
        	 Piece tmp = pic.get(i);
        	 panel.add(tmp.label);  
         }
         panel.add(start);
         panel.add(end);
         panel.add(up);
         panel.add(down);
         panel.add(left);
         panel.add(right);
         panel.add(win);
         panel.add(example);
         add(panel);
         
         
         for(int i = 0;i < 3; i++) {
       	  for(int j=0;j<3;j++) {
       		   System.out.println("id"+arr[i][j]);		 
       	  }      		 
        }
 		
         /* 调整样式并显示JFrame*/
         setSize(1000,800);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 让JFrame的关闭按钮起作用
         setVisible(true);

	}
	
	 private class Listener implements ActionListener { //创建一个内部类来监听事件  
		
		 public void swapPic(int empty_index,int target_index ) { //根据坐标交换图片位置
			  Piece emp = pic.get(empty_index);//获取可移动的元素
			  Piece d = pic.get(target_index);
			  
			  if(target_index>empty_index) {
				  pic.remove(target_index); //先移出后面的
				  pic.remove(empty_index);
			  }else {
				  pic.remove(empty_index);
				  pic.remove(target_index); //先移出后面的
			  }
			  
			  emp.label.setBounds(200*(target_index%3), 200*(target_index/3), 200, 200);  //col% row/
			  d.label.setBounds(200*(empty_index%3), 200*(empty_index/3), 200, 200); 
			  
			  if(target_index>empty_index) {
				  pic.add(empty_index, d);
				  pic.add(target_index, emp);//交换位置
			  }else {
				  pic.add(target_index, emp);//交换位置
				  pic.add(empty_index, d);
			  }
			  int temp = arr[empty_index/3][empty_index%3] ;
			  arr[empty_index/3][empty_index%3] =  arr[target_index/3][target_index%3];
			  arr[target_index/3][target_index%3] = temp; //矩阵中交换位置
		 }
		 
		 public void actionPerformed(ActionEvent e)
		  {
			  String buttonName = e.getActionCommand();
			  int up_index = -1; //相对于空白块来讲
			  int down_index = -1;
			  int left_index = -1;
			  int right_index = -1;
			  int col,row;
			  col = empty_index % 3 ; //列
			  row = empty_index / 3 ;//行
			
			  if(col-1>=0)
				  left_index = row * 3 + col-1;
			  if(col+1<=2)
				  right_index = row * 3 + col+1;
			  if(row-1>=0)
				  up_index = (row-1) * 3 + col;
			  if(row+1<=2)
				  down_index = (row+1) * 3 + col;		  
			  
			  
			  if (buttonName.equals("开始")) {
				  /*随机打乱图片顺序*/
				  for(int i=0;i<67;i++) {
					  int change = (int)(Math.random()*(4));
					  System.out.println(change);
					  if(change==0&&empty_index>2) {//上
						  swapPic(empty_index,empty_index-3);
						  empty_index = empty_index-3; //更新empty_id
						  System.out.println("up");
					  }
					  else if(change==1&&empty_index<=5){ //下
						  swapPic(empty_index,empty_index+3);
						  empty_index = empty_index+3; //更新empty_id
						  System.out.println("down");
					  }
					  else if(change==2&&empty_index %3>=1){ //左
						  swapPic(empty_index,empty_index-1);
						  empty_index = empty_index-1; //更新empty_id
						  System.out.println("left");
					  }
					  else if(change==3&&empty_index %3<2) {//右
						  swapPic(empty_index,empty_index+1);
						  empty_index = empty_index+1; //更新empty_id 
						  System.out.println("right");
					  }
					  else;					 					  
				  }				  
			  }
			  else if (buttonName.equals("↑")) {
				  if(down_index!=-1) { //相对于空白块下方的元素 可以上移  
					  swapPic(empty_index,down_index);
					  empty_index = down_index; //更新empty_id
					  down_index = -1; //恢复默认
				  }
			  }
			  else if (buttonName.equals("↓")) {
				  if(up_index!=-1) {
					  swapPic(empty_index,up_index);
					  empty_index = up_index; //更新empty_id
					  up_index = -1; //恢复默认

				  }
			  }
			  else if (buttonName.equals("←")) {
				  if(right_index!=-1) { 
					  swapPic(empty_index,right_index);				  
					  empty_index = right_index; //更新empty_id
					  right_index = -1; //恢复默认
				  }
	  
			  }
			  else if (buttonName.equals("→")) {
				  if(left_index!=-1) { 
					  swapPic(empty_index,left_index);		  
					  empty_index = left_index; //更新empty_id
					  left_index = -1; //恢复默认
				  }
				  
			  }
			  else if (buttonName.equals("退出")) {
				  System.out.println("out!!");
				  System.exit(0);
			  }
			  else;

			  
		        for(int i = 0;i < 3; i++) {
		       	  for(int j=0;j<3;j++) {
		       		   System.out.print("arr_id"+arr[i][j]);
		       		   System.out.println("pic_id"+pic.get(i*3+j).pic_id);
		       	  }      		 
		        }
		        
		        int i;
		        for(i = 0;i < 8; i++) {
		        	if(pic.get(i).pic_id!=i) {
		        		break;
		        	}
		        }
		        if(i==8) win.setVisible(true);
		     
		  
		  }
	  }
}

class Piece {
	public int loc_x; 
	public int loc_y; //记录坐标
	public int pic_id; //记录id 判断游戏是否获胜
	ImageIcon img; //显示图片
	JLabel label;
	Piece(int x,int y,int id,String picpath){
		loc_x = x;
		loc_y = y;
		pic_id = id;
		label = new JLabel();
		img = new ImageIcon(picpath);
		label.setIcon(img);
		label.setBounds(loc_x, loc_y, 200, 200);
		
	}
}



