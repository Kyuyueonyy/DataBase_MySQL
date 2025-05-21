package org.scoula.jdbc_ex.common;

import java.sql.Connection;

public class JDBCUtil {
    //1. 드라이버 설정
    //2. db 연결 이용해서 연결하는 것까지
    //-> Connection con; <-- con을 리턴

    static Connection conn = null;
    public static Connection getConnection(){
        if(conn != null) return conn; //이미 만들어져 있으면 그걸 리턴

        try{

        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}