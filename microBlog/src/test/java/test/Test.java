package test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import com.microblog.bean.Blog;
import com.microblog.biz.BlogBiz;

import junit.framework.TestCase;

public class Test extends TestCase {

	
	
	public void testApp07() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		BlogBiz ub=(BlogBiz) ac.getBean("blogBizImpl");
		Blog blog=new Blog();
		blog.setUid("1");
		blog.setText("你好");
		blog.setSource(1);
		blog.setPic("图片");
		ub.saveBlog(blog);
	}
}
