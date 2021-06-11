package com.toy.sy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class User {

    @Pattern(regexp = "^[a-z]{8,}$", message = "소문자 영어만 가능(8글자)")
    private String ID;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,12}", message = " 영문 소문자/대문자/특수문자 포함(8글자 이상 12글자 이내)")
    private String PASSWORD;

    @Pattern(regexp = "(010)-[\\d]{3,4}-[\\d]{4}", message = "전화번호를 입력하세요.")
    private String TELL;

    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", message = "이메일을 입력하세요.")
    private String EMAIL;

    private String IS_DEL;




}

