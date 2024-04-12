package org.example.stage;

public class Monster {
    public static Object hp(int monsterHp) {
        if (monsterHp == 1){
            return "♥  ♡  ♡  ♡  ♡";
        }
        else if (monsterHp == 2){
            return "♥  ♥  ♡  ♡  ♡";
        }
        else if (monsterHp == 3){
            return "♥  ♥  ♥  ♡  ♡";
        }
        else if (monsterHp == 4){
            return "♥  ♥  ♥  ♥  ♡";
        }
        else if (monsterHp == 5){
            return "♥  ♥  ♥  ♥  ♥";
        }
        return null;
    }
}
