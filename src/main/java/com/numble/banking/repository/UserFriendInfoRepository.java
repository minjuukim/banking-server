package com.numble.banking.repository;

import com.numble.banking.domain.UserFriendInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFriendInfoRepository extends JpaRepository<UserFriendInfo, Long> {

}
