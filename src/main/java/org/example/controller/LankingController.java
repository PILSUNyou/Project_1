package org.example.controller;

import org.example.container.Container;
import org.example.dto.Lanking;
import org.example.service.LankingService;


import java.util.List;
import java.util.Scanner;

public class LankingController {
    private LankingService lankingService;
    private Session session;

    public LankingController() {
        lankingService = Container.lankingService;
        session = Container.getSession();
    }

    public void showLanking() {
       List<Lanking> forPrintLankings = lankingService.getLanking();

       if (forPrintLankings.size() == 0){
           System.out.println("현재 랭킹에 등록되어 있는 유저가 없습니다.");
           return;
       }

       System.out.println("번호  |  클리어 날짜  |  닉네임  |  등급  ");
       for (int i = forPrintLankings.size() - 1; i >= 0; i--) {
                Lanking lankings = forPrintLankings.get(i);

                System.out.printf("%d  |  %s  |  %s  |  %s  |\n", lankings.id, lankings.regDate, lankings.nickName, lankings.tire);
            }
    }
}
