package com.study.erum.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.erum.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

  private final SqlSessionTemplate sql;
  
  public int save(MemberDTO memberDTO) {
    //데이터가 제대로 넘어갔는지 확인
    System.out.println("memberDTO = " + memberDTO);
    
    //memberMapper.xml 에서 sql문 실행
    //Member 네임스페이스의 id save에 memberDTO를 파라미터로 넘겨서 실행
    return sql.insert("Member.save", memberDTO);
  }

  public MemberDTO login(MemberDTO memberDTO) {
    return sql.selectOne("Member.login", memberDTO);
  }

  public List<MemberDTO> findAll() {
    return sql.selectList("Member.findAll");
  }

  public MemberDTO findById(Long id) {
    return sql.selectOne("Member.findById", id);
  }

  public void delete(Long id) {
    sql.delete("Member.delete", id);
  }

  public MemberDTO findByMemberEmail(String loginEmail) {
    return sql.selectOne("Member.findByMemberEmail",loginEmail);
  }

  public int update(MemberDTO memberDTO) {
    return sql.update("Member.update", memberDTO);
  }
  
}
