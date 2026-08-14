package model.dao;

public class BoardDao {
    private BoardDao(){}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){return instance;}
}
