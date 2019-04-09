/*
 * @(#)cn.kafka 2019/4/9/009
 *
 * Copy Right@ 人人译视界
 */


package cn.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

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
public class ConsumerDemo {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers","47.97.120.39:9092");//get a connection to zookeeper.very important!rather than broker's port
		//每个消费者分配独立的组号
		props.put("group.id", "test");

		//如果value合法，则自动提交偏移量
		props.put("enable.auto.commit", "true");

		//设置多久一次更新被消费消息的偏移量
		props.put("auto.commit.interval.ms", "1000");

		//设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");

		Consumer<String,String> consumer  = new KafkaConsumer<>(props);
		consumer.subscribe(Collections.singletonList("test"));

		while(true){
			ConsumerRecords<String,String> records = consumer.poll(100);
			for(ConsumerRecord re:records){
				System.out.println(re.value());
			}
		}
	}
}
