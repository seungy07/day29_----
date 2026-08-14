package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controlller.BoardController;
import model.dto.BoardDto;

public class BoardView {
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){return instance;}
    private BoardController bc = BoardController.getInstance();
    private Scanner scan = new Scanner(System.in);

    // 게시글 or 댓글 선택 부분
    public void run(){
        while(true){
            System.out.println("===================");
            System.out.println("1. 게시물  2. 댓글 ");
            System.out.println("===================");
            System.out.print("번호 선택: ");
            int ch = scan.nextInt();
            if(ch==1){b_run();}
            else if(ch==2){ CommentView.getInstance().c_run(); }
        }
    }

    public void b_run(){
        while( true ){
            try{
                 System.out.println("================게시물============= ");
                System.out.println("1.등록 | 2.조회 | 3. 수정 | 4.삭제 | 5. 이전 ");
                System.out.println("================================= ");
                System.out.print("번호 선택> ");
                int b_ch = scan.nextInt();
                if( b_ch ==1 ){ b_save();}
                else if( b_ch == 2 ){b_findAll();}
                else if( b_ch == 3 ){b_update();}
                else if( b_ch == 4 ){b_delete();}
                else if( b_ch == 5){ run();}

            }catch( InputMismatchException e){
                scan = new Scanner(System.in);
                System.out.println("다시 입력"+e);
            }
        }
    }
    
    public void b_save(){
        System.out.print("게시물 내용 : "); String b_content = scan.next();
        System.out.print("게시물 작성자: "); String b_writer = scan.next();
        BoardDto boardDto = new BoardDto(0, b_content , b_writer);
        boolean result = bc.b_save( boardDto );
        if(result){System.out.println(">게시물 등록 성공");}
        else{System.out.println(">게시물 등록 실패");}
    }
    
    public void b_findAll(){
        ArrayList<BoardDto> result = bc.b_findAll();
        for( BoardDto bdto : result ){
            System.out.println( bdto.getB_no()+ "/" + bdto.getB_writer() + "/" +bdto.getB_content());
        }
    }

    public void b_update(){
        System.out.print("수정할 게시물 번호: ");   int b_no = scan.nextInt();
        System.out.print("수정할 게시물 내용: ");   String b_content = scan.next();
        BoardDto boardDto = new BoardDto(b_no, b_content ,null);
        boolean result = bc.b_update(boardDto);
        if( result ){System.out.println(">게시물 수정 성공");}
        else{System.out.println(">게시물 수정 실패(없는 번호)");}
    }
    public void b_delete(){
        System.out.print("삭제할 게시물 번호: ");   int b_no = scan.nextInt();
        boolean result = bc.b_delete(b_no);
        if(result){System.out.println(">게시물 삭제 성공");}
        else{System.out.println(">게시물 삭제 실패(없는 번호)");}
    }



}
