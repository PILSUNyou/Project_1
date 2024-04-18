package org.example.container;

import org.example.controller.LankingController;
import org.example.controller.Session;
import org.example.dao.LankingDao;
import org.example.dao.MemberDao;
import org.example.db.DBConnection;
import org.example.service.LankingService;
import org.example.service.MemberService;

import java.util.Scanner;

public class Container {
    public static Scanner sc;
    public static Session session;
    public static DBConnection dbConnection;
    public static MemberDao memberDao;
    public static MemberService memberService;
    public static LankingDao lankingDao;
    public static LankingService lankingService;

    static {
        memberDao = new MemberDao();
        memberService = new MemberService();
        lankingService = new LankingService();
        lankingDao = new LankingDao();
    }

    public static Scanner getScanner() {
        if ( sc == null ) {
            sc = new Scanner(System.in);
        }

        return sc;
    }

    public static DBConnection getDBConnection() {
        if ( dbConnection == null ) {
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }

    public static Session getSession() {
        if ( session == null ) {
            session = new Session();
        }

        return session;
    }
}
