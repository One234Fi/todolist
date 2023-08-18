package One234Fi.App.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.Test;

@AutoConfigureMockMvc
@SpringBootTest
public class ItemControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void addItemTest() throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
        Item item = new Item();

        mvc.perform(
                post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objMapper.writeValueAsString(item)))
            .andExpect(status().isOk());
    }

    @Test
    public void getAllItemsTest() throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
        Item item = new Item();
        Item item2 = new Item();

        mvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(item)));
        mvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(item2)));
        mvc.perform(get("/items").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getItemTest() throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
        Item item = new Item();
        item.setId(7);

        mvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(item)));
        mvc.perform(get("/items/7").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void deleteItemTest() throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
        Item item = new Item();
        item.setId(5);

        mvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(item)));
        mvc.perform(delete("/items/5").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void putItemTest() throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
        Item item = new Item();
        item.setId(6);

        mvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(item)));
        item.setTitle("new title");
        mvc.perform(put("/items/6").contentType(MediaType.APPLICATION_JSON).content(objMapper.writeValueAsString(item))).andExpect(status().isOk());
    }
}
