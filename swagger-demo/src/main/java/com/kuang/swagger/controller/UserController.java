package com.kuang.swagger.controller;

import com.kuang.swagger.pojo.User;


import com.kuang.swagger.service.UsersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import com.kuang.swagger.domain.Result;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
  @Autowired

  private UsersService usersService;
  @GetMapping("/users")
  @ApiOperation(value = "查看用户", notes = "查看用户")
  public List<User> queryUserList(){
    List<User> userList= usersService.userList();
    for(User user:userList){
      System.out.println(user);
    }
    return userList;
  }
  @PutMapping("/adduser")
  @ApiOperation(value="增加用户",notes = "增加用户")
  public User addUser(@RequestBody User user){
    return usersService.adduser(user);
  }

  @DeleteMapping("/deleteUser")
  public String deleteUser(int id ){
    int result =usersService.delete(id);
    if(result>=1) {
      return "删除成功！";
    }else {
      return "删除失败！";
    }
  }
  @GetMapping("/user")
  @ApiOperation(value = "根据编号查看用户", notes = "根据编号查看用户")
  public List<User> findByName(int id){
    return usersService.findByName(id);
  }
  @PostMapping("/change")
  @ApiOperation(value = "修改用户", notes = "修改用户")
  public String update(User user){
    int result =usersService.Update(user);
    if(result>=1) {
      return "更新成功！";
    }else {
      return "更新失败！";
    }
  }

  @PostMapping("/register")
  public boolean Register(@RequestBody User user){
    usersService.inserUser(user.getId(),user.getUsername(),user.getPassword(),user.getPhone());

    return true;
  }
  @PostMapping("/dologin")
  public Result doLogin(@RequestBody User user, HttpSession session){
    User user2=usersService.selectUser(user.getId(),user.getPassword());
    if (user2==null){
      return new Result(500,"false","");
    }else{
      session.setAttribute("200",user.getId());
      System.out.println(new Result(200,"true",user2));
      return new Result(200,"true",user2);
    }
  }
}
