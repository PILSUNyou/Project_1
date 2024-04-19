package org.example.stage;

import org.example.screen.Attack;
import org.example.screen.Screen;

import java.util.*;

public class battleProgram {
    private boolean isTimeout = false; // 입력 시간 초과 여부를 저장하는 변수
    String sign = "";
    Scanner sc = new Scanner(System.in);
    Timer timer = new Timer();

    // 1단계 프로그램 진행
    public int battleProgram1(int stage, int characterHp, int monsterHp) {
        sc = new Scanner(System.in);

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

            timer = new Timer();  // Timer 인스턴스 새로 생성
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("입력 시간이 초과되었습니다.(정답을 써도 공격을 받습니다 !)");
                    isTimeout = true;  // 입력 시간 초과 상태를 true로 변경
                    synchronized (battleProgram.this) {
                        battleProgram.this.notify();  // 게임 루프를 대기 상태에서 깨웁니다.
                    }
                }
            };

            timer.schedule(task, 10000);  // 10초 후에 TimerTask 실행

            int inputNumber = 0;
            int attackCount = 3;

            for(int i = attackCount; i>0; i--){
                while (!sc.hasNextInt()) {
                    sc.next();
                    System.err.print("에러! 숫자가 아닙니다. \n재 입력 : ");
                }

            inputNumber = sc.nextInt();

                if (isTimeout) {
                    break;  // 입력 시간 초과일 경우 다음 루프로 건너뛰기
                }  // 입력 시간 초과일 경우 다음 루프로 건너뛰기

                else if (inputNumber != sum){
                    System.out.println("정답이 아닙니다 !");
                    System.out.printf("남은 기회 : %d\n", i-1);
                    System.out.printf("정답 입력 : ");
                }
                else{
                    break;
                }
            }

            task.cancel();  // TimerTask 취소
            if (isTimeout) {
                for (int j = 0; j < 100; j++) {
                    System.out.println("");
                    System.out.flush();
                }
                new Attack().monsterAttackAnimation(stage);
                characterHp--;
                isTimeout = false;  // 플래그 초기화
                continue;
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
        timer.cancel();
        if (monsterHp == 0) {
            Screen.gameVictory();
            return 1;
        } else if (characterHp == 0) {
            Screen.gameDefeat();
        }
        return 0;
    }

    // 2단계 프로그램 진행
    public int battleProgram2(int stage, int characterHp, int monsterHp) {
        sc = new Scanner(System.in);
        while (characterHp > 0 && monsterHp > 0) {
            Random random = new Random(); // 랜덤 함수 생성
            int attackEffectRandomNumber = (int) (Math.random() * 3) + 1;
            int number1 = (int) (Math.random() * 91) + 10; // 첫 번째 랜덤 숫자 저장
            int number2 = (int) (Math.random() * 91) + 10; // 두 번째 랜덤 숫자 저장

            int sum = 0; // 첫 번째 , 두 번째 숫자를 합할 변수 지정

            int r = random.nextInt(3); // 첫 번째 랜덤 숫자 저장

            if (r == 0) { // r == 0일 경우 + 계산식
                sum = number1 + number2;
                sign = "+";
            } else if (r == 1) { // r == 1일 경우 - 계산식
                sum = number1 - number2;
                sign = "-";
            } else if (r == 2) { // r == 2일 경우 * 계산식
                sum = number1 * number2;
                sign = "*";
            }

            Stage.second(number1, number2, characterHp, monsterHp, sign);

            timer = new Timer();  // Timer 인스턴스 새로 생성
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("입력 시간이 초과되었습니다.(정답을 써도 공격을 받습니다 !)");
                    isTimeout = true;  // 입력 시간 초과 상태를 true로 변경
                    synchronized (battleProgram.this) {
                        battleProgram.this.notify();  // 게임 루프를 대기 상태에서 깨웁니다.
                    }
                }
            };

            timer.schedule(task, 15000);  // 15초 후에 TimerTask 실행

            int inputNumber = 0;
            int attackCount = 3;

            for(int i = attackCount; i>0; i--){
                while (!sc.hasNextInt()) {
                    sc.next();
                    System.err.print("에러! 숫자가 아닙니다. \n재 입력 : ");
                }

                inputNumber = sc.nextInt();

                if (isTimeout) {
                    break;  // 입력 시간 초과일 경우 다음 루프로 건너뛰기
                }  // 입력 시간 초과일 경우 다음 루프로 건너뛰기

                else if (inputNumber != sum){
                    System.out.println("정답이 아닙니다 !");
                    System.out.printf("남은 기회 : %d\n", i-1);
                    System.out.printf("정답 입력 : ");
                }
                else{
                    break;
                }
            }

            task.cancel();  // TimerTask 취소
            if (isTimeout) {
                for (int j = 0; j < 100; j++) {
                    System.out.println("");
                    System.out.flush();
                }
                new Attack().monsterAttackAnimation(stage);
                characterHp--;
                isTimeout = false;  // 플래그 초기화
                continue;
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
        timer.cancel();

        if (monsterHp == 0) {
            Screen.gameVictory();
            return 1;
        } else if (characterHp == 0) {
            Screen.gameDefeat();
        }
        return 0;
    }

    // 3단계 프로그램 진행
    public int battleProgram3(int stage, int characterHp, int monsterHp) {
        sc = new Scanner(System.in);
        while (characterHp > 0 && monsterHp > 0) {
            Random random = new Random(); // 랜덤 함수 생성
            int attackEffectRandomNumber = (int) (Math.random() * 3) + 1;
            int number1 = (int) (Math.random() * 991) + 100; // 첫 번째 랜덤 숫자 저장
            int number2 = (int) (Math.random() * 991) + 100; // 두 번째 랜덤 숫자 저장

            int sum = 0; // 첫 번째 , 두 번째 숫자를 합할 변수 지정

            int r = random.nextInt(2); // 첫 번째 랜덤 숫자 저장

            if (r == 0) { // r == 0일 경우 + 계산식
                sum = number1 + number2;
                sign = "+";
            } else if (r == 1) { // r == 1일 경우 - 계산식
                sum = number1 - number2;
                sign = "-";
            }

            Stage.third(number1, number2, characterHp, monsterHp, sign);

            timer = new Timer();  // Timer 인스턴스 새로 생성
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("입력 시간이 초과되었습니다.(정답을 써도 공격을 받습니다 !)");
                    isTimeout = true;  // 입력 시간 초과 상태를 true로 변경
                    synchronized (battleProgram.this) {
                        battleProgram.this.notify();  // 게임 루프를 대기 상태에서 깨웁니다.
                    }
                }
            };

            timer.schedule(task, 20000);  // 20초 후에 TimerTask 실행

            int inputNumber = 0;
            int attackCount = 3;

            for(int i = attackCount; i>0; i--){
                while (!sc.hasNextInt()) {
                    sc.next();
                    System.err.print("에러! 숫자가 아닙니다. \n재 입력 : ");
                }

                inputNumber = sc.nextInt();

                if (isTimeout) {
                    break;  // 입력 시간 초과일 경우 다음 루프로 건너뛰기
                }  // 입력 시간 초과일 경우 다음 루프로 건너뛰기

                else if (inputNumber != sum){
                    System.out.println("정답이 아닙니다 !");
                    System.out.printf("남은 기회 : %d\n", i-1);
                    System.out.printf("정답 입력 : ");
                }
                else{
                    break;
                }
            }

            task.cancel();  // TimerTask 취소
            if (isTimeout) {
                for (int j = 0; j < 100; j++) {
                    System.out.println("");
                    System.out.flush();
                }
                new Attack().monsterAttackAnimation(stage);
                characterHp--;
                isTimeout = false;  // 플래그 초기화
                continue;
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
        timer.cancel();

        if (monsterHp == 0) {
            Screen.gameVictory();
            return 1;
        } else if (characterHp == 0) {
            Screen.gameDefeat();
        }
        return 0;
    }

    // 2단계 프로그램 진행
    public int battleProgram4(int stage, int characterHp, int monsterHp) {
        sc = new Scanner(System.in);
        while (characterHp > 0 && monsterHp > 0) {
            Random random = new Random(); // 랜덤 함수 생성
            int attackEffectRandomNumber = (int) (Math.random() * 3) + 1;
            int number1 = (int) (Math.random() * 991) + 100; // 첫 번째 랜덤 숫자 저장
            int number2 = (int) (Math.random() * 991) + 100; // 두 번째 랜덤 숫자 저장

            int sum = 0; // 첫 번째 , 두 번째 숫자를 합할 변수 지정

            int r = random.nextInt(3); // 첫 번째 랜덤 숫자 저장

            if (r == 0) { // r == 0일 경우 + 계산식
                sum = number1 + number2;
                sign = "+";
            } else if (r == 1) { // r == 1일 경우 - 계산식
                sum = number1 - number2;
                sign = "-";
            } else if (r == 2) { // r == 2일 경우 * 계산식
                sum = number1 * number2;
                sign = "*";
            }

            Stage.fourth(number1, number2, characterHp, monsterHp, sign);

            timer = new Timer();  // Timer 인스턴스 새로 생성
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("입력 시간이 초과되었습니다.(정답을 써도 공격을 받습니다 !)");
                    isTimeout = true;  // 입력 시간 초과 상태를 true로 변경
                    synchronized (battleProgram.this) {
                        battleProgram.this.notify();  // 게임 루프를 대기 상태에서 깨웁니다.
                    }
                }
            };

            timer.schedule(task, 25000);  // 25초 후에 TimerTask 실행

            int inputNumber = 0;
            int attackCount = 3;

            for(int i = attackCount; i>0; i--){
                while (!sc.hasNextInt()) {
                    sc.next();
                    System.err.print("에러! 숫자가 아닙니다. \n재 입력 : ");
                }

                inputNumber = sc.nextInt();

                if (isTimeout) {
                    break;  // 입력 시간 초과일 경우 다음 루프로 건너뛰기
                }  // 입력 시간 초과일 경우 다음 루프로 건너뛰기

                else if (inputNumber != sum){
                    System.out.println("정답이 아닙니다 !");
                    System.out.printf("남은 기회 : %d\n", i-1);
                    System.out.printf("정답 입력 : ");
                }
                else{
                    break;
                }
            }

            task.cancel();  // TimerTask 취소
            if (isTimeout) {
                for (int j = 0; j < 100; j++) {
                    System.out.println("");
                    System.out.flush();
                }
                new Attack().monsterAttackAnimation(stage);
                characterHp--;
                isTimeout = false;  // 플래그 초기화
                continue;
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
        timer.cancel();

        if (monsterHp == 0) {
            Screen.gameVictory();
            return 1;
        } else if (characterHp == 0) {
            Screen.gameDefeat();
        }
        return 0;
    }

    // 5단계 프로그램 진행
    public int battleProgram5(int stage, int characterHp, int monsterHp) {
        sc = new Scanner(System.in);
        while (characterHp > 0 && monsterHp > 0) {
            Random random = new Random(); // 랜덤 함수 생성
            int attackEffectRandomNumber = (int) (Math.random() * 3) + 1;
            int number1 = (int) (Math.random() * 9991) + 1000; // 첫 번째 랜덤 숫자 저장
            int number2 = (int) (Math.random() * 9991) + 1000; // 두 번째 랜덤 숫자 저장

            int sum = 0; // 첫 번째 , 두 번째 숫자를 합할 변수 지정

            int r = random.nextInt(2); // 첫 번째 랜덤 숫자 저장

            if (r == 0) { // r == 0일 경우 + 계산식
                sum = number1 + number2;
                sign = "+";
            } else if (r == 1) { // r == 1일 경우 - 계산식
                sum = number1 - number2;
                sign = "-";
            }

            Stage.fifth(number1, number2, characterHp, monsterHp, sign);

            timer = new Timer();  // Timer 인스턴스 새로 생성
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("입력 시간이 초과되었습니다.(정답을 써도 공격을 받습니다 !)");
                    isTimeout = true;  // 입력 시간 초과 상태를 true로 변경
                    synchronized (battleProgram.this) {
                        battleProgram.this.notify();  // 게임 루프를 대기 상태에서 깨웁니다.
                    }
                }
            };

            timer.schedule(task, 30000);  // 30초 후에 TimerTask 실행

            int inputNumber = 0;
            int attackCount = 3;

            for(int i = attackCount; i>0; i--){
                while (!sc.hasNextInt()) {
                    sc.next();
                    System.err.print("에러! 숫자가 아닙니다. \n재 입력 : ");
                }

                inputNumber = sc.nextInt();

                if (isTimeout) {
                    break;  // 입력 시간 초과일 경우 다음 루프로 건너뛰기
                }  // 입력 시간 초과일 경우 다음 루프로 건너뛰기

                else if (inputNumber != sum){
                    System.out.println("정답이 아닙니다 !");
                    System.out.printf("남은 기회 : %d\n", i-1);
                    System.out.printf("정답 입력 : ");
                }
                else{
                    break;
                }
            }

            task.cancel();  // TimerTask 취소
            if (isTimeout) {
                for (int j = 0; j < 100; j++) {
                    System.out.println("");
                    System.out.flush();
                }
                new Attack().monsterAttackAnimation(stage);
                characterHp--;
                isTimeout = false;  // 플래그 초기화
                continue;
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
        timer.cancel();

        if (monsterHp == 0) {
            Screen.gameVictory();
            return 1;
        } else if (characterHp == 0) {
            Screen.gameDefeat();
        }
        return 0;
    }

    // 6단계 프로그램 진행
    public int battleProgram6(int stage, int characterHp, int monsterHp) {
        sc = new Scanner(System.in);
        while (characterHp > 0 && monsterHp > 0) {
            Random random = new Random(); // 랜덤 함수 생성
            int attackEffectRandomNumber = (int) (Math.random() * 3) + 1;
            int number1 = (int) (Math.random() * 9991) + 100; // 첫 번째 랜덤 숫자 저장
            int number2 = (int) (Math.random() * 9991) + 100; // 두 번째 랜덤 숫자 저장

            int sum = 0; // 첫 번째 , 두 번째 숫자를 합할 변수 지정

            int r = random.nextInt(3); // 첫 번째 랜덤 숫자 저장

            if (r == 0) { // r == 0일 경우 + 계산식
                sum = number1 + number2;
                sign = "+";
            } else if (r == 1) { // r == 1일 경우 - 계산식
                sum = number1 - number2;
                sign = "-";
            } else if (r == 2) { // r == 2일 경우 * 계산식
                sum = number1 * number2;
                sign = "*";
            }

            Stage.sixth(number1, number2, characterHp, monsterHp, sign);

            timer = new Timer();  // Timer 인스턴스 새로 생성
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("입력 시간이 초과되었습니다.(정답을 써도 공격을 받습니다 !)");
                    isTimeout = true;  // 입력 시간 초과 상태를 true로 변경
                    synchronized (battleProgram.this) {
                        battleProgram.this.notify();  // 게임 루프를 대기 상태에서 깨웁니다.
                    }
                }
            };

            timer.schedule(task, 35000);  // 35초 후에 TimerTask 실행

            int inputNumber = 0;
            int attackCount = 3;

            for(int i = attackCount; i>0; i--){
                while (!sc.hasNextInt()) {
                    sc.next();
                    System.err.print("에러! 숫자가 아닙니다. \n재 입력 : ");
                }

                inputNumber = sc.nextInt();

                if (isTimeout) {
                    break;  // 입력 시간 초과일 경우 다음 루프로 건너뛰기
                }  // 입력 시간 초과일 경우 다음 루프로 건너뛰기

                else if (inputNumber != sum){
                    System.out.println("정답이 아닙니다 !");
                    System.out.printf("남은 기회 : %d\n", i-1);
                    System.out.printf("정답 입력 : ");
                }
                else{
                    break;
                }
            }

            task.cancel();  // TimerTask 취소
            if (isTimeout) {
                for (int j = 0; j < 100; j++) {
                    System.out.println("");
                    System.out.flush();
                }
                new Attack().monsterAttackAnimation(stage);
                characterHp--;
                isTimeout = false;  // 플래그 초기화
                continue;
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
        timer.cancel();

        if (monsterHp == 0) {
            Screen.gameVictory();
            return 1;
        } else if (characterHp == 0) {
            Screen.gameDefeat();
        }
        return 0;
    }
}


