package One234Fi.App.Client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

/**
 * Client class provides methods to target the item api
 */

@Component
public class Client {
    private final WebClient client;

    public Client(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }

    public Mono<Item> get(int id) {
        return this.client.get().uri("/items/" + id).accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Item.class);
    }
    
    public Mono<Item[]> get() {
        return this.client.get().uri("/items").accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Item[].class).log();

        //Object[] obs = response.block();

        //ObjectMapper mapper = new ObjectMapper();
        //return Arrays.stream(obs)
        //    .map(object -> mapper.convertValue(object, Item.class))
        //    .collect(Collectors.toList());
    }

    public Mono<Void> post(Item item) {
       // Mono<Item> itemToPost = Mono.just(item);
            
        return this.client.post().uri("/items")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(item)
            .retrieve()
            .bodyToMono(Void.class);
    }

    public Mono<Void> put(int id, Item item) {
        return this.client.put().uri("/items/{id}", id)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(item)
            .retrieve()
            .bodyToMono(Void.class);
    }

    public Mono<Void> delete(int id) {
        return this.client.delete().uri("/items/{id}", id)
            .retrieve()
            .bodyToMono(Void.class);
    }

}
