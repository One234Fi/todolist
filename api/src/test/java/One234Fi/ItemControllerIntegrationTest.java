package One234Fi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import One234Fi.Entities.Item;
import One234Fi.Repositories.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = App.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ItemControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ItemRepository repository;

    @Test
    public void testGetItems() throws Exception {
        Item testItem = new Item();
        testItem.setTitle("testTitle");
        testItem.setBody("testBody");

    }

}
