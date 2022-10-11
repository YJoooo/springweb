package springweb.a02_mvc.a03_dao;

import org.springframework.stereotype.Repository;

import springweb.z01_vo.BoardFile;
@Repository
public interface DaoExp {
	public void insertFile(BoardFile file);
}
