package One234Fi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import One234Fi.Entities.Item;
import One234Fi.Repositories.ItemRepository;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("")
    public @ResponseBody Iterable<Item> getItems() {
        return itemRepository.findAll();
    }

    @GetMapping("")
    public @ResponseBody Item getItem(@RequestParam Integer id) { 
        Item item = itemRepository.findById(id).orElse(null);
        return item; 
    }

    @PostMapping("")
    public @ResponseBody String post(@RequestParam String title, @RequestParam String body) { 
        Item newItem = new Item();
        newItem.setTitle(title);
        newItem.setBody(body);
        itemRepository.save(newItem);
        return "posted an item!\n"; 
    }

    @PutMapping("")
    public @ResponseBody String putItem(@RequestParam Integer id, @RequestParam Item item) {
        Item itemToChange = itemRepository.findById(id).get();
        if (item.getBody() != null) {
            itemToChange.setBody(item.getBody());
        }
        if (item.getTitle() != null) {
            itemToChange.setTitle(item.getTitle());
        }
        itemRepository.save(itemToChange);

        return "updated an item!\n"; 
    }

    @DeleteMapping("")
    public String deleteItem(@RequestParam Integer id) { 
        itemRepository.deleteById(id);

        return "deleted an item!"; 
    }
}
