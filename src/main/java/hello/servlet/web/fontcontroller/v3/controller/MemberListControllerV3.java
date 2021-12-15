package hello.servlet.web.fontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.fontcontroller.ModelView;
import hello.servlet.web.fontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    
    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> allList = memberRepository.findAll();
        ModelView members = new ModelView("members");
        members.getModel().put("members", allList);
        return members;
    }
}
