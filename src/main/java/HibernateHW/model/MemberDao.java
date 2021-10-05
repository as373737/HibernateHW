package HibernateHW.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;





public class MemberDao implements IMemberDao {
	private Session session;

	public MemberDao(Session session) {
        this.session = session;
	}
	
	@Override
	public Member insert(Member member) {
		Member mBean = new Member();
		mBean.setUsername(member.getUsername());
		mBean.setAccount(member.getAccount());
		mBean.setPassword(member.getPassword());
		mBean.setEmailAddress(member.getEmailAddress());
		mBean.setPhone(member.getPhone());
		mBean.setStatus(member.getStatus());
		session.save(mBean);
//		session.getTransaction().commit();
		return mBean;
	}

	@Override
	public boolean checkAccount(String account) {
		Query<Member> query=session.createQuery("from Member where account=:account",Member.class);
		query.setParameter("account", account);
		Member resultBean =query.uniqueResult();
		if(resultBean!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Member> selectAll() {
		Query<Member> query = session.createQuery("from Member", Member.class);
		return query.list();
	}

	@Override
	public Member update(int userid, String username) {
		Member resultBean = session.get(Member.class, userid);
		
		if(resultBean!=null) {
			resultBean.setUsername(username);
		}
		
		return resultBean;
	}

	@Override
	public boolean deleteById(int userid) {
		Member resultBean = session.get(Member.class, userid);
		    
		    if(resultBean!=null) {
		    	session.delete(resultBean);
		    	return true;
		    }
		    
		    return false;
		
	}

	@Override
	public boolean checkUser(String account, String password) {
		Query<Member> query=session.createQuery("from Member where account=:account and password=:password",Member.class);
		query.setParameter("account", account);
		query.setParameter("password", password);
		Member resultBean =query.uniqueResult();
		if(resultBean!=null) {
			return true;
		}
		return false;
	}

}
