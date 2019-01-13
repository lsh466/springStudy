package testPjt;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
//		TranspotationWalk transpotation = new TranspotationWalk();
//		transpotation.move();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TranspotationWalk tw = ctx.getBean("tWalk", TranspotationWalk.class);
		tw.move();
		
		ctx.close();
		
	}
}
