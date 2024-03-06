package com.study.erum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.erum.dto.MemberDTO;
import com.study.erum.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
  
  //repository와 연결
  private final MemberRepository memberRepository;

  public int save(MemberDTO memberDTO) {
    return memberRepository.save(memberDTO);
  }

  public boolean login(MemberDTO memberDTO) {
    MemberDTO loginMember = memberRepository.login(memberDTO);
    
    //입력한 회원정보가 있다면
    if(loginMember != null) {
      return true;
    }else {
      return false;
    }
  }

  public List<MemberDTO> findAll() {
    return memberRepository.findAll();
  }

  public MemberDTO findById(Long id) {
    return memberRepository.findById(id);
  }

  public void delete(Long id) {
    memberRepository.delete(id);
  }

  public MemberDTO findByMemberEmail(String loginEmail) {
    return memberRepository.findByMemberEmail(loginEmail);
  }

  public boolean update(MemberDTO memberDTO) {
    int result = memberRepository.update(memberDTO);
    
    if(result > 0) return true;
    else return false;
  }

  public String emailCheck(String memberEmail) {

    MemberDTO memberDTO = memberRepository.findByMemberEmail(memberEmail);
    if(memberDTO == null) {
      //사용자가 가입하려는 이메일이 중복된 이메일이 아니면 ajax에 "ok"를 보내서 정상실행 하도록 함
      return "ok";
    }else{
      return "no";
    }
  }//end of emailCheck

}//end of Service
