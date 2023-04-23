package com.multicampus.feedtypesns.dto.Mapper.Feed;

import com.multicampus.feedtypesns.domain.Feed.Feed;
import com.multicampus.feedtypesns.dto.Feed.FeedDto;
import com.multicampus.feedtypesns.dto.Mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FeedMapper extends GenericMapper<Feed, FeedDto> {
    FeedMapper INSTANCE = Mappers.getMapper(FeedMapper.class);

    @Mapping(source="users.id", target="userId")
    FeedDto toDto(Feed feed);

    List<FeedDto> toDtoList(List<Feed> feedList);
}
