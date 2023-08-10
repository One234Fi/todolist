package One234Fi;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Component
public class Client {
    private final WebClient client;

    public Client(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }

    public Item get(int id) {
        return this.client.get().uri("/items/" + id).accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Item.class).block();
    }
    
    public List<Item> get() {
            Mono <Object[]> response = this.client.get().uri("/items").accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Object[].class).log();

            Object[] obs = response.block();

            ObjectMapper mapper = new ObjectMapper();
            return Arrays.stream(obs)
                .map(object -> mapper.convertValue(object, Item.class))
                .collect(Collectors.toList());
    }

    public void post() {

    }

    public void put(int id) {

    }

    public void delete(int id) {

    }

}
