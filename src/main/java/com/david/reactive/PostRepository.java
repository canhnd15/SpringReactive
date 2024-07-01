package com.david.reactive;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PostRepository extends ReactiveCrudRepository<Post, Long> {
    @Query(
            value = "SELECT * FROM posts WHERE LOWER(title) LIKE LOWER(CONCAT('%', :title , '%'))"
    )
    Flux<Post> findAllByTitle(@Param("title") String title);
}
