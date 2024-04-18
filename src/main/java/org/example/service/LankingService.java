package org.example.service;

import org.example.dao.LankingDao;
import org.example.dto.Lanking;

import java.util.List;

public class LankingService {

    public List<Lanking> getLankings(){
        return new LankingDao().getLankings();
    }
}
