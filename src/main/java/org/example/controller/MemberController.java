package org.example.controller;

import org.example.app.SubApp;
import org.example.container.Container;
import org.example.dto.Member;
import org.example.service.MemberService;
import org.example.util.Util;


import java.util.Scanner;

public class MemberController{
    private Scanner sc;
    private MemberService memberService;
    private static Session session;

    public MemberController() {
        sc = Container.getScanner();
        session = Container.getSession();
        memberService = Container.memberService;
    }
    public void doLogin() {
        System.out.printf("ID : ");
        String loginId = sc.nextLine();
        System.out.printf("PassWord : ");
        String loginPw = sc.nextLine();

        // 입력받은 아이디에 해당하는 회원이 존재하는지 확인
        Member member = memberService.getMemberByLoginId(loginId);

        if (member == null){
            System.out.println("해당 회원은 존재하지 않습니다.");
            return;
        }
        if (member.loginPw.equals(loginPw) == false){
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }
        session.setLoginedMember(member);
        Member loginedMember = session.getLoginedMember();

        new SubApp().Start();
    }

    public static void doLogout() {
        session.setLoginedMember(null);
    }

    public void doJoin() {
        int id = Container.memberDao.getNewId();
        String regDate = Util.getNowDateStr();

        String loginId = null;

        while (true){
            System.out.printf("사용할 ID를 입력하세요 : ");
            loginId = sc.nextLine();

            if (isJoinableLoginId(loginId) == false){
                System.out.printf("%s(은)는 이미 사용중인 아이디 입니다.\n", loginId);
                continue;
            }
            break;
        }

        String loginPw= null;
        String loginPwConfirm = null;

        while (true){
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

        while (true) {
            System.out.printf("닉네임은 6자 이내로 작성 가성합니다. \n");
            System.out.printf("닉네임을 입력하세요 : ");
            nickName = sc.nextLine();

            if (isJoinableNickName(nickName) == false) {
                System.out.printf("%s(은)는 이미 사용중인 닉네임 입니다.\n", nickName);
                continue;
            }
            else if (nickName.length() > 6){
                System.out.printf("닉네임의 길이가 너무 깁니다.\n");
                continue;
            }
            break;
        }

        Member member = new Member(loginId, loginPw, nickName);
        memberService.join(member);

        System.out.printf("[%s]회원가입이 완료되었습니다 ! 환영합니다.))\n", nickName);
    }

    public int doMemberWithdrawal() {
        String loginId = session.loginedMember.loginId;
        String nickName = session.loginedMember.nickName;

        for (int i = 0; i < 150; i++) {
            System.out.println("");
            System.out.flush();
        }

        System.out.println("현재 등록되어 있는 랭킹 및 계정은 모두 삭제 됩니다.");
        System.out.printf("현재 로그인 되어 있는 %s님의 계정을 삭제 하시겠습니까?\n",loginId);
        System.out.println("1. 삭제한다                     2. 그만둔다");
        String deleteCmd1 = sc.nextLine();
        if (deleteCmd1.equals("2") || deleteCmd1.startsWith("그만")){
            return 0;
        }

        for (int i = 0; i < 150; i++) {
            System.out.println("");
            System.out.flush();
        }

        System.out.printf("정말로 삭제하시겠습니까 ?\n",loginId);
        System.out.println("1. 삭제한다                     2. 그만둔다");
        String deleteCmd2 = sc.nextLine();
        if (deleteCmd2.equals("2") || deleteCmd2.startsWith("그만")){
            return 0;
        }

        for (int i = 0; i < 150; i++) {
            System.out.println("");
            System.out.flush();
        }

        memberService.deleteMemberByLoginId(loginId);
        memberService.deleteLankingByLoginId(nickName);
        System.out.println("회원 탈퇴가 완료되었습니다.");
        System.out.println("이용해 주셔서 감사합니다.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
        return 1;
    }

    private boolean isJoinableLoginId(String loginId) {
        Member member = memberService.getMemberByLoginId(loginId);

        if(member == null){
            return true;
        }
        return false;
    }
    private boolean isJoinableNickName(String nickName) {
        Member member = memberService.getMemberByNickName(nickName);

        if(member == null){
            return true;
        }
        return false;
    }
}