package com.multicampus.feedtypesns.repository.chat;

import com.multicampus.feedtypesns.domain.Chat.ChatReadCheck;
import com.multicampus.feedtypesns.domain.Chat.JoinRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinRoomRepository extends JpaRepository<JoinRoom, Long> {
}
