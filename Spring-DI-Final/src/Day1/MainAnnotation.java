package Day1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAnnotation {

	public static void main(String[] args) {
		ApplicationContext appCtxt = new AnnotationConfigApplicationContext(AppConfig.class);
		ApplicationContext newappCtxt = new AnnotationConfigApplicationContext(AppConfig.class);
		//Spring container holds all the beans together
		
		//Bata b = appCtxt.getBean(Bata.class);
		Bata b = (Bata) appCtxt.getBean("bata1");
		
		//Same because this is singleton
		Bata b2 = appCtxt.getBean("bata2", Bata.class);
		Bata b3 = appCtxt.getBean("bata2", Bata.class);
		
		b.makeShoeLookGood();
		
		if (b2 == b3){
			System.out.println("They are same");
		}
		
		//Not same because this is prototype
		Puma p1 = appCtxt.getBean("puma1",Puma.class);
		Puma p2 = appCtxt.getBean("puma1",Puma.class);
		
		if (p1 != p2){
			System.out.println("They are not same puma objets");
		}

	}

}
