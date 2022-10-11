package a01_diexp.z06_vo;
// a01_diexp.z06_vo.Dao
public class Dao {
	// jdbcDriver user pass
	private String jdbcDriver;
	private String user;
	private String pass;
	public Dao() {
		// TODO Auto-generated constructor stub
	}
	public Dao(String jdbcDriver, String user, String pass) {
		super();
		this.jdbcDriver = jdbcDriver;
		this.user = user;
		this.pass = pass;
	}
	public String getJdbcDriver() {
		return jdbcDriver;
	}
	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
