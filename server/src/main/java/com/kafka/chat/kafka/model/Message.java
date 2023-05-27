package com.kafka.chat.kafka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter
@ToString
@NoArgsConstructor
public class Message implements Serializable {
    private String sender;
    private String content;
    private String timestamp;
}
