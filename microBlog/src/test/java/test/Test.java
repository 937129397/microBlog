package test;
import java.util.Date;

import junit.framework.TestCase;

public class Test extends TestCase {
	
	public void test1(){
		Date d = new Date();
		System.out.println(  d.getTime() );
	}
}
