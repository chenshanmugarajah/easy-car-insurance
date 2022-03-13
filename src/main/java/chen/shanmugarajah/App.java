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
    public static void main( String[] args ) throws IOException
    {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
    	Scraper argos = (Scraper) context.getBean("Argos");
    	
    	argos.getData();
    	
    }
}
