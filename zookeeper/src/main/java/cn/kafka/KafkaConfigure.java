/*
 * @(#)cn.kafka 2019/4/9/009
 *
 * Copy Right@ 人人译视界
 */


package cn.kafka;

/**
 * <pre>
 * @author tuwei
 *
 * @version 0.9
 *
 * 修改版本: 0.9
 * 修改日期: 2019/4/9/009
 * 修改人 :  tuwei
 * 修改说明: 初步完成
 * 复审人 ：
 * </pre>
 */
public class KafkaConfigure {
	public final static String ZK = "47.97.120.39:2181,47.97.120.39:2182,47.97.120.39:2183";
	public final static String GROUP_ID = "demo_group";
	public final static String TOPIC = "demo";
	public final static String BROKER_LIST = "47.97.120.39:9092";
	public final static int BUFFER_SIZE = 64 * 1024;
	public final static int TIMEOUT = 20000;
	public final static int INTERVAL = 10000;
}
