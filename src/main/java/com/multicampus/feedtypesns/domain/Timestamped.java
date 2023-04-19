package com.multicampus.feedtypesns.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //상속받아서 속성값만 가져다 쓰고 싶을때 설정하는 어노테이션
@EntityListeners(AuditingEntityListener.class)
public class Timestamped {
    @CreatedDate
    @Column(name = "regdate", updatable = false)//DB의 업데이트가 일어날때 변화시킬거? (처음작성시기니 false)
    private LocalDateTime regDate;
    //등록시간

    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;
    //수정시간
}
