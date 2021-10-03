package HibernateHW.model;

import java.util.List;



public interface IBookDao {
	public Book insert(Book boook);
	public Book selectById(int bookid);
	public List<Book> selectAll();
    public Book update(int bookid, String bookname,int price);
    public boolean deleteById(int bookid,String bookname);
}
