package One234Fi.App;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import One234Fi.App.Item.Item;

@RunWith(SpringRunner.class)
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
