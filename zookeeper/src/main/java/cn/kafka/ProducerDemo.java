/*
 * @(#)cn.kafka 2019/4/9/009
 *
 * Copy Right@ 人人译视界
 */


package cn.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
public class ProducerDemo {

	public static void main(String[] args) throws InterruptedException {
		Properties props = new Properties();//New configuration file
		props.put("bootstrap.servers", "47.97.120.39:9092");//you should write specific ip address rather than localhost
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");//StringSerializer/IntegerSerializer/or other self-defined Serializer.
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		//the producer produce to  specified topic
		Producer<String, String> producer = new KafkaProducer<>(props);
		for (int i = 0; i < 10; i++) {
			// 生产一条消息的时间有点长
			producer.send(new ProducerRecord<>("test", Integer.toString(i), Integer.toString(i)), new ProducerAckCallback(new Date().getTime(), i, Integer.toString(i)));
		}
		System.out.println("Message sent successfully");
		producer.close();
	}
	static class ProducerAckCallback implements Callback {

		private final Long startTime;

		private final int key;

		private final String value;

		public ProducerAckCallback(Long startTime, int key, String value) {
			this.startTime = startTime;
			this.key = key;
			this.value = value;
		}

		@Override
		public void onCompletion(RecordMetadata metadata, Exception e) {
			long spendTime = System.currentTimeMillis() - startTime;
			if (null != metadata) {
				System.out.println("消息(" + key + "," + value + ")send to partition(" + metadata.partition()
						+ " and offest " + metadata.offset() + " and spend  " + spendTime + " ms");

			}
			if (e != null) {
				e.printStackTrace();
			}
		}
	}
}
