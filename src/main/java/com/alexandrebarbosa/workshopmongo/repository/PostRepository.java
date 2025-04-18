package com.alexandrebarbosa.workshopmongo.repository;

import com.alexandrebarbosa.workshopmongo.domain.Post;
import com.alexandrebarbosa.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
