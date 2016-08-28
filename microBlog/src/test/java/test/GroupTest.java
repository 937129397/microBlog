package test;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.microblog.bean.Blog;
import com.microblog.bean.Groups;
import com.microblog.bean.User;
import com.microblog.biz.BlogBiz;
import com.microblog.biz.GroupsBiz;
import com.microblog.biz.UserBiz;

import junit.framework.TestCase;

public class GroupTest extends TestCase {
	

	
	//查询用户
	public void testApp09() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		UserBiz userBiz =  (UserBiz) ac.getBean("userBizImpl");
		User user = new User();
		user.setUid(1);
		List<Groups> g =userBiz.findUserGroups(user);
		
		for (Groups groups : g) {
			System.out.println(groups.getName());
		}
		
	}

}
