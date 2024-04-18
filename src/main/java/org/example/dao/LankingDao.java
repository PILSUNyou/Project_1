package org.example.dao;

import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Lanking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LankingDao extends Dao{
    private DBConnection dbConnection;

    public LankingDao(){
        dbConnection = Container.getDBConnection();
    }

    public List<Lanking> getLankings() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * "));
        sb.append(String.format("FROM lanking "));
        sb.append(String.format("ORDER BY tire DESC "));

        List<Lanking> lankings = new ArrayList<>();
        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows){
            lankings.add(new Lanking((row)));
        }

        return lankings;
    }
}
