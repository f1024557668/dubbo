/*
 * @(#)com.demo 2019/4/15/015
 *
 * Copy Right@ 人人译视界
 */


package com.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * <pre>
 * @author tuwei
 *
 * @version 0.9
 *
 * 修改版本: 0.9
 * 修改日期: 2019/4/15/015
 * 修改人 :  tuwei
 * 修改说明: 初步完成
 * 复审人 ：
 * </pre>
 */
public class WordCount {

	public static void main(String[] args) throws Exception {
		//创建配置对象
		Configuration conf=new Configuration();
		try{
			//创建job对象
			Job job = Job.getInstance(conf, "word count");
//Configuration conf, String jobName
			//设置运行job的类
			job.setJarByClass(WordCount.class);
			//设置mapper 类
			job.setMapperClass(WordCountMapper.class);
			//设置reduce 类
			job.setReducerClass(WordCountReducer.class);

			//设置map输出的key value
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);

			//设置reduce 输出的 key value
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);

			//设置输入输出的路径
			FileInputFormat.setInputPaths(job, new Path("F:\\dubbo\\hadoop\\input"));
			FileOutputFormat.setOutputPath(job, new Path("F:\\dubbo\\hadoop\\out"));

			//提交job
			boolean b = job.waitForCompletion(true);
			if(!b){
				System.out.println("wordcount task fail!");
			}

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}