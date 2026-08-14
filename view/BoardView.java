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

    public void run(){
        while( true ){
            try{
                System.out.println("1.게시물 등록 2.게시물 전체조회 3.게시물 전체수정 4.게시물 개별삭제 선택:");
                int ch = scan.nextInt();
                if( ch ==1 ){ b_save();}
                else if( ch == 2 ){}
                else if( ch == 3 ){}
                else if( ch == 4 ){}

            }catch( InputMismatchException e){
                scan = new Scanner(System.in);
                System.out.println("다시입력"+e);
            }
        }
    }
    
    public void b_save(){
        System.out.print("게시물 내용 : "); String 게시물내용 = scan.next();
        System.out.print("게시물 작성자"); String 게시물작성자 = scan.next();
        BoardDto boardDto = new BoardDto(0, 게시물내용 , 게시물작성자);
        boolean result = bc.b_save( boardDto );
        if(result){System.out.println(">게시물 등록 성공");}
        else{System.out.println(">게시물 등록 실패");}
    }
    
    public void b_findAll(){
        ArrayList<BoardDto> result = bc.b_findAll();
        for( BoardDto dto : result ){
            System.out.println( dto.getB_no()+ "/" + dto.getB_writer() + "/" +dto.getB_content());
        }
    }

    public void b_update(){
        System.out.print("수정할 게시물 번호: ");   int 수정할게시물번호 = scan.nextInt();
        System.out.print("수정할 게시물 내용: ");   String 수정할게시물내용 = scan.next();
        BoardDto boardDto = new BoardDto(수정할게시물번호, 수정할게시물내용 ,null);
        boolean result = bc.b_update(boardDto);
        if( result ){System.out.println(">게시물 수정 성공");}
        else{System.out.println(">게시물 수정 실패(없는 번호)");}
    }
    public void b_delete(){
        System.out.print("삭제할 게시물 번호: ");   int 삭제할게시물번호 = scan.nextInt();
        boolean result = bc.b_delete(삭제할게시물번호);
        if(result){System.out.println(">게시물 삭제 성공");}
        else{System.out.println(">게시물 삭제 실패(없는 번호)");}
    }



}
