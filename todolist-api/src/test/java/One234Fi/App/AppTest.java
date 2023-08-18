package One234Fi.App;


import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import One234Fi.App.Item.ItemController;

@SpringBootTest
public class AppTest {
    @Autowired
    private ItemController controller;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(controller);
    }
}
