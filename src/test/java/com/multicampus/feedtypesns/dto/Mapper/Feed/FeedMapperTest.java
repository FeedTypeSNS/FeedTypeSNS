package com.multicampus.feedtypesns.dto.Mapper.Feed;

import com.multicampus.feedtypesns.domain.Feed.Feed;
import com.multicampus.feedtypesns.domain.Users.Users;
import com.multicampus.feedtypesns.dto.Feed.FeedDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Log4j2
public class FeedMapperTest {

    @Test
    public void toDtoTest(){
        Users user = Users.builder()
                .id(1)
                .name("areum")
                .build();

        Feed feed = Feed.builder()
                .id(1)
                .users(user)
                .groupId(0)
                .title("dtoTest")
                .content("dtoTestContents")
                .range(0)
                .totalView(12)
                .build();
        log.info(feed);

        FeedDto feedDto = FeedMapper.INSTANCE.toDto(feed);
        log.info(feedDto);
    }

    @Test
    public void toDtoListTest(){
        Users user = Users.builder()
                .id(1)
                .name("areum")
                .build();

        Feed feed1 = Feed.builder()
                .id(1)
                .users(user)
                .groupId(0)
                .title("dtoTest1")
                .content("dtoTestContents1")
                .range(0)
                .totalView(12)
                .build();
        log.info(feed1);

        Feed feed2 = Feed.builder()
                .id(2)
                .users(user)
                .groupId(1)
                .title("dtoTest2")
                .content("dtoTestContents2")
                .range(0)
                .totalView(12)
                .build();
        log.info(feed2);

        List<Feed> feedList = new ArrayList<>();
        feedList.add(feed1);
        feedList.add(feed2);

        List<FeedDto> feedDtoList = FeedMapper.INSTANCE.toDtoList(feedList);
        log.info(feedDtoList);
    }
}
