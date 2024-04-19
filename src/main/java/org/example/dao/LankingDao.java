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

    public int putInLanking(Lanking lanking) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("INSERT INTO lanking "));
        sb.append(String.format("SET regDate = NOW(), "));
        sb.append(String.format("nickName = '%s', ", lanking.nickName));
        sb.append(String.format("tire = %d ", lanking.tire));

        return dbConnection.insert(sb.toString());
    }

    public boolean getForPrintLankingName(String nickName) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * "));
        sb.append(String.format("FROM lanking "));
        sb.append(String.format("WHERE lanking.nickName = '%s' ", nickName));

        Map<String, Object> row = dbConnection.selectRow(sb.toString());

        if ( row.isEmpty() ) {
            return false;
        }

        return true;
    }

    public Lanking getForPrintLankingTire(String nickName) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * "));
        sb.append(String.format("FROM lanking "));
        sb.append(String.format("WHERE lanking.nickName = '%s' ", nickName));

        Map<String, Object> row = dbConnection.selectRow(sb.toString());

        if ( row.isEmpty() ) {
            return null;
        }

        return new Lanking(row);
    }

    public int updateLankingTire(String nickName, int tire) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("UPDATE lanking "));
        sb.append(String.format("SET tire = %d, ", tire));
        sb.append(String.format("regDate = NOW() "));
        sb.append(String.format("WHERE nickName = '%s' ", nickName));

        return dbConnection.update(sb.toString());
    }
}