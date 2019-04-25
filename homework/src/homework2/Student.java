package homework2;

public class Student {

	private String name;
	private int number;
	private String [] borrowedBooks = null; //������¼����
	public Student (String n, int no) 
	{
		name = n;
		number = no;
	}
	public void borrowBook(String bookName) 
	{
		if(borrowedBooks == null)//���Ϊ��ֱ�Ӹ�ֵ
		{
			String[] tmp = new String[1];
			tmp[0] = bookName;
			borrowedBooks = tmp;
		}
			
		else {
			int size = borrowedBooks.length;  //��ȡ���鳤��
				String[] tmp = new String[size + 1];  //�½���ʱ�ַ������飬��ԭ�������ϳ��ȼ�һ
				for (int i = 0; i < size; i++){  //�ȱ�����ԭ�����ַ�������������ӵ���ʱ�ַ�������
					tmp[i] = borrowedBooks[i];
				}
				tmp[size] = bookName;
				borrowedBooks = tmp;
			}
	}
	
	public void returnBook(String bookName)
	{
		int i = 0;
		for(i=0; i<borrowedBooks.length;i++)
		{
			if(borrowedBooks[i] == bookName)
				break;
		}
		//System.out.print(i);
		String[] tmp = new String[borrowedBooks.length-1];
		
		for(int j=0; j<borrowedBooks.length-1;j++) //ǰ�������ֱ�Ӹ��ƣ�����Ŀ�������������ƣ��ﵽɾ����Ч��
		{
			if(j<i) {
				tmp[j] = borrowedBooks[j];
			}
			else
				tmp[j] = borrowedBooks[j+1];		
		}
		borrowedBooks = tmp;
	}
	
	public void showInfo() 
	{
		System.out.print("ѧ�����ƣ�" + name + "\nѧ����ţ�" + number + "\n�ڽ��鼮��");
		if(borrowedBooks != null) {
			for(int i=0; i<borrowedBooks.length;i++)
				System.out.print(borrowedBooks[i]+"  ");
			System.out.print("\n");
		}
		else{
			System.out.print("û���ڽ��鼮\n");
		};
		System.out.print("---------------\n");
	}
	
	public String getName()
	{
		return this.name;
	}
}
