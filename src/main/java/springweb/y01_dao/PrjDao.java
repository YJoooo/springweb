package springweb.y01_dao;
// javaexp.a13_database.A05_PreDAO

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import springweb.z01_vo.*;


//  DAO(database access object)
//  전화기와 동일 : 연결/대화/결과를통해 받은 데이터/종료-자원해제,예외처리
public class PrjDao {
	private Connection con; // 연결객체
	private PreparedStatement pstmt; // 대화객체
	private ResultSet rs; // data를 받는 결과 객체 select sql의 처리 결과로 활용

	public void setConn() throws SQLException { // 예외를 외부에 던전 한번에 처리할 수 있게함.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("클래스 에러:" + e.getMessage());
		}
	}

	// 3. 각 기능별 메서드
	// 1) emp를 출력하는 기능메서드
	public void showEmp() {
		// 선언한 공통 연결메서드 호출
		try {
			// 1. 필드에 선언된 private Connection con; 에 객체가 생성이 된다.
			setConn();
			// 2. 대화객체선언..
			// 1) sql 문 작성
			String sql = "select * from emp01 ";
//					2) 대화객체 생성.
			pstmt = con.prepareStatement(sql);
			// 3) 대화객체를 통해 결과객체 생성, 매개변수로 sql문을 할당 처리한다.
			rs = pstmt.executeQuery();
			// 4) 전체 데이터 가져오기
//			//         저장된 갯수만큼 next()를 호출..
			/*
			 * -- ResulSet 으로 아래 내용이 할당이 된다. -- .next() : 행단위로 이동 처리함. - 그 행에 데이터가 있으면
			 * true/없으면 false -- .getString("컬럼명") : 해당 row에 상단에 선언된 column명을 기준으로 데이터를
			 * 가져온다. -- 주의 select @@ 최종 컬럼명이기 alias가 있으면 alias명으로 호출하여야 한다. -- .get테이터유형()
			 * -- ex) rs.getInt("empno"), rs.getDate("hiredate"), sal의 경우 number(4,2)로
			 * 실수형이기에 -- rs.getDouble("sal")
			 */

			int cnt = 1;
			while (rs.next()) { // 행단위로 이동 되게 한다.
				System.out.print(cnt + "행\t" + rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getDouble("sal") + "\t");
				System.out.print(rs.getDouble("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
				cnt++;
			}
			// 자원해제(열린순서 반대 방향)
			rs.close();
			pstmt.close();
			con.close();
			// 예외 처리.
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * # return 객체 설정과 키워드 검색
	 * 
	 15:05에 진행하겠습니다.
	 
	 */
	public ArrayList<Emp> getEmpList(Map<String, String> map) {
		ArrayList<Emp> empList = new ArrayList<Emp>();
		try {
			setConn();
			String sql = "SELECT *\r\n" + "from emp01 \r\n" 
						+ "WHERE ename LIKE '%'|| ? ||'%'\n"
						+ "AND job LIKE '%'|| ? ||'%' "; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, map.get("ename"));
			pstmt.setString(2, map.get("job"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				empList.add(new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
						rs.getDate("hiredate"), rs.getDouble("sal"), rs.getDouble("comm"), rs.getInt("deptno")));
			}
			System.out.println();
			// 자원해제(열린순서 반대 방향)
			//
			rs.close();
			pstmt.close();
			con.close();
			// 예외 처리.
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return empList;
	}

	/*
	 * # return 객체 설정과 키워드 검색
	 */
		public ArrayList<Emp> getEmpList2(Emp sch) {
			ArrayList<Emp> empList = new ArrayList<Emp>();
			try {
				setConn();
				String sql = "select * from emp where ename like '%' || ? || '%' and job like '%' || ? || '%'";
				// 1. 에러 대비 : sql System.out.println(sql); 반드시 확인.
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				// 2. ?와 mapping 되는 데이터 갯수, type(유형), null
				int cnt=1;
				if(sch.getEname()!=null) {
					pstmt.setString(cnt++, sch.getEname());
				}
				if(sch.getJob()!=null) {
					pstmt.setString(cnt++, sch.getJob());
				}
				rs = pstmt.executeQuery();
				// 3. rs.getInt("empno") : select는 선택 컬럼명과 타입
			while (rs.next()) {
				empList.add(new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
						rs.getDate("hiredate"), rs.getDouble("sal"), rs.getDouble("comm"), rs.getInt("deptno")));
			}
			// 자원해제(열린순서 반대 방향)
			rs.close();
			pstmt.close();
			con.close();
			// 예외 처리.
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return empList;
	}

	/*
	 * # return 객체 설정과 키워드 검색 INSERT INTO emp01 values(1001,'마길동','대리',7780,
	 * to_date('2010-10-10','YYYY-MM-DD'),3500,100,10)
	 * 
	 */
	public void insertEmp(Emp ins) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "INSERT INTO emp01 values(?,?,?,?,\r\n" + "	to_date(?,'YYYY-MM-DD'),?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ins.getEmpno());
			pstmt.setString(2, ins.getEname());
			pstmt.setString(3, ins.getJob());
			pstmt.setInt(4, ins.getMgr());
			pstmt.setString(5, ins.getHiredate_s());
			pstmt.setDouble(6, ins.getSal());
			pstmt.setDouble(7, ins.getComm());
			pstmt.setInt(8, ins.getDeptno());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리..
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * # return 객체 설정과 키워드 검색 INSERT INTO emp01 values(1001,'마길동','대리',7780,
	 * to_date('2010-10-10','YYYY-MM-DD'),3500,100,10)
	 * 
	 */
	public void updateEmp(Emp ins) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "UPDATE EMP01 \r\n"
					+ "	SET ename=?,\r\n"
					+ "		job = ?,\r\n"
					+ "		mgr = ?,\r\n"
					+ "		hiredate = to_date(?,'YYYY-MM-DD'),\r\n"
					+ "		sal = ?,\r\n"
					+ "		comm = ?,\r\n"
					+ "		deptno=?\r\n"
					+ "WHERE empno=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ins.getEname());
			pstmt.setString(2, ins.getJob());
			pstmt.setInt(3, ins.getMgr());
			pstmt.setString(4, ins.getHiredate_s());
			pstmt.setDouble(5, ins.getSal());
			pstmt.setDouble(6, ins.getComm());
			pstmt.setInt(7, ins.getDeptno());
			pstmt.setInt(8, ins.getEmpno());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리..
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void deleteEmp(int empno) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "delete from emp01 where empno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리..
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * # return 객체 설정과 키워드 검색
	 */
		public Emp getEmpDetail(int empno) {
			Emp emp = new Emp();
			try {
				setConn();
				String sql = "SELECT empno, ename, job, mgr, \r\n"
						+ "to_char(hiredate,'YYY-MM-DD') hiredate_s, \r\n "
						+ "sal, comm, deptno\r\n"
						+ "FROM EMP01 \r\n"
						+ "WHERE empno=?"; // 주의 '?' (X>
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, empno);
				rs = pstmt.executeQuery();
			if (rs.next()) {
				emp = new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
						rs.getDate("hiredate_s"), rs.getDouble("sal"), rs.getDouble("comm"), rs.getInt("deptno"));
			}
			// 자원해제(열린순서 반대 방향)
			rs.close();
			pstmt.close();
			con.close();
			// 예외 처리.
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return emp;
	}
		public ArrayList<Member> getMemList(Member sch) {
		      ArrayList<Member> memList = new ArrayList<Member>();
		      try {
		         setConn();
		         String sql = "select * \n"
		                  + "from member \n"
		                  + "where id like '%'|| ? ||'%' \n"
		                  + "and pw like '%'|| ? ||'%'";
		         System.out.println(sql);
		         pstmt = con.prepareStatement(sql);
		         pstmt.setString(1, sch.getId());
		         pstmt.setString(2, sch.getPass());
		         rs = pstmt.executeQuery();
		         while(rs.next()) {
		            memList.add(new Member(
		                        rs.getString("id"),
		                        rs.getString("pw"),
		                        rs.getString("name"), 
		                        rs.getInt("point"),
		                        rs.getString("auth") )
		                        );
		         }
		         rs.close();
		         pstmt.close();
		         con.close();
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      } catch (Exception e) {
		         System.out.println("일반 예외 : " + e.getMessage());
		      } finally {
		         if(rs!=null) {
		            try {
		               rs.close();
		            } catch (SQLException e) {
		               // TODO Auto-generated catch block
		               e.printStackTrace();
		            }
		         }
		         if(pstmt!=null) {
		            try {
		               pstmt.close();
		            } catch (SQLException e) {
		               // TODO Auto-generated catch block
		               e.printStackTrace();
		            }
		         }
		         if(con!=null) {
		            try {
		               con.close();
		            } catch (SQLException e) {
		               // TODO Auto-generated catch block
		               e.printStackTrace();
		            }
		         }
		      }
		      return memList;
		   }
	public static void main(String[] args) {

	}

}
