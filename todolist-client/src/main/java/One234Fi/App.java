package One234Fi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Client main class
 *
 */
@SpringBootApplication
public class App {

    public static void main( String[] args ) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        Client client = context.getBean(Client.class);    

        System.out.println("TODO:\n");
        List<Item> results = client.get();
        for (Item i : results) {
            System.out.println(i.toString());
        }
    }
}
