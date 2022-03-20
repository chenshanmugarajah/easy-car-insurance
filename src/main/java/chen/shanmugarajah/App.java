package chen.shanmugarajah;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws InterruptedException, IOException
    {
    	
//    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//    	
//    	Scraper argos = (Scraper) context.getBean("Argos");
//    	
//    	argos.getData();
    	
    	InsuranceScraper test = new InsuranceScraper();
    	
    	String numberPlate = "ey09hfj";
    	Boolean modified = false;
    	Boolean owner = true;
    	Boolean keeper = true;
    	test.getData(numberPlate, modified, owner, keeper);
    	
    }
}
