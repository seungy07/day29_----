package view;

import controlller.CommentController;

public class CommentView {
    private CommentView(){}
    private static final CommentView instance = new CommentView();
    public static CommentView getInstance(){return instance;}
    
    private CommentController cc = CommentController.getInstance();





        

}
