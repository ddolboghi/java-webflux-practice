package com.study.mongodb.repository;

import com.study.mongodb.domain.Chat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {

    @Tailable
    @Query("{'sender':  ?0, 'receiver':  ?1}")
    Flux<Chat> findChatBySenderAndReceiver(String sender, String receiver);
}
