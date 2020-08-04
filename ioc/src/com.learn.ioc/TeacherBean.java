/*
 * @(#)com.learn.ioc 2020/8/4/0004
 *
 * Copy Right@ 人人译视界
 */


package com.learn.ioc;

/**
 * <pre>
 * @author tuwei
 *
 * @version 0.9
 *
 * 修改版本: 0.9
 * 修改日期: 2020/8/4/0004
 * 修改人 :  tuwei
 * 修改说明: 初步完成
 * 复审人 ：
 * </pre>
 */
public class TeacherBean {

	public void teach(){
		System.out.println(this+"执行了teach方法，老师要开始上课了！");
	}

	public void init(){
		System.out.println("Teacher类的初始化init方法被执行了");
	}

}