package org.example.service;

import org.example.dao.LankingDao;
import org.example.dto.Lanking;

import java.util.List;

public class LankingService {

    public List<Lanking> getLankings(){
        return new LankingDao().getLankings();
    }

    public int putInLanking(Lanking lanking) {
        return new LankingDao().putInLanking(lanking);
    }

    public boolean getForPrintLankingName(String nickName) {
        return new LankingDao().getForPrintLankingName(nickName);
    }

    public Lanking getForPrintLankingTire(String nickName) {
        return new LankingDao().getForPrintLankingTire(nickName);
    }

    public void updateLankingTire(String nickName, int tire) {
        new LankingDao().updateLankingTire(nickName, tire);
    }

    public void updateMemberTire(String nickName, int tire) {
        new LankingDao().updateMemberTire(nickName, tire);
    }
}
