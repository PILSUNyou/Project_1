package org.example.screen;

public class Rool {
    public static void run() {
        String[] openingScript= {"========================   게임 방법   ========================"};
        for(int i=0; i<openingScript.length; i++ ) {
            System.out.print(openingScript[i]);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("");

        String[] openingScript2= {"1","."," 상대방이 내는 문제를"," 제한 시간안에", " 입력하면 됩니다."};
        System.out.print("            ");
        for(int i=0; i<openingScript2.length; i++ ) {
            System.out.print(openingScript2[i]);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("");


        String[] openingScript3= {"2","."," 제한 시간안에", " 풀지 못했거나,", "정답을 3번 틀릴경우"," 자신의 HP가 소모되니 주의하세요."};
        System.out.print("            ");
        for(int i=0; i<openingScript3.length; i++ ) {
            System.out.print(openingScript3[i]);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("");

        String[] openingScript4= {"3","."," 몬스터의 HP를", " 전부 깎으면 승리 !"};
        System.out.print("            ");
        for(int i=0; i<openingScript4.length; i++ ) {
            System.out.print(openingScript4[i]);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("");
        String[] openingScript5= {"4","."," 자신의 HP가", " 전부 소모될 경우 패배 !","\n","=================   그럼 게임을 시작하겠습니다 !  =================","\n"};
        System.out.print("            ");
        for(int i=0; i<openingScript5.length; i++ ) {
            System.out.print(openingScript5[i]);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.print("");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

