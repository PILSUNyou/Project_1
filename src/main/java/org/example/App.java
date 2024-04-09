package org.example;

import org.example.dto.Member;
import org.example.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Member> members;
    App(){
        members = new ArrayList<>();
    }
    public  void start() {
        // 메인화면 스크린 표시
        Screen.mainSreen();
        makeTestData();
        Scanner sc = new Scanner(System.in);

        while(true){
            // 메인화면 선택창 출력
            Screen.mainSelectScreen();
            System.out.print("명령어를 입력해 주세요 : ");
            String cmd = sc.nextLine();
            cmd = cmd.trim();

            if(cmd.equals("3") || cmd.equals("exit") || cmd.startsWith("종료") || cmd.equals("EXIT")){
                Screen.exitScreen();
                break;
            }

            if(cmd.length() == 0){
                System.out.print("명령어를 입력해 주세요 :");
                Screen.mainSelectScreen();
                continue;
            }


            else if(cmd.equals("1") || cmd.equals("login") || cmd.startsWith("로그인")){

            }

            else if(cmd.equals("2") || cmd.equals("join") || cmd.startsWith("회원가입")){
                int id = members.size() +1;
                String regDate = Util.getNowDateStr();
                String loginId = null;
                // ID 만들기 (중복 시 다시 작성)
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
                // PW 만들기
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
                // 닉네임 만들기(중복 시 다시 작성)
                while (true){
                    System.out.printf("사용할 닉네임을 입력하세요 : ");
                    nickName = sc.nextLine();

                    if (isJoinablenickName(nickName) == false){
                        System.out.printf("%s(은)는 이미 사용중인 닉네임 입니다.\n", nickName);
                        continue;
                    }
                    break;
                }
                members.add(new Member(id,regDate,loginId,loginPw,nickName));
            }
            else {
                System.out.println("잘못된 명령어 입니다.");
                continue;
            }
        }
    }
    // ID 중복 확인
    private static boolean isJoinableLoginId(String loginId) {
        int index = getMemberIndexByLoginId(loginId);

        if(index == -1){
            return true;
        }
        return false;
    }
    private static int getMemberIndexByLoginId(String loginId) {
        int i = 0;
        for ( Member member : members){
            if (member.loginId.equals(loginId)){
                return i;
            }
            i++;
        }
        return -1;
    }

    // 닉네임 중복 확인
    private static boolean isJoinablenickName(String nickName) {
        int index = getMemberIndexBynickName(nickName);

        if(index == -1){
            return true;
        }
        return false;
    }
    private static int getMemberIndexBynickName(String nickName) {
        int i = 0;
        for ( Member member : members){
            if (member.nickName.equals(nickName)){
                return i;
            }
            i++;
        }
        return -1;
    }
    private void makeTestData(){
        System.out.println("테스트를 위한 게시물 데이터를 생성합니다.");
        members.add(new Member(1, Util.getNowDateStr(), "admin", "admin","관리자"));
    }
}
