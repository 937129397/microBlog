package test;


import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.microblog.bean.Blog;
import com.microblog.bean.BlogModel;
import com.microblog.bean.Groups;
import com.microblog.bean.User;
import com.microblog.biz.BlogBiz;
import com.microblog.biz.GroupsBiz;
import com.microblog.biz.UserBiz;

public class Test extends TestCase {
	
	public void testApp07() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		BlogBiz ub=(BlogBiz) ac.getBean("blogBizImpl");
		Blog blog=new Blog();
		blog.setText("你好");
		blog.setSource(1);
		blog.setPic("图片");
		ub.saveBlog(blog);
	}
	
	public void logintest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		UserBiz ub = (UserBiz) ac.getBean("userBizImpl");
		
		User user = new User();
		
		user.setEmail("571880590@qq.com");
		user.setPassword("a");
		ub.loginByEmail(user);
		System.out.println("登陆成功");
	}
	
	
	public void registtest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		UserBiz ub = (UserBiz) ac.getBean("userBizImpl");
		
		User user = new User();
		
		user.setEmail("571880590@qq.com");
		user.setPassword("a");
		user.setTelephone(123141241212L);
		ub.loginByEmail(user);
		System.out.println("注册成功");
	}
	public void updatetest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		UserBiz ub = (UserBiz) ac.getBean("userBizImpl");
		
		User user = new User();
		user.setUid(1);
		user.setNickname("曾二宝");
		user.setSex(1);
		ub.update(user);
		System.out.println("更新成功");
		
	}
	//测试查找默认分组  -- 成功
	public void getDefaultGroups(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		GroupsBiz gb = (GroupsBiz) ac.getBean("groupsBizImpl");
		List<Groups> l =gb.findGroups();
		
		for (Groups g : l) {
			System.out.println(g.getName());
		}
		System.out.println("查询成功");
	}
	//测试redis点赞数的自增
	public void testApp09() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		BlogBiz ub=(BlogBiz) ac.getBean("blogBizImpl");
		System.out.println("当前点赞数"+ub.parse(2L,1));
	}
	//测试redis转发数
		public void testApp10() {
			ApplicationContext ac = new ClassPathXmlApplicationContext(
					"beans_mybatis.xml");
			BlogBiz ub=(BlogBiz) ac.getBean("blogBizImpl");
			System.out.println("当前转发数"+ub.relay(1L, 3));
		}
}
