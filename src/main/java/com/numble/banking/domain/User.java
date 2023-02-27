package com.numble.banking.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;       // 유저계정아이디

    @Column(length = 16, nullable = false)
    private String password;    // 비밀번호

    @Column(nullable = false)
    private String name;        // 유저이름

    private int age;

//    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private int phoneNum;

    @OneToOne(mappedBy = "user")
    @ToString.Exclude
    private UserFriendInfo userFriendInfo;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")     // 어떤 컬럼으로 조인할지 지정
    @OneToMany(mappedBy = "user")
    @ToString.Exclude   // StackOverFlow 제거
    private List<Friend> friends = new ArrayList<>();   // NullPointException이 발생하지 않도록 ArrayList로 기본 리스트를 생성.
}
