package test;


import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.microblog.bean.Blog;
import com.microblog.bean.BlogModel;
import com.microblog.bean.User;
import com.microblog.biz.BlogBiz;
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
	
	public void testApp08() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		BlogBiz ub=(BlogBiz) ac.getBean("blogBizImpl");
		BlogModel b=new BlogModel();
		System.out.println(ub.findAllBlog(b));

	}
}
