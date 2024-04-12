package org.example.app;

import org.example.screen.Battle;
import org.example.screen.Screen;
import org.example.stage.Stage;

import java.util.Random;
import java.util.Scanner;

public class GameApp {
    int stage = 1;

    int characterHp = 5;
    int monsterHp = 5;

    public void Start() {
        Scanner sc = new Scanner(System.in);
            switch (stage) {
                case 1: // stage 1
                    Battle.battleAnimation1();
                    while (characterHp > 0 && monsterHp > 0) {
                        Random random = new Random(); // 랜덤 함수 생성

                        int number1 = (int) (Math.random() * 91) + 10; // 첫 번째 랜덤 숫자 저장
                        int number2 = (int) (Math.random() * 91) + 10; // 두 번째 랜덤 숫자 저장
                        Stage.first(number1,number2, characterHp,monsterHp);
                        int sum = 0; // 첫 번째 , 두 번째 숫자를 합할 변수 지정

                        int r = random.nextInt(2); // 첫 번째 랜덤 숫자 저장

                        if (r == 0) { // r == 0일 경우 + 계산식
                            sum = number1 + number2;
                            System.out.printf("%d + %d = ", number1, number2);
                        }

                        else if (r == 1) { // r == 0일 경우 + 계산식
                            sum = number1 - number2;
                            System.out.printf("%d - %d = ", number1, number2);
                        }

                        int cmd3 = sc.nextInt(); // 정답 입력

                        if (cmd3 == sum) {
                            monsterHp--;
                            System.out.println("=========================================================");
                            System.out.println("=====                   =================================");
                            System.out.printf("=====  player Hp : %d    =================================\n",characterHp);
                            System.out.println("=====                   =================================");
                            System.out.println("============================                    =========");
                            System.out.printf("============================  monster Hp : %d    =========\n",monsterHp);
                            System.out.println("============================                    =========");
                            System.out.println("=========================================================");
                            System.out.println();
                        }

                        else if (cmd3 != sum) {
                            characterHp--;
                            System.out.println("=========================================================");
                            System.out.println("=====                   =================================");
                            System.out.printf("=====  player Hp : %d    =================================\n",characterHp);
                            System.out.println("=====                   =================================");
                            System.out.println("============================                    =========");
                            System.out.printf("============================  monster Hp : %d    =========\n",monsterHp);
                            System.out.println("============================                    =========");
                            System.out.println("=========================================================");
                            System.out.println();
                        }

                        if(monsterHp == 0){
                            Screen.gameVictory();
                        }

                        else if(characterHp == 0){
                            Screen.gameDefeat();
                        }
                    }
        }
    }
}
