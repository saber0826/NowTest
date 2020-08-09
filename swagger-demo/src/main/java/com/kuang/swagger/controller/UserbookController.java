package com.kuang.swagger.controller;

import com.kuang.swagger.pojo.User;
import com.kuang.swagger.pojo.Userbook;
import com.kuang.swagger.service.UserbookService;
import com.kuang.swagger.service.UsersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserbookController {
  @Autowired

  private UserbookService usersbookService;
  @GetMapping("/userbook")
  @ApiOperation(value = "查看用户书籍", notes = "查看用户书籍")
  public List<Userbook> queryBookList(){
    List<Userbook> userbookList=  usersbookService.userbookList();
    for(Userbook userbook:userbookList){
      System.out.println(userbook);
    }
    return userbookList;
  }
}
