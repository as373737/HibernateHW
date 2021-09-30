package HibernateHW.model;

import java.util.List;



public interface IBookDao {
	public Book insert(Book boook);
	public Book selectById(int bookid);
	public List<Book> selectAll();
    public Book update(Book book);
    public boolean deleteById(int bookid);
}
