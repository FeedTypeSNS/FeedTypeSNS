package com.multicampus.feedtypesns.dto.Feed;

import com.multicampus.feedtypesns.domain.Users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeedDto{
    private long id;
    private long userId;
    private long groupId;
    private String title;
    private String content;
    private int range;
    private LocalDateTime modDate;
    private LocalDateTime regDate;
    private long totalView;
}
