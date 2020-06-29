package cst438week1hw.cst438week1hw;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Long> {
    @Query("select m from Post m order by title, date desc")
    List<Post> findAllPostingsOrderByTitleDateDesc();
}

