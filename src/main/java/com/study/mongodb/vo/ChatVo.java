package com.study.mongodb.vo;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ChatVo {
    private String msg;
    private String sender;
    private String receiver;
}
