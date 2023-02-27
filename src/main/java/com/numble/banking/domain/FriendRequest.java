package com.numble.banking.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table
public class FriendRequest {
    @Id
    @GeneratedValue
    private Long id;

    private Long requestId;     // 친구 신청자 아이디

    private Long requestedId;   // 요청받은 사람 아이디

    private int relationship;   // 0이면 요청중, 1이면 친구완료
}
