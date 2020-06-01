package cn.lemon.demo.dao;

import cn.lemon.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

  public int add(User user);


  public int delete(Integer id);


  public List<User> findAll();


  public User findById(Integer id);


  public List<User> findByName(String name);


  public int update(User user);


}
