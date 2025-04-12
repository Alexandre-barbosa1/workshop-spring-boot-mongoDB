package com.alexandrebarbosa.workshopmongo.repository;

import com.alexandrebarbosa.workshopmongo.domain.User;
import com.alexandrebarbosa.workshopmongo.dto.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
