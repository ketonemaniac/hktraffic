package net.ketone.hktraffic;

import net.ketone.hktraffic.feed.TrafficFeed;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * TODO: parse https://feed43.com/5612585486683673.xml using JSOUP
 * TODO: save to H2 DB
 *
 */
@SpringBootApplication
@EnableScheduling
public class HkTrafficApplication {

	Logger log = Logger.getLogger(HkTrafficApplication.class);

	@Autowired
	private TrafficFeed feed;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(HkTrafficApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
