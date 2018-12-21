package mc.tuto.jdk8news;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.apache.log4j.Logger;

public class Jdk8Tests {
	private static Logger logger = Logger.getLogger(Jdk8Tests.class);
	private static String[] data = new String[] {"Html5","Css3","Javascript","Php"};

	public static void foreachTests() {		
		List<String> items = Arrays.asList(data);

		logger.info("****************************************************");
		logger.info("Items "+Arrays.toString(data)+" forEach");

		//		items.forEach(new Consumer<String>() {
		//			//classe anonyme
		//			@Override
		//			public void accept(String item) {
		//				logger.info("=>"+item);				
		//			}		
		//		});	
		
		Consumer action = new McConsumer<String>(logger); // implementation de Consumer (Interface Fonctionnelle)
		items.forEach(action);
	
		logger.info("****************************************************");
	}

		
}
class McConsumer<T> implements Consumer<T>{
	private Logger logger;
	
	public McConsumer(Logger logger) {
		this.logger=logger;
	}
	@Override
	public void accept(T item) {
		logger.info("=>"+item);
	}
}
