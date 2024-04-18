package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Lanking extends Dto{
    public String nickName;
    public String tire;

    public Lanking(int id,String ragDate, String nickName, String tire){
        super(id, ragDate);
        this.nickName = nickName;
        this.tire = tire;
    }
    public Lanking(Map<String, Object> row) {
        super(row);
        this.nickName = (String) row.get("nickName");
        this.tire = (String) row.get("tire");
    }
}
