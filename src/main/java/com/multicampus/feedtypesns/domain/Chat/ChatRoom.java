package com.multicampus.feedtypesns.domain.Chat;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //채팅방 번호

    @Column
    private String name; //채팅방 이름 -> 추후에 이름 설정 바꿀 수 있음 좋음


}

/* 다대다 연결 관계를 없애기 위해서 아래와 같이 설정
 메시지 - 채팅방 정보 - 채팅방에 참가한 사람들 정보
 chat  - chatRoom  - JoinRoom

*/

