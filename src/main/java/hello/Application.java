package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Line[]> quote = restTemplate.getForEntity("https://api.tfl.gov.uk/Line/Mode/tube?app_id=74b06869&app_key=1eaef4eae3f78819c146cc9d88d87eff", Line[].class);
        Line[] lines = quote.getBody();

        for (Line line : lines) {
            log.info(line.getID());
        }

    }
}