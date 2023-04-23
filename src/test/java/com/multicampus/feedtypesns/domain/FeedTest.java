package com.multicampus.feedtypesns.domain;

import com.multicampus.feedtypesns.domain.Feed.Feed;
import com.multicampus.feedtypesns.domain.Users.Users;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class FeedTest {
    @Test
    public void feedBuild(){
        Users user = new Users(1, "areum");
        Feed feed = Feed.builder()
                .users(user)
                .groupId(0)
                .title("test")
                .content("Feed building test")
                .build();
        log.info(feed);
    }
}
