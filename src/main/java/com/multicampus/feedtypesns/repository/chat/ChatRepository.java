package com.multicampus.feedtypesns.repository.chat;

import com.multicampus.feedtypesns.domain.Chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}
