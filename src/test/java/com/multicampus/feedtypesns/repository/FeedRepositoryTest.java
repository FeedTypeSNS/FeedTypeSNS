package com.multicampus.feedtypesns.repository;

import com.multicampus.feedtypesns.domain.Feed.Feed;
import com.multicampus.feedtypesns.domain.Users.Users;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class FeedRepositoryTest {
    @Autowired
    private FeedRepository feedRepository;

    @Test
    public void saveTest(){
        Users user = new Users(1, "areum");
        Feed feed = Feed.builder()
                .users(user)
                .groupId(0)
                .title("test")
                .content("Feed building test")
                .build();
        feedRepository.save(feed);
    }

    @Test
    public void modifyTest(){
        Feed feed = feedRepository.findById(581L).orElseThrow(()->{
            return new IllegalArgumentException("해당하는 피드가 없습니다");
        });
        Feed modifiedFeed = Feed.builder()
                .groupId(1)
                .title("test")
                .content("Feed modify test")
                .build();
        feed.change(modifiedFeed.getTitle(),modifiedFeed.getContent(),modifiedFeed.getGroupId(),modifiedFeed.getRange());
        feedRepository.save(feed);
    }

    @Test
    public void deleteTest(){
        feedRepository.deleteById(580L);
    }
}
