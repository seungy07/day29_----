package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.BoardDto;

public class BoardDao extends BaseDao {
    private BoardDao(){}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){ return instance; }

    public boolean b_save( BoardDto boardDto ){
        try{
            String sql = "insert into board(b_content,b_writer) values( ? , ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getB_content());
            ps.setString(2,boardDto.getB_writer());
            int result = ps.executeUpdate();
            if( result == 1 ) return true;
        } catch ( SQLException e ){ System.out.println( e );}
        return false;
    }

    public ArrayList<BoardDto>b_findAll(){
        ArrayList<BoardDto> list = new ArrayList<>();
        try{
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BoardDto boardDto = new BoardDto();
                boardDto.setB_no(rs.getInt("b_no"));
                boardDto.setB_content(rs.getString("b_content"));
                boardDto.setB_writer(rs.getString("b_writer"));
                list.add(boardDto);
            }
        }catch(SQLException e ){System.out.println(e);}
        return list;
    }
    public boolean b_update(BoardDto boardDto){
        try{String sql = "b_update board setB_content = ? where b_no = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, boardDto.getB_content());
        ps.setInt(2, boardDto.getB_no());
        int result = ps.executeUpdate();
        if( result == 1) return true;
        }catch(SQLException e){ System.out.println(e);}
        return false;
    }
    public boolean b_delete(int b_no){
        try{ String sql = "b_delete from board where b_no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,b_no);
            int result = ps.executeUpdate();
            if( result == 1) return true;
        }catch(SQLException e){System.out.println(e);}
        return false;
    }
}



