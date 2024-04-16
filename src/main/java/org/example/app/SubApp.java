package org.example.app;

import org.example.screen.Rool;
import org.example.screen.Screen;

import java.util.Scanner;

public class SubApp {
    public void Start() {
        String subCmd = "";
        String skip = "";

        Scanner sc = new Scanner(System.in);

        // 서브화면 스크린 표시
        Screen.subSreen();


        while (true) {
            System.out.print("명령어를 입력해 주세요 : ");
            Screen.subSelectScreen();
            System.out.println("다음 입력 대기 중");
            subCmd = sc.nextLine();
            subCmd = subCmd.trim();

            if (subCmd.equals("3") || subCmd.equals("logout") || subCmd.startsWith("로그아웃")) {
                Screen.mainSreen();
                break;
            }

            if (subCmd.length() == 0) {
                System.out.print("명령어를 입력해 주세요 :");
                Screen.subSelectScreen();
                continue;

            } else if (subCmd.equals("1") || subCmd.equals("gameStart") || subCmd.startsWith("게임시작")) {
                Screen.roolSkip();
                if (sc.hasNextLine()) {  // 추가: 다음 입력이 있는지 확인
                    skip = sc.nextLine().trim();  // skip 읽기
                }

                if (skip.equals("1") || skip.equals("skip") || skip.equals("스킵")) {
                    new GameApp().Start();
                } else {
                    Rool.run();
                    new GameApp().Start();
                }
                continue;
            } else if (subCmd.equals("2") || subCmd.equals("lanking") || subCmd.startsWith("랭킹")) {
                // 랭킹 처리
                continue;
            } else {
                System.out.println("잘못된 명령어 입니다.");
                Screen.subSelectScreen();
                continue;
            }
        }
    }
}
