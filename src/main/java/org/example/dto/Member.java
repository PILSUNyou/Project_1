package org.example.dto;

public class Member extends Dto {
    public String loginId;
    public String loginPw;
    public String nickName;

    public Member(int id, String regDate, String loginId, String loginPw, String nickName) {
        super.id = id;
        super.regDate = regDate;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.nickName = nickName;
    }
}
