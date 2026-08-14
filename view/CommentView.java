package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controlller.CommentController;
import model.dto.CommentDto;

public class CommentView {
    private CommentView(){}
    private static final CommentView instance = new CommentView();
    public static CommentView getInstance(){return instance;}
    
    private CommentController cc = CommentController.getInstance();

    private Scanner scan = new Scanner(System.in);

    // 댓글 선택시 실행 화면
    public void c_run(){
        while( true ){
            try{ 
                System.out.println("================댓글============= ");
                System.out.println("1.등록 | 2.조회 | 3. 수정 | 4.삭제 ");
                System.out.println("================================= ");
                System.out.print("번호 선택> ");
                int c_ch = scan.nextInt();
                if(c_ch==1){c_save();}
                else if(c_ch==2){c_findAll();}
                else if(c_ch==3){}
                else if(c_ch==4){}
            }catch( InputMismatchException e){
                scan = new Scanner(System.in);
                System.out.println("정수만 입력" + e);
            }
        }
    }

    // 등록
    public void c_save(){
        System.out.print("댓글 작성할 게시물 번호: ");  int b_no = scan.nextInt();
        System.out.print("댓글 내용: "); String c_content = scan.next();
        System.out.print("댓글 작성자: "); String c_writer = scan.next();
        CommentDto commentdto = new CommentDto( b_no, 0 ,c_content,c_writer);
        boolean r = cc.c_save(commentdto);
        if(r){System.out.println("댓글 등록 성공.");}else{System.out.println("댓글 등록실패.");}
    }

    // 조회 
    public void c_findAll(){
        ArrayList<CommentDto> result = cc.c_findAll();
        for(CommentDto cdto : result){
            System.out.println("=============================");
            System.out.println("게시물 번호: " + cdto.getB_no() +"\n작성자: " + cdto.getC_writer()+ "\n내용: " + cdto.getC_content());
        }
    }
    
    
    // 수정
    

    // 삭제





        

}
