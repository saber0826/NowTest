package com.kuang.swagger.mapper;

import com.kuang.swagger.pojo.Project;
import com.kuang.swagger.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectMapper {
  List<Project> queryProjectByid(int stu_id);
  public void inserProject(@Param("stu_id")Integer stu_id, @Param("pro_name")String pro_name, @Param("pro_user")String pro_user, @Param("pro_content")String pro_content,@Param("pro_skill")String pro_skill);
}
