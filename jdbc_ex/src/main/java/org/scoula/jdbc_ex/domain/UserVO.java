package org.scoula.jdbc_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* VO(Value Object)
* - 데이터를 담는 객체
* - 하나의 도메인 데이터를 표현하기 위한 객체
* - 주로 DB 테이블의 한 행을 자바 객체로 표현
*
* DTO(Data Transfer Object)
* - 계층 간 데이터 전달을 위해 사용하는 객체
* ex) 네트워크나 외부 API로 데이터 전송할 때 사용
* - 경우에 따라 여러 VO의 필드를 조합하기도 함.*/
@Data //get, set, toString 모두 만들어줌
@NoArgsConstructor //모든 생성자 생성
@AllArgsConstructor

public class UserVO {
    //자바에서 가방(클래스)에 들어있는 데이터를 나중에 넣거나 꺼냈을 때
    //다시 자바에 넣거나 할 때 사용할 가방 역할의 클래스
    //VO의 RDB의 테이블(엔터티)마다 하나씩 만들어줌
    //VO의 변수는 테이블의 컬럼과 동일한 이름으로 만들어줌

    //값 넣을때는 get메서드, 꺼낼때는 set메서드!
    private String id;
    private String password;
    private String name;
    private String role;

    //가방(클래스) 의 각 필드에 값을 넣을때는 set~() 메서드 사용
    //가방(클래스)의 각 필드에서 값을 꺼낼 떄는 get~() 메서드 사용
    // 롬복 라이브러리 사용!
}
