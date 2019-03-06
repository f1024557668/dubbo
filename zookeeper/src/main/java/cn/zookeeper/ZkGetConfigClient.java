/*
 * @(#)cn.zookeeper 2019/2/28/028
 *
 * Copy Right@ 人人译视界
 */


package cn.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
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
public class ZkGetConfigClient {
	private Config config;

	public Config getConfig() {
		ZkClient zk = new ZkClient("47.97.120.39:2181,47.97.120.39:2182,47.97.120.39:2183");
		config = (Config) zk.readData("/zkTestConfig");
		System.out.println("加载到配置：" + config.toString());

		//监听配置文件修改
		zk.subscribeDataChanges("/zkTestConfig", new IZkDataListener() {
			public void handleDataChange(String arg0, Object arg1)
					throws Exception {
				config = (Config) arg1;
				System.out.println("监听到配置文件被修改：" + config.toString());
			}

			public void handleDataDeleted(String arg0) throws Exception {
				config = null;
				System.out.println("监听到配置文件被删除");
			}

		});
		return config;
	}

	public static void main(String[] args) {
		ZkGetConfigClient client = new ZkGetConfigClient();
		client.getConfig();
		System.out.println(client.config.toString());
		for (int i = 0; i < 10; i++) {
			System.out.println(client.config.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
