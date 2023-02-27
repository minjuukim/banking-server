package com.numble.banking.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class UserFriendInfo {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(optional = false)     // 반드시 존재하는 값이 된다(user를 null을 허용하지 않음)
    private User user;

    private int friendCount;

//    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}
