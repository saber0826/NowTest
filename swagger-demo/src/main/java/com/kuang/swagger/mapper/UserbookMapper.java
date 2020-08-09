package com.kuang.swagger.mapper;

import com.kuang.swagger.pojo.User;
import com.kuang.swagger.pojo.Userbook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserbookMapper {
  List<Userbook> queryUserBookList();
}
