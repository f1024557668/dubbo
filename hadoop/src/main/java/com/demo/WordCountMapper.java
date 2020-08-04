/*
 * @(#)com.demo 2019/4/15/015
 *
 * Copy Right@ 人人译视界
 */


package com.demo;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

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
public class WordCountMapper extends Mapper<LongWritable,Text,Text, IntWritable>{
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
// IntWritable one=new IntWritable(1);
		//得到输入的每一行数据
		String line=value.toString();

		StringTokenizer st=new StringTokenizer(line);
//StringTokenizer "kongge"
		while (st.hasMoreTokens()){
			String word= st.nextToken();
			context.write(new Text(word),new IntWritable(1));   //output
		}
	}
}