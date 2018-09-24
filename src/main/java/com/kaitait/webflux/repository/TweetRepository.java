package com.kaitait.webflux.repository;

import com.kaitait.webflux.domain.Tweet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends ReactiveMongoRepository<Tweet, String> {

}