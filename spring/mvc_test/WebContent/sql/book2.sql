------------------mvc_test book2 -----------------------
create table book2 (
    code varchar2(30) primary key,      --도서코드
    title varchar2(30) not null,        --도서명
    author varchar2(30) not null,       --저자
    publisher varchar2(30),             --출판사
    price NUMBER,                       --가격
    publiDate varchar2(30)        --출판일
);

-- 테이블 구조 확인
desc book2;
-- 테이블 삭제
drop table book2 purge;
-- 테이블 목록
select * from tab;

-- 데이터 추가
insert into book2 values ('BC_001', '빅픽처', '더글라스 케네디', '밝은세상', 12000, '2020-09-21');

insert into book2 values ('BC_040', '책31', '저자31', '밝은세상', 10000, '2020-09-21');
insert into book2 values ('BC_041', '책32', '저자32', '밝은세상', 10000, '2020-09-21');
insert into book2 values ('BC_042', '책33', '저자33', '밝은세상', 10000, '2020-09-21');
insert into book2 values ('BC_043', '책34', '저자34', '밝은세상', 10000, '2020-09-21');
insert into book2 values ('BC_044', '책35', '저자35', '밝은세상', 10000, '2020-09-21');
insert into book2 values ('BC_045', '책36', '저자36', '밝은세상', 10000, '2020-09-21');
insert into book2 values ('BC_046', '책37', '저자37', '밝은세상', 10000, '2020-09-21');
insert into book2 values ('BC_047', '책38', '저자38', '밝은세상', 10000, '2020-09-21');
insert into book2 values ('BC_048', '책39', '저자39', '밝은세상', 10000, '2020-09-21');
insert into book2 values ('BC_049', '책40', '저자40', '밝은세상', 10000, '2020-09-21');

-- 데이터 검색
select * from book2;

-- 데이터 삭제
delete book2 where code='BC_001';

-- 인덱스 뷰
-- hidden column - rownum
select * from
(select rownum rn, tt.* from 
(select * from book2 order by code asc) tt)
where rn>=1 and rn<=7;

--총 글 수
SELECT COUNT(*) as cnt FROM book2;

--커밋
commit;