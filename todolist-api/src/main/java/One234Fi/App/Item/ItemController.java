package One234Fi.App.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    public ItemRepository getRepo() {
        return itemRepository;
    }

    @GetMapping(value = "")
    public ResponseEntity<Iterable<Item>> get() {
        // /items
        return new ResponseEntity<Iterable<Item>>(itemRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Item> get(@PathVariable(value = "id") int id) { 
        // /items/#
        Item item = itemRepository.findById(Integer.valueOf(id)).orElse(null);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> post(@RequestBody Item item) {
        itemRepository.save(item);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable int id, @RequestBody Item item) {
        Item itemToChange = itemRepository.findById(id).get();
        if (item.getTitle() != null) {
            itemToChange.setTitle(item.getTitle());
        }
        if (item.getBody() != null) {
            itemToChange.setBody(item.getBody());
        }
        itemRepository.save(itemToChange);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) { 
        // items/#
        itemRepository.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
