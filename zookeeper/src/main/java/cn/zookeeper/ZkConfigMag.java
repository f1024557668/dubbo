/*
 * @(#)cn.zookeeper 2019/2/28/028
 *
 * Copy Right@ 人人译视界
 */


package cn.zookeeper;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.ZkClient;

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
public class ZkConfigMag {
	private Config config;
	/**
	 * 从数据库加载配置
	 */
	public Config downLoadConfigFromDB(){
		//getDB
		config = new Config("Tom", "pw");
		return config;
	}

	/**
	 * 配置文件上传到数据库
	 */
	public void upLoadConfigToDB(String nm, String pw){
		if(config==null)
			config = new Config();
		config.setUserNm(nm);
		config.setUserPw(pw);
		//updateDB
	}

	/**
	 * 配置文件同步到zookeeper
	 */
	public void syncConfigToZk(){
		ZkClient zk = new ZkClient("47.97.120.39:2181,47.97.120.39:2182,47.97.120.39:2183");
		if(!zk.exists("/zkTestConfig")){
			zk.createPersistent("/zkTestConfig",true);
		}
		zk.writeData("/zkTestConfig", JSON.toJSONString(downLoadConfigFromDB()));
		zk.close();
	}
}
