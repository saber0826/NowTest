package com.kuang.swagger.service;

import com.kuang.swagger.mapper.UserMapper;
import com.kuang.swagger.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersService {
  @Autowired
  private UserMapper userMapper;

  public List<User> findByName(int id){
    return  userMapper.queryUserByid(id);

  }

  public User adduser(User user){
    userMapper.addUser(user);
    return user;
  }

  public List<User> userList(){

    return userMapper.queryUserList();
  }

  public  int Update(User user){
    return userMapper.updateUser(user);
  }

  public int delete(int id){
    return userMapper.deleteUser(id);
  }

 public User selectUser(Integer id,String password){
    System.out.println("学号"+""+id);
    return userMapper.selectUser(id,password);
 }

  public boolean inserUser(Integer id,String username,String password,String phone) {
    userMapper.inserUser(id,username, password,phone);
    return true;
  }
}
