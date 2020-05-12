package com.pedrobassetto.workshopmongo.repository;

import com.pedrobassetto.workshopmongo.domain.Post;
import com.pedrobassetto.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
