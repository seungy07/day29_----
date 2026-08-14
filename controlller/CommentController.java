package controlller;

import model.dto.CommentDto;
import model.dao.CommentDao;
import java.util.ArrayList;

public class CommentController {
    private CommentController(){}
    private static final CommentController instance = new CommentController();
    public static CommentController getInstance(){return instance;}

    private CommentDao cd = CommentDao.getInstance();

    // 등록
    public boolean c_save(CommentDto commentdto){
        boolean r = cd.c_save(commentdto);
        return r;
    }

    // 출력
    public ArrayList<CommentDto> c_findAll(){
        ArrayList<CommentDto> result = cd.c_findAll();
        return result;
    }
    

    // 수정 

    // 삭제
    
}
