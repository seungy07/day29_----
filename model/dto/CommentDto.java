package model.dto;

public class CommentDto {
    private int b_no;
    private int c_no;
    private String c_content;
    private String c_writer;

    public CommentDto(){}

    public CommentDto(int b_no, int c_no, String c_content, String c_writer) {
        this.b_no = b_no;
        this.c_no = c_no;
        this.c_content = c_content;
        this.c_writer = c_writer;
    }

    public int getB_no() {
        return b_no;
    }

    public void setB_no(int b_no) {
        this.b_no = b_no;
    }

    public int getC_no() {
        return c_no;
    }

    public void setC_no(int c_no) {
        this.c_no = c_no;
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
    }

    public String getC_writer() {
        return c_writer;
    }

    public void setC_writer(String c_writer) {
        this.c_writer = c_writer;
    }
 
    

    

    
}
