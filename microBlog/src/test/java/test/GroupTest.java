package test;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.microblog.bean.Blog;
import com.microblog.bean.Concern;
import com.microblog.bean.Groups;
import com.microblog.bean.User;
import com.microblog.biz.BlogBiz;
import com.microblog.biz.ConcernBiz;
import com.microblog.biz.GroupsBiz;
import com.microblog.biz.UserBiz;

import junit.framework.TestCase;

public class GroupTest extends TestCase {
	

	
	//查询用户分组
	public void testApp09() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		GroupsBiz gb = (GroupsBiz) ac.getBean("groupsBizImpl");
		
		User user = new User();
		user.setUid(1);
		List<Groups> g =gb.findUserGroups(user);
		
		for (Groups groups : g) {
			System.out.println(groups.getName());
		}
		
	}
	
	//查询粉丝数
	public void testApp10() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		ConcernBiz cb = (ConcernBiz) ac.getBean("concernBizImpl");
		
		Concern concer = new Concern();
		concer.setB_uid(1);
		System.out.println( cb.getFansCount(concer) );
		
	}
	//查询用户粉丝名字
	public void testApp11() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		ConcernBiz cb = (ConcernBiz) ac.getBean("concernBizImpl");
		User user =new User();
		user.setUid(1);
		List<User> l = cb.getConcern(user);
		System.out.println("关注数:"+l.size());
		for (User u : l) {
			System.out.println(u.getSign());
		}
		
		
		
	}

}
