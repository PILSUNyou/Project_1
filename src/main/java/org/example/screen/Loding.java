package org.example.screen;

public class Loding {
    private String type;//생성자에 어떤 공격효과메소드를 불러올지 정하기 위한 변수
    public Loding(String type) { //생성자에 입력된 타입에 따라 공격 효과 메소드가 결정됨
//        this.type=type;

    }
    //---------------플레이어 공격 효과--------------------------------------------
    public static void lodingScreen() {
        String[] lodingImages = new String[6];
        lodingImages[0] =
                " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\          _                _  _                           /\\_/\\ \n" +
                        "( o.o )        | |     ___    __| |(_) _ __    __ _            ( o.o )\n" +
                        " > ^ <         | |    / _ \\  / _` || || '_ \\  / _` |            > ^ < \n" +
                        " /\\_/\\         | |___| (_) || (_| || || | | || (_| |  _         /\\_/\\ \n" +
                        "( o.o )        |_____|\\___/  \\__,_||_||_| |_| \\__, | (_)       ( o.o )\n" +
                        " > ^ <                                        |___/             > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < ";

        lodingImages[1] =
                " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\        _                _  _                             /\\_/\\ \n" +
                        "( o.o )      | |     ___    __| |(_) _ __    __ _              ( o.o )\n" +
                        " > ^ <       | |    / _ \\  / _` || || '_ \\  / _` |              > ^ < \n" +
                        " /\\_/\\       | |___| (_) || (_| || || | | || (_| |  _  _        /\\_/\\ \n" +
                        "( o.o )      |_____|\\___/  \\__,_||_||_| |_| \\__, | (_)(_)      ( o.o )\n" +
                        " > ^ <                                      |___/               > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < ";

        lodingImages[2] =
                " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\       _                _  _                              /\\_/\\ \n" +
                        "( o.o )     | |     ___    __| |(_) _ __    __ _               ( o.o )\n" +
                        " > ^ <      | |    / _ \\  / _` || || '_ \\  / _` |               > ^ < \n" +
                        " /\\_/\\      | |___| (_) || (_| || || | | || (_| |  _  _  _      /\\_/\\ \n" +
                        "( o.o )     |_____|\\___/  \\__,_||_||_| |_| \\__, | (_)(_)(_)    ( o.o )\n" +
                        " > ^ <                                     |___/                > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < ";

        lodingImages[3] =
                " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\          _                _  _                           /\\_/\\ \n" +
                        "( o.o )        | |     ___    __| |(_) _ __    __ _            ( o.o )\n" +
                        " > ^ <         | |    / _ \\  / _` || || '_ \\  / _` |            > ^ < \n" +
                        " /\\_/\\         | |___| (_) || (_| || || | | || (_| |  _         /\\_/\\ \n" +
                        "( o.o )        |_____|\\___/  \\__,_||_||_| |_| \\__, | (_)       ( o.o )\n" +
                        " > ^ <                                        |___/             > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < ";

        lodingImages[4] =
                " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\        _                _  _                             /\\_/\\ \n" +
                        "( o.o )      | |     ___    __| |(_) _ __    __ _              ( o.o )\n" +
                        " > ^ <       | |    / _ \\  / _` || || '_ \\  / _` |              > ^ < \n" +
                        " /\\_/\\       | |___| (_) || (_| || || | | || (_| |  _  _        /\\_/\\ \n" +
                        "( o.o )      |_____|\\___/  \\__,_||_||_| |_| \\__, | (_)(_)      ( o.o )\n" +
                        " > ^ <                                      |___/               > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < ";

        lodingImages[5] =
                " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\       _                _  _                              /\\_/\\ \n" +
                        "( o.o )     | |     ___    __| |(_) _ __    __ _               ( o.o )\n" +
                        " > ^ <      | |    / _ \\  / _` || || '_ \\  / _` |               > ^ < \n" +
                        " /\\_/\\      | |___| (_) || (_| || || | | || (_| |  _  _  _      /\\_/\\ \n" +
                        "( o.o )     |_____|\\___/  \\__,_||_||_| |_| \\__, | (_)(_)(_)    ( o.o )\n" +
                        " > ^ <                                     |___/                > ^ < \n" +
                        " /\\_/\\                                                          /\\_/\\ \n" +
                        "( o.o )                                                        ( o.o )\n" +
                        " > ^ <                                                          > ^ < \n" +
                        " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n" +
                        "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n" +
                        " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < ";
        for (int i = 0; i < 100; i++) {
            System.out.println("");
            System.out.flush();
        }
        for (int i = 0; i < lodingImages.length; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.println("");
                System.out.flush();
            }
            System.out.println(lodingImages[i]);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {

            }

        }
    }
}
