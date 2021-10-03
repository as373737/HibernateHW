package HibernateHW.model;

import java.util.List;



public interface IBookDao {
	public Book insert(Book boook);
	public List<Book> selectLikeName(String name);
	public List<Book> selectAll();
    public Book update(Book book);
    public boolean deleteById(int bookid);
    public List<Book> deleteByName(String name);
}
