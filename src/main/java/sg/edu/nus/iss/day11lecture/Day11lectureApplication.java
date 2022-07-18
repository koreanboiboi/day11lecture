package sg.edu.nus.iss.day11lecture;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class Day11lectureApplication {

	@Bean
	public CommonsRequestLoggingFilter log(){
		CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
		logger.setIncludeClientInfo(true);
		logger.setIncludeQueryString(true);
		return logger;
	}

	public static void main(String[] args) {
		//SpringApplication.run(Day11lectureApplication.class, args);
		SpringApplication app = new SpringApplication(Day11lectureApplication.class);
		
		String port = "8080";
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);
		
		if (cliOpts.containsOption("port")){
			port = cliOpts.getOptionValues("port").get(0);
		}
		
		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		
		
		app.run(args);

		System.out.printf("\nApplication started on port %s\n",port);
	}

	

}
