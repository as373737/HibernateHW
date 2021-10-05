package HibernateHW.model;

import java.util.List;

public interface IMemberDao {
	public Member insert(Member mBean);
	public boolean checkAccount(String account);
	public List<Member> selectAll();
    public Member update(int userid, String username);
    public boolean deleteById(int userid);
    public boolean  checkUser(String account,String password);
}
