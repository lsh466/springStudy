package test05Pjt001;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
			
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		TranspotationWalk tw = ctx.getBean("tWalk", TranspotationWalk.class);
		tw.move();
		ctx.close();
	}
}
