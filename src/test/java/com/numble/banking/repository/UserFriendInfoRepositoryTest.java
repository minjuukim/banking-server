package com.numble.banking.repository;

import com.numble.banking.domain.User;
import com.numble.banking.domain.UserFriendInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserFriendInfoRepositoryTest {
    @Autowired
    private UserFriendInfoRepository userFriendInfoRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void crudTest() {
        UserFriendInfo userFriendInfo = new UserFriendInfo();   // 엔티티 생성
//        userFriendInfo.setUserIdx(1L);
        userFriendInfo.setFriendCount(2);

        userFriendInfoRepository.save(userFriendInfo);

        System.out.println(">>> " + userFriendInfoRepository.findAll());
    }

    @Test
    void crudTest2() {
        givenUserFriendInfo();

        User result = userFriendInfoRepository
                        .findById(1L)
                        .orElseThrow(RuntimeException::new)
                        .getUser();

        System.out.println(">>> " + result);

        UserFriendInfo result2 = userRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getUserFriendInfo();

        System.out.println(">>> " + result2);
    }

    private User givenUser() {
        User user = new User();
        user.setName("홍길동");
        user.setEmail("gildong2@numble.com");
        user.setPassword("1234");

        return userRepository.save(user);
    }

    private void givenUserFriendInfo() {
        UserFriendInfo userFriendInfo = new UserFriendInfo();
        userFriendInfo.setUser(givenUser());
        userFriendInfo.setFriendCount(2);

        userFriendInfoRepository.save(userFriendInfo);

        System.out.println(">>> " + userFriendInfoRepository.findAll());
    }
}