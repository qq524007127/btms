package com.sunjee.btms.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sunjee.btms.bean.Member;

@Controller("memberAction")
@Scope("prototype")
public class MemberAction extends BaseAction<Member> {

	private static final long serialVersionUID = -6939488060224558663L;

}
