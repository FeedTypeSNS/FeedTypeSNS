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
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //채팅 순서 = 메시지 순서

    @OneToOne //기본 fetchtype eger -> 메시지 보내줄때마다 필요
    @JoinColumn(name = "room_id")
    private ChatRoom room;

    @JoinColumn(name = "send_user_id")
    @ManyToOne(fetch = FetchType.LAZY) //회원 정보를 늘 가져올 필요 없음
    private Users sender; //채팅 보내는 사람
    //사용자 한명이 편지를 여러개 쓸 수 있음,
    // chat(메시지) 기준으로 사용자는 한명이고, 자신이 여러개니 ManyToOne
    // 생각해볼 부분.. 만약 회원이 탈퇴를 한다면 메세기 모두 삭제 시키면 (onDelte 설정)
    // 아니면, 그냥 회원이 null 일 경우 이름 없음 이런식으로..?

    @Column(name = "content")
    private String content; //메세지 내용 -> 이미지도 포함할 수 있나? 이게 문제..

    @Column(nullable = false)
    private int read_count;   //메세지 안 읽은 메시지 수 -> 안읽음 채팅방 참가 인원 수-1 , 읽음 0


    public void checkRead(){



    } //메시지를 읽었는지 확인 부분 -> 서비스 부분에 만들어야 할듯
}
