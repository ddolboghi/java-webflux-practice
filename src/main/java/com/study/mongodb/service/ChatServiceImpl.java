package com.study.mongodb.service;

import com.study.mongodb.domain.Chat;
import com.study.mongodb.repository.ChatRepository;
import com.study.mongodb.vo.ChatVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;

    @Override
    public void sendChat(ChatVo chatVo) {
        chatRepository.save(
                Chat.builder()
                        .msg(chatVo.getMsg())
                        .sender(chatVo.getSender())
                        .receiver(chatVo.getReceiver())
                        .createdAt(LocalDateTime.now())
                        .build()
        ).subscribe();
    }

    @Override
    public Flux<Chat> getChat(String sender, String receiver) {
        return chatRepository.findChatBySenderAndReceiver(sender, receiver);
    }
}
