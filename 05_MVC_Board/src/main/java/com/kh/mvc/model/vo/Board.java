package com.kh.mvc.model.vo;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//NO NUMBER,
//TITLE VARCHAR2(200) NOT NULL,
//CONTENT VARCHAR2(2000) NOT NULL,
//WRITER VARCHAR2(50) NOT NULL,
//REGDATE DATE DEFAULT SYSDATE

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private int num;
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
}
