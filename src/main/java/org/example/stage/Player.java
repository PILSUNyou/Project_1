package org.example.stage;

public class Player {

    public static Object hp(int characterHp) {
        if (characterHp == 1){
            return "♥  ♡  ♡  ♡  ♡";
        }
        else if (characterHp == 2){
            return "♥  ♥  ♡  ♡  ♡";
        }
        else if (characterHp == 3){
            return "♥  ♥  ♥  ♡  ♡";
        }
        else if (characterHp == 4){
            return "♥  ♥  ♥  ♥  ♡";
        }
        else if (characterHp == 5){
            return "♥  ♥  ♥  ♥  ♥";
        }
      return null;
    }
}
