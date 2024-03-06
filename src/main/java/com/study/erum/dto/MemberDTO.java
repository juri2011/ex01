package com.study.erum.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {

  //db에서 bigint는 java에서 long에 해당됨
  private Long id;
  private String memberEmail;
  private String memberPassword;
  private String memberName;
  private int memberAge;
  private String memberMobile;
  
}
