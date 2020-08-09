package com.kuang.swagger.service;

import com.kuang.swagger.mapper.ProjectMapper;
import com.kuang.swagger.pojo.Project;
import com.kuang.swagger.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsService  {
  @Autowired
  private ProjectMapper projectMapper;
  public List<Project> findByName(int stu_id){
    return  projectMapper.queryProjectByid(stu_id);

  }

  public boolean inserProject(Integer stu_id,String pro_name,String pro_user,String pro_content,String pro_skill) {
    projectMapper.inserProject(stu_id, pro_name, pro_user, pro_content, pro_skill);
    return true;
  }
}
