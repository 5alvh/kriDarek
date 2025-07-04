package com.kriDarek.back.dtos.conversation;


import com.kriDarek.back.dtos.message.MessageDTO;
import com.kriDarek.back.dtos.property.PropertyGetDTO;
import com.kriDarek.back.dtos.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversationDTO {
    private Long id;
    private UserDTO otherUser;
    private PropertyGetDTO property;
    private MessageDTO lastMessage;
    private Integer unreadCount;
    private LocalDateTime lastMessageAt;
}