package org.example.service;

import org.example.container.Container;
import org.example.dao.MemberDao;
import org.example.dto.Member;

public class MemberService {
    private MemberDao memberDao;

    public MemberService(){
        memberDao = Container.memberDao;
    }
    // 아이디 중복 확인
    public Member getMemberByLoginId(String loginId) {
        return memberDao.getMemberByLoginId(loginId);
    }

    // 회원가입
    public int join(Member member) {
        return memberDao.join(member);
    }
    // 닉네임 중복 확인
    public Member getMemberByNickName(String nickName) {
        return memberDao.getMemberByNickName(nickName);
    }
}
