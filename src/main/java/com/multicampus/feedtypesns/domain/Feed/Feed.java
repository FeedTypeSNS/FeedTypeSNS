package com.multicampus.feedtypesns.domain.Feed;

import com.multicampus.feedtypesns.domain.Users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Builder
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

//    Group_id는 selectbox에서 선택하는 값으로 group을 저장하려면 다시 조회해서 들고와야해서 일단 id만 저장
//    @OneToOne
//    @JoinColumn(name="group_id")
//    private Group group;
    @Column(nullable = false, name="group_id")
    private long groupId;

    @NotEmpty
    @Column(nullable = false, length = 100, name="title")
    private String title;

    @NotEmpty
    @Column(nullable = false, name="content")
    private String content;

    @Column(nullable = false, name="open_range") //전체 0 부분공개 1
    private int range;

    @Column(name="reg_date")
    @CreatedDate
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name="mod_date")
    private LocalDateTime modDate;

    @Column(name="total_view")
    private long totalView;

//    @OneToMany(mappedBy = "feed_id")
//    private List<FeedLike> feedLike;

//    @OneToMany(mappedBy = "feed")
//    private List<Comment> comment;

    public void change(String title, String content, long groupId, int range){
        this.setTitle(title);
        this.setContent(content);
        this.setGroupId(groupId);
        this.setRange(range);
    }
}
