/*
 * @(#)com.learn.ioc 2020/8/4/0004
 *
 * Copy Right@ 人人译视界
 */


package com.learn.ioc;

import java.util.Objects;

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
public class GenericBeanDefinition implements HkBeanDefinition {
	private Class<?> beanClass;
	private String scope = HkBeanDefinition.SINGLETION;

	private String initMethodName;

	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setInitMethodName(String initMethodName) {
		this.initMethodName = initMethodName;
	}

	@Override
	public Class<?> getBeanClass() {
		return beanClass;
	}

	@Override
	public String getScope() {
		return scope;
	}

	@Override
	public boolean isSingleton() {
		return Objects.equals(scope, HkBeanDefinition.SINGLETION);
	}

	@Override
	public boolean isPrototype() {
		return Objects.equals(scope, HkBeanDefinition.PROTOTYPE);
	}

	@Override
	public String getInitMethodName() {
		return initMethodName;
	}
}
