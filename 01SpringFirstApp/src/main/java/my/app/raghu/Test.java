package my.app.raghu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//ctrl+shift+O

public class Test {
	// main   ctrl+space   enter
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		OracleCon con = (OracleCon) ac.getBean("con");
		System.out.println(con);
	}
}
