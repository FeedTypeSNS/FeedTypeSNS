package com.multicampus.feedtypesns.domain.Chat;

import com.multicampus.feedtypesns.domain.Users.Users;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor//(access = AccessLevel.PROTECTED)
@ToString
public class JoinRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //기본 인덱스 추가 (편하게 할려고 무의미..)

    @ManyToOne
    @JoinColumn(name = "join_room_id")
    private ChatRoom room; //참여된 채팅방 -> 어디 채팅방?

    @ManyToOne
    @JoinColumn(name = "join_users_id")
    private Users users; //방에 참가한 사람

}
