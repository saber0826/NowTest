package com.kuang.swagger.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userbook {
  private int book_id;
  private String book_name;
  private String image;
  private String New_book;
  private String username;
}
