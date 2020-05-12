package com.pedrobassetto.workshopmongo.services;

import com.pedrobassetto.workshopmongo.domain.Post;
import com.pedrobassetto.workshopmongo.domain.User;
import com.pedrobassetto.workshopmongo.repository.PostRepository;
import com.pedrobassetto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}