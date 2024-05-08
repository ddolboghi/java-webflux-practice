package com.study.mongodb.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document(collection = "massage")
public class Chat {
    @Id
    private String id;
    private String msg;
    private String sender;
    private String receiver;
    private LocalDateTime createdAt;

    @Builder
    public Chat(String id, String msg, String sender, String receiver, LocalDateTime createdAt) {
        this.msg = msg;
        this.sender = sender;
        this.receiver = receiver;
        this.createdAt = createdAt;
    }
}
