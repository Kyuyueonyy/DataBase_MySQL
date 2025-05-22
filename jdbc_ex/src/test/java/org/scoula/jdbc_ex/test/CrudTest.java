package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudTest {
    Connection conn = JDBCUtil.getConnection();

    @AfterAll // 아래 메서드 다 호출하고 나서 한번만 실행하는 기능을 넣을 때
    static void tearDown() throws SQLException {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void insertUser() throws SQLException {
        //3단계 - sql문 객체 생성
        String sql = "insert into users(id, password, name, role) values(?, ?, ?, ?)";
        //?연산자는 가입할 사람이 어떤 데이터를 넣을지 모르기 때문에 그 자리에 ?로 설정함
        //?는 번호가 있음 :  1번 물음표, 2번 물음표... 이렇게 순서대로 번호가 있음.
        //?, ?, ?, ? --> 4번까지 있음
        //1번 2번 3번 4번 물음표가 되는 것
        //1번 ?에 id넣고, 2번 ?에 password 넣고 이런식으로!
        //http://www.naver.com --> 사람(url), java(string)
        //URL url = new URL("http://www.naver.com"); --> java(url) 인식함
        //sql도 url처럼 해당하는 부품이 있음
        //Statement(문장), PreparedStatement(준비된 문장)
        PreparedStatement pstmt = conn.prepareStatement(sql);
        System.out.println("3단계 : sql문 객체로 만들기 성공!");

        pstmt.setString(1, "gunja"); //id를 넣음
        pstmt.setString(2, "1234"); //password를 넣음
        pstmt.setString(3, "kyuyeon"); //name을 넣음
        pstmt.setString(4, "1"); //role을 넣음

        //4단계 - sql문 db서버로 전송하고 뒷처리
        int count = pstmt.executeUpdate(); //insert문을 보내고 결과를 받아오는 메서드
        //insert문의 결과는 실행된 row수
        System.out.println("실행될 row수 " + count);
        Assertions.assertEquals(0, count);
        pstmt.close();
    }
}
