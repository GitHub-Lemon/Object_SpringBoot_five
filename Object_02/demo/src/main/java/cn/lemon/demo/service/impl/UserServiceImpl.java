package cn.lemon.demo.service.impl;

import cn.lemon.demo.dao.IUserDao;
import cn.lemon.demo.domain.User;
import cn.lemon.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserDao iUserDao;

  @Override
  public int add(User user) {
    return iUserDao.add(user);
  }


  @Override
  public int delete(Integer id) {
    return iUserDao.delete(id);
  }


  @Override
  public List<User> findAll() {
    return iUserDao.findAll();
  }


  @Override
  public User findById(Integer id) {
    return iUserDao.findById(id);
  }


  @Override
  public List<User> findByName(String name) {
    return iUserDao.findByName(name);
  }


  @Override
  public int update(User user) {
    return iUserDao.update(user);
  }


}
