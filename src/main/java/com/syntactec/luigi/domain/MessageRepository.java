package com.syntactec.luigi.domain;

import org.springframework.data.geo.Box;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByLocationWithin(Box box);
}
