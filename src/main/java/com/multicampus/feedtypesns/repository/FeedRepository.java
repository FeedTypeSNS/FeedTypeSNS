package com.multicampus.feedtypesns.repository;

import com.multicampus.feedtypesns.domain.Feed.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
