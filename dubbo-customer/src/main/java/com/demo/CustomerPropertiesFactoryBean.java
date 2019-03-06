/*
 * @(#)com.demo 2019/3/6/006
 *
 * Copy Right@ 人人译视界
 */


package com.demo;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.config.PropertiesFactoryBean;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * <pre>
 * @author tuwei
 *
 * @version 0.9
 *
 * 修改版本: 0.9
 * 修改日期: 2019/3/6/006
 * 修改人 :  tuwei
 * 修改说明: 初步完成
 * 复审人 ：
 * </pre>
 */
public class CustomerPropertiesFactoryBean extends PropertiesFactoryBean {
	private Properties newProperties;
	public Properties getNewProperties() {
		return newProperties;
	}
	@Override
	protected Properties mergeProperties() throws IOException {
		Properties properties = super.mergeProperties();
		newProperties = loadZkProperties();
		newProperties.putAll(properties);
		System.out.println(JSON.json(newProperties));
		return newProperties;
	}

	private String config;
	private Properties loadZkProperties() {
		Properties properties = new Properties();
		ZkClient zk = new ZkClient("47.97.120.39:2181,47.97.120.39:2182,47.97.120.39:2183");
		config = zk.readData("/zkTestConfig");
		zk.subscribeDataChanges("/zkTestConfig", new IZkDataListener() {
			public void handleDataChange(String arg0, Object arg1)
					throws Exception {
				config = (String) arg1;
				try {
					newProperties.putAll(JSON.parse(config, Map.class));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.println("监听到配置文件被修改：" + config.toString());
			}

			public void handleDataDeleted(String arg0) throws Exception {
				config = null;
				System.out.println("监听到配置文件被删除");
			}

		});
		try {
			properties.putAll(JSON.parse(config, Map.class));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
