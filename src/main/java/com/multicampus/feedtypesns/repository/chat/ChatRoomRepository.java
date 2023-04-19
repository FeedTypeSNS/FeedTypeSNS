package com.multicampus.feedtypesns.repository.chat;

import com.multicampus.feedtypesns.domain.Chat.ChatReadCheck;
import com.multicampus.feedtypesns.domain.Chat.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
