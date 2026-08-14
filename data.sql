DROP DATABASE if EXISTS DB_day0817;
CREATE DATABASE DB_day0817;
USE DB_day0817;

-- 게시글 테이블
CREATE TABLE board(
    b_no INT AUTO_INCREMENT,
    b_content VARCHAR(255),
    b_writer VARCHAR(30),
    CONSTRAINT PRIMARY KEY (b_no)
);

-- 댓글 테이블
CREATE TABLE comment(
    c_no INT AUTO_INCREMENT,
    b_no INT,
    c_content VARCHAR(255),
    c_writer VARCHAR(30),
    CONSTRAINT PRIMARY KEY (c_no),
    CONSTRAINT FOREIGN KEY (b_no) REFERENCES board(b_no)
);

INSERT INTO board(b_content, b_writer) VALUES
('안녕하세요', '유재석'),
('오늘 날씨가 정말 좋네요', '강호동'),
('질문있어요', '신동엽'),
('자바 공부 어렵네요', '이수근'),
('SQL 공부 시작했습니다', '김종국'),
('오늘 점심 뭐 드셨나요?', '하하'),
('게시판 이용 방법 알려주세요', '송중기'),
('좋은 정보 공유합니다', '아이유'),
('이번 주말에 뭐하세요?', '박명수'),
('프로젝트 같이 하실 분?', '차은우');

INSERT INTO comment(b_no, c_content, c_writer) VALUES
(1, '안녕하세요! 반갑습니다.', '하하'),
(1, '저도 반갑습니다.', '강호동'),

(2, '그러게요. 날씨가 좋네요.', '유재석'),
(2, '밖에 나가고 싶어요.', '신동엽'),

(3, '저도 궁금한 내용입니다.', '이수근'),
(4, '저도 자바 공부 중입니다.', '김종국'),
(5, 'SQL은 처음에는 조금 어려워요.', '하하'),
(6, '저는 김치찌개 먹었습니다.', '송중기'),
(7, '게시판 상단에 설명이 있습니다.', '아이유'),
(8, '좋은 정보 감사합니다!', '박명수'),
(9, '저는 집에서 쉴 예정입니다.', '차은우'),
(10, '저도 참여하고 싶습니다.', '유재석');