package controlller;

import java.util.ArrayList;

import model.dao.BoardDao;
import model.dto.BoardDto;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){ return instance;}
    private BoardDao bd = BoardDao.getInstance();  

    public boolean b_save(BoardDto boardDto){
        boolean result = bd.b_save(boardDto);
        return result;
    }

    public ArrayList<BoardDto> b_findAll(){
        ArrayList<BoardDto> result = bd.b_findAll();
        return result;
    }

    public boolean b_update(BoardDto boardDto){
        return bd.b_update(boardDto);
    }

    public boolean b_delete(int b_no ){
        return bd.b_delete(b_no);
    }
}
