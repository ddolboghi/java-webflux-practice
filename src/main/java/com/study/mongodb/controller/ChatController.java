package com.study.mongodb.controller;

import com.study.mongodb.domain.Chat;
import com.study.mongodb.repository.ChatRepository;
import com.study.mongodb.service.ChatService;
import com.study.mongodb.vo.ChatVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    @GetMapping(value = "/sender/{sender}/receiver/{receiver}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    Mono<Chat>을 리턴하면 Chat으로 한번만 리턴
    public Flux<Chat> getChat(
            @PathVariable(value = "sender") String sender,
            @PathVariable(value = "receiver") String receiver) {
        return chatService.getChat(sender, receiver).subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public void saveChat(@RequestBody ChatVo chatVo) {
        chatService.sendChat(chatVo);
    }
}
