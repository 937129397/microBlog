package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.microblog.bean.Blog;
import com.microblog.bean.Groups;
import com.microblog.bean.User_group;
import com.microblog.biz.BlogBiz;
import com.microblog.biz.User_groupBiz;

import junit.framework.TestCase;

public class GroupTest extends TestCase {
	
	public void testApp07() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		User_groupBiz ugBiz = (User_groupBiz) ac.getBean("user_groupBizImpl");
		User_group ug = new User_group();
		Groups g = new Groups();
		g.setId(1);
		ug.setUid(1);
		ug.getGroup().getId();
		ugBiz.addUserGroups(ug);
	}

}
