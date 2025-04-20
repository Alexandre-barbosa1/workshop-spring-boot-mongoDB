package com.alexandrebarbosa.workshopmongo.services;

import com.alexandrebarbosa.workshopmongo.domain.Post;
import com.alexandrebarbosa.workshopmongo.domain.User;
import com.alexandrebarbosa.workshopmongo.dto.UserDTO;
import com.alexandrebarbosa.workshopmongo.repository.PostRepository;
import com.alexandrebarbosa.workshopmongo.repository.UserRepository;
import com.alexandrebarbosa.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServices {
    @Autowired
    private PostRepository rep;



    public Post findById(String id) throws ObjectNotFoundException {
        Optional<Post> obj = rep.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

    }

    public List<Post> findByTitle(String title) {
        return rep.findByTitleContainingIgnoreCase(title);
    }



}
