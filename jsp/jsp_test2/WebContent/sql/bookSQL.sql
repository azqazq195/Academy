create table book (
    bookCode number primary key,
    bookname varchar2(30) not null,
    artist varchar2(30) not null,
    publisher varchar2(30),
    bookprice number
);

insert into book values (10030, '모모', '미하일 엔데', '비룡소', 9500);

select * from book;

select *
from (select rownum rn, tt. * from (select * from book order by bookCode asc) tt)
where rn>=1 and rn<=5;

drop table book purge;

commit;