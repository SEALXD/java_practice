package homework2;

public class Student {

	private String name;
	private int number;
	private String [] borrowedBooks = null; //用来记录书名
	public Student (String n, int no) 
	{
		name = n;
		number = no;
	}
	public void borrowBook(String bookName) 
	{
		if(borrowedBooks == null)//如果为空直接赋值
		{
			String[] tmp = new String[1];
			tmp[0] = bookName;
			borrowedBooks = tmp;
		}
			
		else {
			int size = borrowedBooks.length;  //获取数组长度
				String[] tmp = new String[size + 1];  //新建临时字符串数组，在原来基础上长度加一
				for (int i = 0; i < size; i++){  //先遍历将原来的字符串数组数据添加到临时字符串数组
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
		
		for(int j=0; j<borrowedBooks.length-1;j++) //前面的书名直接复制，跳过目标书名继续复制，达到删除的效果
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
		System.out.print("学生名称：" + name + "\n学生编号：" + number + "\n在借书籍：");
		if(borrowedBooks != null) {
			for(int i=0; i<borrowedBooks.length;i++)
				System.out.print(borrowedBooks[i]+"  ");
			System.out.print("\n");
		}
		else{
			System.out.print("没有在借书籍\n");
		};
		System.out.print("---------------\n");
	}
	
	public String getName()
	{
		return this.name;
	}
}
