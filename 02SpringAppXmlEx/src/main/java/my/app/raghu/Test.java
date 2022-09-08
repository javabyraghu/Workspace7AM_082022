package my.app.raghu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	//ctrl + F11 // ctrl+ Fn + F11
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ViewResolver vr = (ViewResolver) ac.getBean("vobj");
		System.out.println(vr);
	}
}
