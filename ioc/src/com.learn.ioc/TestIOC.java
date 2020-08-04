/*
 * @(#)com.learn.ioc 2020/8/4/0004
 *
 * Copy Right@ 人人译视界
 */


package com.learn.ioc;

import org.junit.AfterClass;
import org.junit.Test;

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
public class TestIOC {
	static DefaultBeanFactory factory = new DefaultBeanFactory();

	@Test
	public void testRegist() throws Exception {
		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(TeacherBean.class);
//        bd.setScope(HkBeanDefinition.PROTOTYPE);
		bd.setInitMethodName("init");
		factory.registerBeanDefinition("teacher", bd);

	}

	@AfterClass
	public static void testGetBean() throws Exception {
		TeacherBean t = (TeacherBean) factory.getBean("teacher");
		TeacherBean t1 = (TeacherBean) factory.getBean("teacher");
		t.teach();
		t1.teach();
		System.out.println(t == t1);
	}

}
