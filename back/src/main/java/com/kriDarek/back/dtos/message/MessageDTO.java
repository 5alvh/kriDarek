package com.kriDarek.back.dtos.message;


import com.kriDarek.back.dtos.user.UserDTO;
import com.kriDarek.back.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private Long id;
    private Long conversationId;
    private UserDTO sender;
    private UserDTO receiver;
    private String content;
    private MessageType type;
    private Boolean isRead;
    private LocalDateTime sentAt;
    private LocalDateTime readAt;
}