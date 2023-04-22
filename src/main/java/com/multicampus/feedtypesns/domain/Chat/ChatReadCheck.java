package com.multicampus.feedtypesns.domain.Chat;

import com.multicampus.feedtypesns.domain.Users.Users;
import lombok.*;
import org.hibernate.mapping.ToOne;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatReadCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //구별을 위한 id

    @ManyToOne
    @JoinColumn(name = "chat_read_user")
    private Users readUser; //채팅을 읽은 사람, 한 사람은 여러개의 채팅확인 가능

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;      //채팅(메시지), 하나의 메시지는 여러개의 채팅확인 가능

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "read_date", updatable = false)
    @CreatedDate
    private LocalDateTime readDate;  //메시지 읽은 시간

}
//채팅을 읽은 사람, 시간 체크하는 테이블