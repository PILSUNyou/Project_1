package org.example.dao;

import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Lanking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LankingDao {
    private List<Lanking> lankings;
    private DBConnection dbConnection;

    public LankingDao(){
        lankings = new ArrayList<>();
        dbConnection = Container.getDBConnection();
    }

    public List<Lanking> getLankings() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * FROM lanking "));

        List<Lanking> lankings = new ArrayList<>();
        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows){
            lankings.add(new Lanking((row)));
        }

        return lankings;
    }
}
