/*
 * @(#)cn.zookeeper 2019/2/28/028
 *
 * Copy Right@ 人人译视界
 */


package cn.zookeeper;

import java.io.Serializable;

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
public class Config implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userNm;
	private String userPw;

	public Config() {
	}
	public Config(String userNm, String userPw) {
		this.userNm = userNm;
		this.userPw = userPw;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
}
