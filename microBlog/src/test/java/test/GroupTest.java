package test;

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
	
	//分组中间表插入数据
	public void testApp07() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		UserBiz userBiz =  (UserBiz) ac.getBean("userBizImpl");
		User user = new User();
		user.setUid(1);
		Groups g = new Groups();
		g.setId(5);
		user.setGroup(g);
		userBiz.addUserGroups(user);
	}
	//往分组表里插入数据
	public void testApp08() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		GroupsBiz gBiz = (GroupsBiz) ac.getBean("groupsBizImpl");
		Groups group = new Groups();
		group.setName("特别关注");
		gBiz.addGroup(group);
		
		UserBiz userBiz =  (UserBiz) ac.getBean("userBizImpl");
		User user = new User();
		user.setUid(1);
		Groups g = new Groups();
		g.setId(5);
		user.setGroup(g);
		userBiz.addUserGroups(user);
	}
	

}
