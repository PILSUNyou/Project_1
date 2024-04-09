package org.example.app;

import org.example.screen.Rool;
import org.example.screen.Screen;

import java.util.Scanner;

public class SubApp {
    public void Start() {
        Scanner sc = new Scanner(System.in);

        // 메인화면 스크린 표시
        Screen.subSreen();

        while (true) {
            Screen.subSelectScreen();
            System.out.print("명령어를 입력해 주세요 : ");
            String subCmd = sc.nextLine();
            subCmd = subCmd.trim();

            if (subCmd.equals("3") || subCmd.equals("logout") || subCmd.startsWith("로그아웃")) {
                Screen.mainSreen();
                break;
            }

            if (subCmd.length() == 0) {
                System.out.print("명령어를 입력해 주세요 :");
                Screen.subSelectScreen();
                continue;
            }

            else if (subCmd.equals("1") || subCmd.equals("gameStart") || subCmd.startsWith("게임시작")) {
                Screen.roolSkip();
                String skip = sc.nextLine();

                if (skip.equals("1") || skip.equals("skip") || skip.equals("스킵")) {
                    break;
                }

            Rool.run();
            }

            else if (subCmd.equals("2") || subCmd.equals("lanking") || subCmd.startsWith("랭킹")) {

            }

            else{
                System.out.println("잘못된 명령어 입니다.");
                continue;
            }
        }
    }
}
