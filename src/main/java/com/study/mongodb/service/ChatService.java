package com.study.mongodb.service;

import com.study.mongodb.domain.Chat;
import com.study.mongodb.vo.ChatVo;
import reactor.core.publisher.Flux;

public interface ChatService {

    void sendChat(ChatVo chatVo);
    Flux<Chat> getChat(String sender, String receiver);
}
