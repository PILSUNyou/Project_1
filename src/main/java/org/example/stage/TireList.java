package org.example.stage;

public class TireList {
    public static Object tire(int tire) {
        if (tire == 0){
            return "브론즈";
        }
        else if (tire == 1){
            return "실버";
        }
        else if (tire == 2){
            return "골드";
        }
        else if (tire == 3){
            return "플래티넘";
        }
        else if (tire == 4){
            return "다이아몬드";
        }
        else if (tire == 5){
            return "마스터";
        }
        return null;
    }
}
