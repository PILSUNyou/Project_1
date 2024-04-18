package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Lanking extends Dto{
    public String nickName;
    public int tire;

    public Lanking(Map<String, Object> row) {
        super(row);
        this.nickName = (String) row.get("nickName");
        this.tire = (Integer) row.get("tire");
    }
}
