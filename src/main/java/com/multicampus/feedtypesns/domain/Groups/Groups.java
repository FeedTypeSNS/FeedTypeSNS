package com.multicampus.feedtypesns.domain.Groups;

import com.multicampus.feedtypesns.domain.Users.Users;
import lombok.*;

import javax.persistence.*;

@Entity(name = "groups_g")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor//(access = AccessLevel.PROTECTED)
@ToString
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @Column(name = "group_name", length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private int open; //그룹 : 공개 1, 비공개 0


    @Column(name = "group_pw")
    private String password;

    @Column(name = "group_profile_url")
    private String profileUrl;

    @Column(name = "group_desc")
    private String desc;

    @JoinColumn(name = "group_master_id", nullable = false)
    @ManyToOne
    private Users user;
}
