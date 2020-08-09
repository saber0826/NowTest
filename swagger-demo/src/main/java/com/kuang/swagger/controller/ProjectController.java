package com.kuang.swagger.controller;

import com.kuang.swagger.pojo.Project;
import com.kuang.swagger.pojo.User;

import com.kuang.swagger.service.ProjectsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
  @Autowired
  private ProjectsService projectsService;
  @GetMapping("/project")
  @ApiOperation(value = "根据编号查看用户", notes = "根据编号查看用户")
  public List<Project> findByName(int stu_id){

    return projectsService.findByName(stu_id);
  }
  @PostMapping("/projects")
  public boolean projects (@RequestBody Project project){
    projectsService.inserProject(project.getStu_id(),project.getPro_name(),project.getPro_user(),project.getPro_content(),project.getPro_skill());
    return true;
  }
}
