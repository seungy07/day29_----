package controlller;


import model.dao.CommentDao;

public class CommentController {
    private CommentController(){}
    private static final CommentController instance = new CommentController();
    private CommentController getInstance(){return instance;}

    private CommentDao cd = CommentDao.getInstance();
    
}
