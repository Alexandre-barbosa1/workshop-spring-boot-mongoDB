package com.alexandrebarbosa.workshopmongo.config;

import com.alexandrebarbosa.workshopmongo.domain.Post;
import com.alexandrebarbosa.workshopmongo.domain.User;
import com.alexandrebarbosa.workshopmongo.dto.AuthorDTO;
import com.alexandrebarbosa.workshopmongo.dto.CommentDTO;
import com.alexandrebarbosa.workshopmongo.repository.PostRepository;
import com.alexandrebarbosa.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {


    @Autowired
    private UserRepository rep;

    @Autowired
    private PostRepository repPost;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        rep.deleteAll();
        repPost.deleteAll();


        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        rep.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(sdf.parse("21/03/2018"),null,"Partiu viagem","vou viajar para São Paulo",new AuthorDTO(maria));
        Post post2 = new Post (sdf.parse("23/03/2018"),null,"bom dia!","Acordei feliz hoje",new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));


        repPost.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().add(post1);
        maria.getPosts().add((post2));
        userRepository.save(maria);
    }
}
