package org.example.controller;

import org.example.Util;
import org.example.app.SubApp;
import org.example.dto.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberController{
    private Scanner sc;
    private List<Member> members;
    private Member loginedMember;
    public MemberController(Scanner sc) {
        this.sc = sc;
        members = new ArrayList<>();
    }
    public void doLogin() {

        System.out.printf("ID : ");
        String loginId = sc.nextLine();
        System.out.printf("PassWord : ");
        String loginPw = sc.nextLine();

        // 입력받은 아이디에 해당하는 회원이 존재하는지 확인
        Member member = getMemberByLoginId(loginId);

        if (member == null){
            System.out.println("해당 회원은 존재하지 않습니다.");
            return;
        }
        if (member.loginPw.equals(loginPw) == false){
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }
        loginedMember = member;
        new SubApp().Start();
    }

    public void doJoin() {
        int id = members.size() + 1;
        String regDate = Util.getNowDateStr();
        String loginId = null;
        // ID 만들기 (중복 시 다시 작성)
        while (true) {
            System.out.printf("사용할 ID를 입력하세요 : ");
            loginId = sc.nextLine();

            if (isJoinableLoginId(loginId) == false) {
                System.out.printf("%s(은)는 이미 사용중인 아이디 입니다.\n", loginId);
                continue;
            }
            break;
        }

        String loginPw = null;
        String loginPwConfirm = null;
        // PW 만들기
        while (true) {
            System.out.print("패스워드를 입력하세요 : ");
            loginPw = sc.nextLine();
            System.out.print("패스워드 확인 : ");
            loginPwConfirm = sc.nextLine();

            if (loginPw.equals(loginPwConfirm) == false) {
                System.out.println("패스워드가 일치하지 않습니다. 다시 작성해 주세요.");
                continue;
            }
            break;
        }
        String nickName = null;
        // 닉네임 만들기(중복 시 다시 작성)
        while (true) {
            System.out.printf("사용할 닉네임을 입력하세요 : ");
            nickName = sc.nextLine();

            if (isJoinablenickName(nickName) == false) {
                System.out.printf("%s(은)는 이미 사용중인 닉네임 입니다.\n", nickName);
                continue;
            }
            break;
        }
        Member member = new Member(id, regDate,loginId, loginPw, nickName);
        members.add(member);
        System.out.printf("%s님 %d번 회원이 생성 되었습니다.\n",member.nickName, id);
    }

    // ID 중복 확인
    private boolean isJoinableLoginId(String loginId) {
        int index = getMemberIndexByLoginId(loginId);

        if (index == -1) {
            return true;
        }
        return false;
    }

    private int getMemberIndexByLoginId(String loginId) {
        int i = 0;
        for (Member member : members) {
            if (member.loginId.equals(loginId)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // 닉네임 중복 확인
    private boolean isJoinablenickName(String nickName) {
        int index = getMemberIndexBynickName(nickName);

        if (index == -1) {
            return true;
        }
        return false;
    }

    private int getMemberIndexBynickName(String nickName) {
        int i = 0;
        for (Member member : members) {
            if (member.nickName.equals(nickName)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private Member getMemberByLoginId(String loginId) {
        int index = getMemberIndexByLoginId(loginId);

        if (index == -1){
            return null;
        }

        return members.get(index);
    }
}