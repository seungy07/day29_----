package model.dao;

public class CommentDao {
    private CommentDao(){}
    private static final CommentDao instance = new CommentDao();
    public static CommentDao getInstance(){return instance;}

    
    
}
