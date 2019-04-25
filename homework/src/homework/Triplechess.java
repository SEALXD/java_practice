package homework;

import javax.swing.JOptionPane;

public class Triplechess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0,j = 0;
		String[] board = {"|     |    |    |","|     |    |    |","|     |    |    |"};
		String line = "________";
		int[][] chess = {{0,0,0},{0,0,0},{0,0,0}};
		boolean full = checkFull(chess);
		int win = checkWin(chess);
		while (win == 0 && full != true ) {
			String input = JOptionPane.showInputDialog(board[0]+"\n"+line+"\n"+board[1]+
					"\n"+line+"\n"+board[2]+"\n请输入位置\"x,y\",以0开始"); //显示一个有输入框的对话框
			int x = input.charAt(0)-'0';
			int y = input.charAt(2)-'0';
			if(chess[x][y] != 0) {
				JOptionPane.showMessageDialog(null, "该位置已经有棋子了！","message",JOptionPane.WARNING_MESSAGE);
			}
			else {
				chess[x][y] = 2; //玩家下子 修改棋盘记录;
				StringBuffer str = new StringBuffer(board[x]); //将第y行转换为stringbuffer
				int pos = y*5+3;
				str.setCharAt(pos, 'o');
				String temp = str.toString();//转换为string类并替换
				board[x] = temp;
				full = checkFull(chess);
				win = checkWin(chess);
				if(win != 0 || full == true ) {
					break;
				}
				else {
					int a=-1,b=-1;
					for(i=0;i<3;i++) {
						for(j=0;j<3;j++) {
							if (chess[i][j] == 0) {
								chess[i][j] = 1;
								a = i;
								b = j;
								break;}
					}
						if (a!=-1 || b!=-1)
							break;
				}//遍历找到空闲的棋盘格
				StringBuffer str2 = new StringBuffer(board[a]); //电脑下子 修改
				int pos2 = b*5+3;
				str2.setCharAt(pos2, '*');
				String temp2 = str2.toString();//转换为string类并替换
				board[a] = temp2;	
				char ii = (char) (a + '0');
				char jj = (char) (b + '0');
				JOptionPane.showMessageDialog(null, "下子成功！电脑下在了(" + ii + "," + jj + ")位置");
				full = checkFull(chess);
				win = checkWin(chess);
				}
			}	
			/*for(int[] a:chess)
		     {
		    	 for(int b:a)
		    	 {
		    		 System.out.print(b+" ");
		    	 }
		    	 System.out.println();//换行
		     }*/ //用来检查chess
		}
		if(win == 1)
			JOptionPane.showMessageDialog(null, "输了好可惜，再来一局吧！");
		else if(win == 2)
			JOptionPane.showMessageDialog(null, "恭喜你，赢啦！");
		else 
			JOptionPane.showMessageDialog(null, "棋盘下满了，平局~");
		/*for(int[] a:chess) 
	     {
	    	 for(int b:a)
	    	 {
	    		 System.out.print(b+" ");
	    	 }
	    	 System.out.println();//换行
	     } */
	}
	
	public static int checkWin(int arr[][]){	
		for(int i=0;i<3;i++) { 
			if(arr[i][0]==1 && arr[i][1]==1 && arr[i][2]==1)
				return 1; //机器赢
			else if (arr[i][0]==2 && arr[i][1]==2 && arr[i][2]==2)
				return 2; //玩家赢
			else if (arr[0][i]==1 && arr[1][i]==1 && arr[2][i]==1)
				return 1; //机器赢
			else if (arr[0][i]==2 && arr[1][i]==2 && arr[2][i]==2)
				return 2; //玩家赢
		}//检查行和列
		int count1 = 0;
		int count2 = 0;
		for(int i=0;i<3;i++) { //检查左对角线
			if(arr[i][i]==1)
				count1+=1;
			else if(arr[i][i]==2)
				count2+=1;
		}
		if(count1==3)
			return 1;
		else if(count2==3)
			return 2;
		else {
			count1 = 0;
			count2 = 0; //检查右对角线
			for(int i=0;i<3;i++) {
			if(arr[i][2-i]==1)
				count1+=1;
			else if(arr[i][2-i]==2)
				count2+=1;
		}
		if(count1==3)
			return 1;
		else if(count2==3)
			return 2;	
		else
			return 0;
		}	
	}
	public static boolean checkFull(int arr[][]){	//检查棋盘是否下满
		int count=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(arr[i][j] != 0)
				count+=1;
			}
		}
					
	    if(count == 9)
	    	return true;
	    else 
	    	return false;
	}

}
