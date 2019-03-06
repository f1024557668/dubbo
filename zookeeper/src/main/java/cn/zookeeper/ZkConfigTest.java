/*
 * @(#)cn.zookeeper 2019/2/28/028
 *
 * Copy Right@ 人人译视界
 */


package cn.zookeeper;

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
public class ZkConfigTest {
	public static void main(String[] args) {
		ZkConfigMag mag = new ZkConfigMag();
		Config config = mag.downLoadConfigFromDB();
		System.out.println("....加载数据库配置...." + config.toString());
		mag.syncConfigToZk();
		System.out.println("....同步配置文件到zookeeper....");

		//歇会，这样看比较清晰
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mag.upLoadConfigToDB("cwhcc", "passwordcc");
		System.out.println("....修改配置文件...." + config.toString());
		mag.syncConfigToZk();
		System.out.println("....同步配置文件到zookeeper....");
	}
}
