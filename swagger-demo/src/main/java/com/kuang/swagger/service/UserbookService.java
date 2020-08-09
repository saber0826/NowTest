package com.kuang.swagger.service;

import com.kuang.swagger.mapper.UserbookMapper;

import com.kuang.swagger.pojo.Userbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserbookService {
  @Autowired
  private UserbookMapper userbookMapper;
  public List<Userbook> userbookList(){

    return userbookMapper.queryUserBookList();
  }
}
