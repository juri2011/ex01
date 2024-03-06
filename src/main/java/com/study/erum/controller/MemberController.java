package com.study.erum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.erum.dto.MemberDTO;
import com.study.erum.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
//member로 시작하는 페이지
@RequestMapping("/member")
//생성자주입
@RequiredArgsConstructor
public class MemberController {
  
  //@Autowired -> 필드 주입
  //요즘에는 보안성을 높이기 위해 필드 주입 대신에 생성자 주입을 쓴다. -> @RequiredArgsConstructor
  //final -> 멤버변수를 기호상수로 사용하므로 안전하다.
  //service와 연결
  private final MemberService memberService;
  
  //화면에 출력하는 form (수정하는 것, 입력하는 것 각각 두 가지 form이 필요하다.)
  @GetMapping("/save")
  public String saveForm() {
    // "save.jsp"를 호출 할 것
    return "save";
  }
  
  //위의 getMapping과 부딪히지 않는다.
  @PostMapping("/save")
  public String save(@ModelAttribute MemberDTO memberDTO) {
    int saveResult = memberService.save(memberDTO);
    if(saveResult > 0) {
      return "login";
    }else {
      return "save";
    }
  }
  
  @GetMapping("/login")
  public String loginForm() {
    // "save.jsp"를 호출 할 것
    return "login";
  }
  
  //위의 getMapping과 부딪히지 않는다.
  @PostMapping("/login")
  public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
    
    boolean loginResult = memberService.login(memberDTO);
    if(loginResult) {
      session.setAttribute("loginEmail", memberDTO.getMemberEmail());
      return "main";
    }else {
      return "login";
    }
  }
  
  // "/member/" 루트
  @GetMapping("/")
  public String findAll(Model model) {
    //generic : 다양한 타입을 다룰 때
    List<MemberDTO> memberDTOList = memberService.findAll();
    //memberDTOList를 memberList 속성에 넘김
    model.addAttribute("memberList", memberDTOList);
    return "list";
  }
  
  // /member?id=1
  // RequestParam이 queryString으로부터 id를 가져옴
  //@GetMapping 괄호 없음 -> /member 사용
  @GetMapping
  public String findById(@RequestParam("id") Long id, Model model) {
    /*
        1. service로부터 가져온 data가 DTO에 들어감
        2. memberDTO를 member에게 넘김
        3. detail.jsp(view)에 뿌림
     */
    MemberDTO memberDTO = memberService.findById(id);
    model.addAttribute("member", memberDTO);
    return "detail";
  }
  
  @GetMapping("/delete")
  public String delete(@RequestParam Long id) {
    memberService.delete(id);
    return "redirect:/member/";
  }
  
  //수정화면 호출
  @GetMapping("/update")
  public String updateForm(HttpSession session, Model model) {
    //세션에 저장된 나의 이메일 가져오기 
    //session 의 getAttribute는 Object를 가져오므로 String으로 캐스팅(Cascade)
    String loginEmail = (String) session.getAttribute("loginEmail");
    MemberDTO memberDTO = memberService.findByMemberEmail(loginEmail);
    model.addAttribute("member", memberDTO);
    return "update";
  }
  
  @PostMapping("/update")
  public String update(@ModelAttribute MemberDTO memberDTO) {
    boolean result = memberService.update(memberDTO);
    if(result) {
      //post 이중으로 처리 되지 않기 위해 prg 패턴 사용 post-redirect-get
      return "redirect:/member?id=" + memberDTO.getId();
    }else {
      return "index";
    }
  }
  
  @PostMapping("/email-check")
  public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail) {
    System.out.println("memberEmail = "+memberEmail);
    String checkResult = memberService.emailCheck(memberEmail);
    return checkResult;
  }
  
  @GetMapping("/logout")
  public String logout(){
    return "logout";
  } 
  
}
