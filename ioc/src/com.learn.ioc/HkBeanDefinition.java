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
public interface HkBeanDefinition {
	final static String SINGLETION = "singleton";
	final static String PROTOTYPE = "prototype";

	Class<?> getBeanClass();

	String getScope();

	boolean isSingleton();

	boolean isPrototype();

	String getInitMethodName();
}
