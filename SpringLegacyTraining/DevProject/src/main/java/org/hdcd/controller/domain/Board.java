package org.hdcd.controller.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Board {

    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;

}
