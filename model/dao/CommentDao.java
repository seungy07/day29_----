package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dto.CommentDto;


public class CommentDao {
    private CommentDao(){}
    private static final CommentDao instance = new CommentDao();
    public static CommentDao getInstance(){return instance;}

    // 등록
    public boolean c_save(CommentDto commentdto){
        try{
            String sql = "insert into comment(b_no, c_content, c_writer) values(?, ?, ?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1, commentdto.getB_no());
            ps.setString(2, commentdto.getC_content());
            ps.setString(3, commentdto.getC_writer());
            int count = ps.executeUpdate();
            if(count >= 1){ return true; }
        }catch(SQLException e){ System.out.println(e); }
        return false;
    }
   
    // 출력

    // 수정

    // 삭제


    
}
