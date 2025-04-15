package com.alexandrebarbosa.workshopmongo.services;

import com.alexandrebarbosa.workshopmongo.domain.User;
import com.alexandrebarbosa.workshopmongo.dto.UserDTO;
import com.alexandrebarbosa.workshopmongo.repository.UserRepository;
import com.alexandrebarbosa.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository rep;

    public List<User> findAll() {
       return rep.findAll();
    }

    public User findById(String id) throws ObjectNotFoundException {
        Optional<User> obj = rep.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert (User obj) {
        return rep.insert(obj);
    }
    public void delete (String id) {
        findById(id);
        rep.deleteById(id);
    }

    public User fromDTO (UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());

    }

}
