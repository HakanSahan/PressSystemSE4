package be.springPressOrder.dao;

import be.springPressOrder.domain.Entry;
import be.springPressOrder.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Long> {

    /**
     * The default findById would return Optional<Entry>
     * We want a Entry object as return
     * therefore we override this method
     * @param id
     * @return
     */
    public Entry findById(long id);

    /**
     * @return The entry with the largest id = the most recently added entry for a given user
     */
    public Entry findFirstByUserOrderByIdDesc(User user);

}
