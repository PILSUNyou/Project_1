package org.example.app;

import org.example.screen.Attack;
import org.example.screen.Battle;
import org.example.screen.Screen;
import org.example.stage.Stage;

import java.util.*;

public class GameApp {
    private boolean isTimeout = false; // 입력 시간 초과 여부를 저장하는 변수
    private Scanner sc;
    int stage = 1;
    String sign = "";
    int characterHp = 5;
    int monsterHp = 5;

    public void Start() {
        Timer timer = new Timer();

        sc = new Scanner(System.in);

        switch (stage) {
            case 1: // stage 1
                Battle.battleAnimation1();

                while (characterHp > 0 && monsterHp > 0) {
                    Random random = new Random(); // 랜덤 함수 생성
                    int attackEffectRandomNumber = (int) (Math.random() * 3) + 1;
                    int number1 = (int) (Math.random() * 91) + 10; // 첫 번째 랜덤 숫자 저장
                    int number2 = (int) (Math.random() * 91) + 10; // 두 번째 랜덤 숫자 저장

                    int sum = 0; // 첫 번째 , 두 번째 숫자를 합할 변수 지정

                    int r = random.nextInt(2); // 첫 번째 랜덤 숫자 저장

                    if (r == 0) { // r == 0일 경우 + 계산식
                        sum = number1 + number2;
                        sign = "+";
                    } else if (r == 1) { // r == 1일 경우 - 계산식
                        sum = number1 - number2;
                        sign = "-";
                    }

                    Stage.first(number1, number2, characterHp, monsterHp, sign);

                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            System.out.println("입력 시간이 초과되었습니다.(정답을 써도 공격을 받습니다 !)");
                            isTimeout = true;  // 입력 시간 초과 상태를 true로 변경
                            synchronized (GameApp.this) {
                                GameApp.this.notify();  // 게임 루프를 대기 상태에서 깨웁니다.
                            }
                        }
                    };

                    timer.schedule(task, 10000);  // 10초 후에 TimerTask 실행

                    int inputNumber = 0;
                    boolean isInputValid = false;

                    try {
                        inputNumber = sc.nextInt();
                        isInputValid = true;  // 올바른 입력을 받았으므로 반복문 종료
                    } catch (InputMismatchException e) {
                        System.out.println("정수를 입력해주세요.");
                        sc.nextLine();  // 잘못된 입력을 읽고 버립니다.
                    }

                    task.cancel();  // TimerTask 취소

                    if (isTimeout) {
                        for (int i = 0; i < 100; i++) {
                            System.out.println("");
                            System.out.flush();
                        }
                        new Attack().monsterAttackAnimation(stage);
                        characterHp--;
                        isTimeout = false;  // 플래그 초기화
                        continue;  // 입력 시간 초과일 경우 다음 루프로 건너뛰기
                    }  // 입력 시간 초과일 경우 다음 루프로 건너뛰기

                    if (!isInputValid) {
                        continue;  // 입력이 유효하지 않으면 다음 루프로 건너뛰기
                    }


                    if (inputNumber == sum) {
                        for (int i = 0; i < 100; i++) {
                            System.out.println("");
                            System.out.flush();
                        }
                        new Attack().playerAttackAnimation(attackEffectRandomNumber);
                        monsterHp--;
                    } else {
                        for (int i = 0; i < 100; i++) {
                            System.out.println("");
                            System.out.flush();
                        }
                        new Attack().monsterAttackAnimation(stage);
                        characterHp--;
                    }
                }
                sc.close();
                timer.cancel();
                if (monsterHp == 0) {
                    Screen.gameVictory();
                    characterHp = 5;
                    monsterHp = 5;
                    if ( stage <= 6 ) {
                        stage++;
                    }
                    else {
                        break;
                    }
                } else if (characterHp == 0) {
                    Screen.gameDefeat();
                    characterHp = 5;
                    monsterHp = 5;
                    break;
                }
        }
    }
}
