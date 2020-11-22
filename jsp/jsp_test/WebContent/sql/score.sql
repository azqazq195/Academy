create table score (
  hak number primary key not null,        --학번
  name varchar2(20) not null,             --이름
  kor number,                    --국어
  eng number,                    --영어
  mat number,                    --수학
  tot number,                    --총합
  avg number                      --평균
);

--데이터 추가
insert into score values('1','강한별','0','0','0','0','0');

--데이터 확인
select * from score;

SELECT COUNT(*) as cnt FROM score;

select*from 
(select rownum rn, tt.*from
(select*from score order by hak asc) tt)
where rn>=1 and rn<=50;

--DB저장
COMMIT;