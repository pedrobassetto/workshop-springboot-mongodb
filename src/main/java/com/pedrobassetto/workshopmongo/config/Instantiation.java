package com.pedrobassetto.workshopmongo.config;

import com.pedrobassetto.workshopmongo.domain.Post;
import com.pedrobassetto.workshopmongo.domain.User;
import com.pedrobassetto.workshopmongo.dto.AuthorDTO;
import com.pedrobassetto.workshopmongo.dto.CommentDTO;
import com.pedrobassetto.workshopmongo.repository.PostRepository;
import com.pedrobassetto.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2019"), "Partiu Viagem", "Vou viajar ...", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("16/03/2020"), "Bom dia", "Acordei feliz ...", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem Mano", sdf.parse("21/03/2020"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("23/03/2020"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um otimo dia", sdf.parse("27/03/2020"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

    }
}
