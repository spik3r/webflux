package com.kaitait.webflux.repository;

import com.kaitait.webflux.domain.Food;
import com.kaitait.webflux.domain.Tweet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends ReactiveMongoRepository<Food, String> {

}