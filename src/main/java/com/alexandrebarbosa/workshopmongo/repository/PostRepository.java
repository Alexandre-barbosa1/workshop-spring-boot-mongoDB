package com.alexandrebarbosa.workshopmongo.repository;

import com.alexandrebarbosa.workshopmongo.domain.Post;
import com.alexandrebarbosa.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{'title': {$regex: ?0,$options: 'i'} }")
    List <Post> searchTitle(String title);

    List<Post> findByTitleContainingIgnoreCase (String text);
}
