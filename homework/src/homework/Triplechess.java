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
					"\n"+line+"\n"+board[2]+"\n������λ��\"x,y\",��0��ʼ"); //��ʾһ���������ĶԻ���
			int x = input.charAt(0)-'0';
			int y = input.charAt(2)-'0';
			if(chess[x][y] != 0) {
				JOptionPane.showMessageDialog(null, "��λ���Ѿ��������ˣ�","message",JOptionPane.WARNING_MESSAGE);
			}
			else {
				chess[x][y] = 2; //������� �޸����̼�¼;
				StringBuffer str = new StringBuffer(board[x]); //����y��ת��Ϊstringbuffer
				int pos = y*5+3;
				str.setCharAt(pos, 'o');
				String temp = str.toString();//ת��Ϊstring�ಢ�滻
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
				}//�����ҵ����е����̸�
				StringBuffer str2 = new StringBuffer(board[a]); //�������� �޸�
				int pos2 = b*5+3;
				str2.setCharAt(pos2, '*');
				String temp2 = str2.toString();//ת��Ϊstring�ಢ�滻
				board[a] = temp2;	
				char ii = (char) (a + '0');
				char jj = (char) (b + '0');
				JOptionPane.showMessageDialog(null, "���ӳɹ�������������(" + ii + "," + jj + ")λ��");
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
		    	 System.out.println();//����
		     }*/ //�������chess
		}
		if(win == 1)
			JOptionPane.showMessageDialog(null, "���˺ÿ�ϧ������һ�ְɣ�");
		else if(win == 2)
			JOptionPane.showMessageDialog(null, "��ϲ�㣬Ӯ����");
		else 
			JOptionPane.showMessageDialog(null, "���������ˣ�ƽ��~");
		/*for(int[] a:chess) 
	     {
	    	 for(int b:a)
	    	 {
	    		 System.out.print(b+" ");
	    	 }
	    	 System.out.println();//����
	     } */
	}
	
	public static int checkWin(int arr[][]){	
		for(int i=0;i<3;i++) { 
			if(arr[i][0]==1 && arr[i][1]==1 && arr[i][2]==1)
				return 1; //����Ӯ
			else if (arr[i][0]==2 && arr[i][1]==2 && arr[i][2]==2)
				return 2; //���Ӯ
			else if (arr[0][i]==1 && arr[1][i]==1 && arr[2][i]==1)
				return 1; //����Ӯ
			else if (arr[0][i]==2 && arr[1][i]==2 && arr[2][i]==2)
				return 2; //���Ӯ
		}//����к���
		int count1 = 0;
		int count2 = 0;
		for(int i=0;i<3;i++) { //�����Խ���
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
			count2 = 0; //����ҶԽ���
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
	public static boolean checkFull(int arr[][]){	//��������Ƿ�����
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
