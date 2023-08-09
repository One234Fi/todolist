package One234Fi.Controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import One234Fi.Entities.Item;

public class ItemControllerTest {
    /*
    @Autowired
    private static ItemController controller;

    @BeforeClass
    public static void deleteAllClearsRepo() {
        controller.getRepo().deleteAll();
        long dataAmt = StreamSupport.stream(controller.getRepo().findAll().spliterator(), false).count();

        assertEquals(dataAmt, 0);
    }

    @After
    public void clearRepo() {
        controller.getRepo().deleteAll();
    }

    @Test
    public void postDoesItsThing() {
        Item item = new Item();
        item.setTitle("testItem");
        item.setBody("this is a body");

        controller.post(item.getTitle(), item.getBody());

        var data = controller.get().iterator().next();

        assertEquals(data, item);
    }

    @Test
    public void getItemsReturnsItems() {
        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setTitle("title " + i);
            item.setBody("body " + i);
            controller.post(item.getTitle(), item.getBody());
        }

        Iterator<Item> data = controller.get().iterator();
        
        for (int i = 0; i < 10; i++) {
            var item = data.next();
            assertEquals(item.getTitle(), "title " + i);
            assertEquals(item.getBody(), "body " + i);
        }
    }

    @Test
    public void getReturnsSpecificItem() {
        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setTitle("title " + i);
            item.setBody("body " + i);
            controller.post(item.getTitle(), item.getBody());
        }

        Integer j = Integer.valueOf(((int) Math.random() * 10));
        Item item3 = controller.get(j);
        
        assertEquals("title " + j, item3.getTitle());
        assertEquals("body " + j, item3.getBody());
    }

    @Test
    public void deleteRemovesSpecificItems() {
        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setTitle("title " + i);
            item.setBody("body " + i);
            controller.post(item.getTitle(), item.getBody());
        }

        Integer j = Integer.valueOf(((int) Math.random() * 10));
        controller.delete(j);

        assertNull(controller.get(j));
    }

    @Test
    public void putUpdatesItems() {
        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setTitle("title " + i);
            item.setBody("body " + i);
            controller.post(item.getTitle(), item.getBody());
        }

        Integer j = Integer.valueOf(((int) Math.random() * 10));
        Integer j2 = Integer.valueOf(((int) Math.random() * 10));
        while (j2 != j) {
            j2 = Integer.valueOf(((int) Math.random() * 10));
        }
        Integer j3 = Integer.valueOf(((int) Math.random() * 10));
        while (j3 != j && j3 != j2) {
            j3 = Integer.valueOf(((int) Math.random() * 10));
        }

        Item new1 = new Item();
        new1.setTitle("update title 1");
        new1.setBody("update body 1");

        Item new2 = new Item();
        new2.setTitle("update title 2");

        Item new3 = new Item();
        new3.setBody("update body 3");

//TODO: fix this 
        //controller.put(j, new1.getTitle(), new1.getBody());
       // controller.put(j2, new2.getTitle(), new2.getBody());
        //controller.put(j3, new3.getTitle(), new3.getBody());

        Item res1 = controller.get(j);
        Item res2 = controller.get(j2);
        Item res3 = controller.get(j3);

        assertEquals(res1.getTitle(), "update title 1");
        assertEquals(res1.getBody(), "update body 1");
        assertEquals(res2.getTitle(), "update title 2");
        assertEquals(res2.getBody(), "body " + j2);
        assertEquals(res3.getTitle(), "title " + j3);
        assertEquals(res3.getTitle(), "update body 3");
    }
    */

}
