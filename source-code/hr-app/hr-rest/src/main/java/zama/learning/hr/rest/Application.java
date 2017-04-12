package zama.learning.hr.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Zama
 * @description REST API for Custom Data Pipeline
 */
@SpringBootApplication
@ComponentScan("zama.learning.hr.rest")
public class Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
}
