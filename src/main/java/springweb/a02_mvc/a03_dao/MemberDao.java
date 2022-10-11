package springweb.a02_mvc.a03_dao;

import org.springframework.stereotype.Repository;

import springweb.z01_vo.Member;
//springweb.a02_mvc.a03_dao.MemberDao
@Repository
public interface MemberDao {
	public int checkMember(String id);
	public Member getMember(Member login);

}
