package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.CommentDto;
import java.sql.ResultSet;

public class CommentDao extends BaseDao {
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
    public ArrayList<CommentDto> c_findAll(){
        ArrayList<CommentDto> list = new ArrayList<>();
        try{
            String sql = "select * from comment";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next()){
                CommentDto commentdto = new CommentDto();
                commentdto.setB_no( rs.getInt("b_no"));
                commentdto.setC_content( rs.getString("c_content"));
                commentdto.setC_writer( rs.getString("c_writer"));
                list.add(commentdto);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }

    // 수정

    // 삭제


    
}
