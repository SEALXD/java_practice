package homework2;

public class Book
{
	private String name;
	private int number;
	private String borrowStudent;
	public  Book (String n, int no) 
	{
		name = n;
		number = no;
	}
	public void borrowBook(String name) 
	{
		borrowStudent = name;
	}
	public void returnBook() 
	{
		borrowStudent = null;
	}
	public void showInfo() 
	{
		System.out.print("�鼮���ƣ�" + name + "\n�鼮��ţ�" + number + "\n����ѧ����" + borrowStudent + "\n");
		System.out.print("---------------\n");
	}
	public String getBookName() 
	{
		return this.name;
	}
}

