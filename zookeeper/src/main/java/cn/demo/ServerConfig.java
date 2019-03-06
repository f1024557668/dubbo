/*
 * @(#)cn.demo 2019/2/28/028
 *
 * Copy Right@ 人人译视界
 */


package cn.demo;

/**
 * <pre>
 * @author tuwei
 *
 * @version 0.9
 *
 * 修改版本: 0.9
 * 修改日期: 2019/2/28/028
 * 修改人 :  tuwei
 * 修改说明: 初步完成
 * 复审人 ：
 * </pre>
 */
public class ServerConfig {
	private String dbUrl;
	private String dbPwd;
	private String dbUser;
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbPwd() {
		return dbPwd;
	}
	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	@Override
	public String toString() {
		return "ServerConfig [dbUrl=” + dbUrl + “, dbPwd=” + dbPwd + “, dbUser=” + dbUser + “]";
	}
}
