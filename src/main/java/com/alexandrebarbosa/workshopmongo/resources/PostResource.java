package com.alexandrebarbosa.workshopmongo.resources;

import com.alexandrebarbosa.workshopmongo.domain.Post;
import com.alexandrebarbosa.workshopmongo.domain.User;
import com.alexandrebarbosa.workshopmongo.dto.UserDTO;
import com.alexandrebarbosa.workshopmongo.resources.util.URL;
import com.alexandrebarbosa.workshopmongo.services.PostServices;
import com.alexandrebarbosa.workshopmongo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostServices service;
    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(value = "/titlesearch", method = GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text",defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
