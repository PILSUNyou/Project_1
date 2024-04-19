package org.example.app;

import org.example.controller.LankingController;
import org.example.screen.Battle;
import org.example.screen.Loding;
import org.example.stage.battleProgram;

import java.util.Scanner;

public class GameApp {
    private Scanner sc;
    int stage = 1;
    int characterHp = 5;
    int monsterHp = 1;
    int defeatNumber = 0; // 1이 될 경우 게임을 종료하여 서브화면으로 나가지도록 한다.
    String breakTime = "";

    public void Start() {
        sc = new Scanner(System.in);
        LankingController lankingController = new LankingController();
        while (stage < 7) {
            if (defeatNumber == 1){
                break;
            }

            System.out.printf("현재 스테이지 : STAGE %d\n", stage);
            System.out.println("게임을 시작하려면 \"1\" 또는 \"게임시작\"을 입력해주세요 !");
            System.out.println("게임을 그만하고 싶으면 \"2\" 또는 \"게임종료\"를 입력해주세요 !");
            System.out.println("게임을 종료하면 처음부터 다시 시작해야 합니다 !");
            if (sc.hasNextLine()) {  // 추가: 다음 입력이 있는지 확인
                breakTime = sc.nextLine().trim();
            }

            if (breakTime.equals("1") || breakTime.equals("게임시작")) {
                Loding.lodingScreen();
                switch (stage) {
                    case 1: // stage 1
                        Battle.battleAnimation1();
                        if(new battleProgram().battleProgram1(stage, characterHp, monsterHp) == 1){
                            lankingController.putInLanking(stage);
                            stage++;
                        }
                        else{
                            defeatNumber++;
                        }
                        break;

                    case 2: // stage 2
                        Battle.battleAnimation2();
                        if(new battleProgram().battleProgram2(stage, characterHp, monsterHp) == 1){
                            lankingController.putInLanking(stage);
                            stage++;
                        }
                        else{
                            defeatNumber++;
                        }
                        break;

                    case 3: // stage 3
                        Battle.battleAnimation3();
                        if(new battleProgram().battleProgram3(stage, characterHp, monsterHp) == 1){
                            lankingController.putInLanking(stage);
                            stage++;
                        }
                        else{
                            defeatNumber++;
                        }
                        break;

                    case 4: // stage 4
                        Battle.battleAnimation4();
                        if(new battleProgram().battleProgram4(stage, characterHp, monsterHp) == 1){
                            lankingController.putInLanking(stage);
                            stage++;
                        }
                        else{
                            defeatNumber++;
                        }
                        break;

                    case 5: // stage 5
                        Battle.battleAnimation5();
                        if(new battleProgram().battleProgram5(stage, characterHp, monsterHp) == 1){
                            lankingController.putInLanking(stage);
                            stage++;
                        }
                        else{
                            defeatNumber++;
                        }
                        break;

                    case 6: // stage 6
                        Battle.battleAnimation6();
                        if(new battleProgram().battleProgram6(stage, characterHp, monsterHp) == 1){
                            lankingController.putInLanking(stage);
                            stage++;
                        }
                        else{
                            defeatNumber++;
                        }
                        break;
                }
            }
            else if (breakTime.equals("2") || breakTime.equals("게임종료")) {
                break;
            }
            else {
                System.out.println("잘못된 명령어 입니다.");
            }
        }
    }
}
