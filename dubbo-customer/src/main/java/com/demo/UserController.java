/*
 * @(#)com.demo 2019/2/27/027
 *
 * Copy Right@ 人人译视界
 */


package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <pre>
 * @author tuwei
 *
 * @version 0.9
 *
 * 修改版本: 0.9
 * 修改日期: 2019/2/27/027
 * 修改人 :  tuwei
 * 修改说明: 初步完成
 * 复审人 ：
 * </pre>
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerPropertiesFactoryBean customerPropertiesFactoryBean;

	@Value("#{configProperties['username']}")
	private String username;

	@Value("#{configProperties['password']}")
	private String password;

	@Value("#{configProperties['url']}")
	private String url;

	@Value("#{configProperties['userNm']}")
	private String userNm;

	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello(String name) {
		String welcome = userService.sayHi(name);
		welcome = welcome + "," + username + "," + password + "," + url + ",userNm:" + userNm;
		welcome = welcome + "<br/>newUserNm:" + customerPropertiesFactoryBean.getNewProperties().getProperty("userNm");
		return welcome;
	}
}
