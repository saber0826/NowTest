package com.kuang.swagger.mapper;
import com.kuang.swagger.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
  List<User> queryUserList();
  List<User> queryUserByid(int id);
  int addUser(User user);
  int updateUser(User user);
  int deleteUser(int id);
  public void inserUser(@Param("id")Integer id,@Param("username")String username, @Param("password")String password,@Param("phone")String phone);
  public User selectUser(@Param("id")Integer id,@Param("password")String password);
}
