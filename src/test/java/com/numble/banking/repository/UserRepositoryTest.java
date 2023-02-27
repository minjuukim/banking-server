package com.numble.banking.repository;

import com.numble.banking.domain.Friend;
import com.numble.banking.domain.Gender;
import com.numble.banking.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRepository friendRepository;

    @Test
    void userTest() {
        User user = new User();     // 엔티티 생성
        user.setName("홍길동");
        user.setEmail("hong@numble.com");
        user.setPassword("1234");
        user.setGender(Gender.MALE);

        userRepository.save(user);

        System.out.println(userRepository.findAll());
    }

    @Test
    void userRelationTest() {
        User user = new User();
        user.setName("david");
        user.setEmail("david1234@numble.com");
        user.setPassword("123456");
        user.setGender(Gender.MALE);
        userRepository.save(user);

        user.setName("daniel");
        userRepository.save(user);

        user.setEmail("daniel@numble.com");
        userRepository.save(user);

        friendRepository.findAll().forEach(System.out::println);

//        List<Friend> result = friendRepository.findByUserId(
//                userRepository.findByEmail("daniel@numble.com").getId());

        List<Friend> result = userRepository.findByEmail("daniel@numble.com").getFriends();

        result.forEach(System.out::println);

        System.out.println("Friend.getUser() : " + friendRepository.findAll().get(0).getUser());
    }
}