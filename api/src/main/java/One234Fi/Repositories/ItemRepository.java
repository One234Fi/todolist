package One234Fi.Repositories;

import org.springframework.data.repository.CrudRepository;

import One234Fi.Entities.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
