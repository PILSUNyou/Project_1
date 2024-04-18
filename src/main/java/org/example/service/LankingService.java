package org.example.service;

import org.example.container.Container;
import org.example.dao.LankingDao;
import org.example.dto.Lanking;

import java.util.List;

public class LankingService {
    private LankingDao lankingDao;

    public LankingService(){
        lankingDao = Container.lankingDao;
    }

    public List<Lanking> getLanking(){
        return lankingDao.getLankings();
    }
}
