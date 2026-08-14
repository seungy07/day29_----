package controlller;

import model.dao.BoardDao;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){ return instance;}
    private BoardDao bd = BoardDao.getInstance();  

    public boolean b_save
}
