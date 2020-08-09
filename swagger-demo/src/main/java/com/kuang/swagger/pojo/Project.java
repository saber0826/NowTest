package com.kuang.swagger.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
  private int stu_id;
  private String pro_name;
  private String pro_user;
  private String pro_content;
  private String pro_skill;
}
