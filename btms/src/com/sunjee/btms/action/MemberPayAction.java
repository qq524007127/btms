package com.sunjee.btms.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sunjee.btms.bean.Member;
import com.sunjee.btms.service.MemberService;

@Controller("memberPayAction")
@Scope("prototype")
public class MemberPayAction extends ActionSupport {

	private static final long serialVersionUID = 6409678087839635517L;

	private MemberService memberService;

	private Member member;
	private String memberId;
	
	public MemberService getMemberService() {
		return memberService;
	}

	@Resource(name = "memberService")
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String execute() throws Exception {
		this.member = this.memberService.getById(memberId);
		return super.execute();
	}
}
