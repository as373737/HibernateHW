package HibernateHW.model;

import java.util.List;



public interface IBookDao {
	public Book insert(Book boook);
	public List<Book> selectLikeName(String name);
	public List<Book> selectAll();
    public Book update(int bookid, String bookname,int price);
    public boolean deleteById(int bookid);
}
