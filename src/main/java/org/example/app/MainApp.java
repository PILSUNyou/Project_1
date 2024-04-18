package org.example.app;

import org.example.container.Container;
import org.example.controller.MemberController;
import org.example.db.DBConnection;
import org.example.screen.Battle;
import org.example.screen.Screen;

import java.util.Scanner;

public class MainApp {
    public MainApp() {
        DBConnection.DB_NAME = "gamePJ";
        DBConnection.DB_USER = "sbsst";
        DBConnection.DB_PASSWORD = "sbs123414";
        DBConnection.DB_PORT = 3306;

        Container.getDBConnection().connect();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        MemberController memberController = new MemberController();
        // 메인화면 스크린 표시
        Screen.mainSreen();
        while (true) {
            // 메인화면 선택창 출력
            Screen.mainSelectScreen();
            System.out.print("명령어를 입력해 주세요 : ");

            String cmd = sc.nextLine();
            cmd = cmd.trim();

            if (cmd.equals("3") || cmd.equals("exit") || cmd.startsWith("종료") || cmd.equals("EXIT")) {
                Screen.exitScreen();
                break;
            }

            if (cmd.length() == 0) {
                System.out.print("명령어를 입력해 주세요 :");
                Screen.mainSelectScreen();
                continue;
            }

            else if (cmd.equals("1") || cmd.equals("login") || cmd.startsWith("로그인")) {
                memberController.doLogin();
            }

            else if (cmd.equals("2") || cmd.equals("join") || cmd.startsWith("회원가입")) {
                memberController.doJoin();
            }

            else{
                System.out.println("잘못된 명령어 입니다.");
                continue;
            }

        }
    }
}