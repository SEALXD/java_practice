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
		System.out.print("书籍名称：" + name + "\n书籍编号：" + number + "\n借书学生：" + borrowStudent + "\n");
		System.out.print("---------------\n");
	}
	public String getBookName() 
	{
		return this.name;
	}
}

