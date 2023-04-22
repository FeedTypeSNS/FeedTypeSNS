package com.multicampus.feedtypesns.repository.chat;

import com.multicampus.feedtypesns.domain.Chat.ChatReadCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatReadCheckRepository extends JpaRepository<ChatReadCheck, Long> {
}
