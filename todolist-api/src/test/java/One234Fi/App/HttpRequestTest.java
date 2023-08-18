package One234Fi.App;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import One234Fi.App.Item.Item;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getReturnsEmptyIterable() throws Exception {
        ResponseEntity<List<Item>> responseEntity = restTemplate.exchange(
                "/items" , HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Item>>() {});
        List<Item> list = responseEntity.getBody();
        Assert.assertEquals(list.size(), 0);
    }
}
