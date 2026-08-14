package model.dto;

public class BoardDto {
    private int b_no;
    private String b_content;
    private String b_writer;

    public BoardDto(){}
    public BoardDto(int b_no, String b_content, String b_writer){
        this.b_no = b_no;
        this.b_content = b_content;
        this.b_writer = b_writer;
    }

    public int getB_no(){
        return b_no;
    }
    public void setB_no(int b_no){
        this.b_no = b_no;
    }
    public String getB_content(){
        return b_content;
    }
    public void setB_content(String b_content){
        this.b_content = b_content;
    }
    public String getB_writer(){
        return b_writer;
    }
    public void setB_writer(String b_writer){
        this.b_writer = b_writer;
    }
    @Override 
    public String toString(){
        return "BoardDto [b_no = " + b_no + ", b_content="+ b_content +", b_writer=" + b_writer + "]";
    }
}
