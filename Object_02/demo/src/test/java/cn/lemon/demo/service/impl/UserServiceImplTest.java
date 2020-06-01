package cn.lemon.demo.service.impl;

import cn.lemon.demo.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceImplTest {

  @Autowired
private UserServiceImpl userService;

  @Test
  void add() {
    User user = new User();
    user.setName("莱昂纳德");
    user.setAge(30);
    user.setSex("男");
    user.setAddress("洛杉矶快船");
    userService.add(user);
  }


  @Test
  void delete() {
    userService.delete(10);
  }


  @Test
  void findAll() {
    List<User> userList = userService.findAll();
    for (User user : userList) {
      System.out.println(user.getName());
    }
  }


  @Test
  void findById() {
    User user = userService.findById(1);
    System.out.println(user.getName() + user.getAddress());
  }


  @Test
  void findByName() {
    List<User> userList = userService.findByName("詹");
    for (User user : userList) {
      System.out.println(user.getName() + user.getAddress());
    }
  }


  @Test
  void update() {
    User user = new User();
    user.setId(14);
    user.setName("隆多");
    user.setAge(35);
    user.setSex("男");
    user.setAddress("洛杉矶湖人");
    userService.update(user);
  }


}
