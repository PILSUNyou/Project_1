package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Member extends Dto {
    public String loginId;
    public String loginPw;
    public String nickName;

    public Member (String loginId, String loginPw, String nickName){
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.nickName = nickName;
    }
    public Member (Map<String, Object> row){
        super(row);
        this.loginId = (String) row.get("loginId");
        this.loginPw = (String) row.get("loginPw");
        this.nickName = (String) row.get("nickName");
    }
}
