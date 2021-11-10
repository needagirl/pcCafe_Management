create sequence u_no_seq
increment by 1
start with 1;

insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (u_no_seq.nextval,'전지현','jjhcdhc','giodano1981','010-5778-9987',2,'서울시 강남구',to_date('1981-10-30','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (U_NO_SEQ.nextval,'이상혁','faker','Faker555','010-5555-5555',1,'서울시 강남구',to_date('1996-05-07','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (U_NO_SEQ.nextval,'박보검','bogummy','Gummy7777','010-7777-7777',1,'서울시 양천구',to_date('1993-06-16','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex, addr,birth) 
values (U_NO_SEQ.nextval,'이제훈','jehunjehun','Jehun1234','010-1234-1234',1,'서울시 종로구',to_date('1984-07-04','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (U_NO_SEQ.nextval,'이지은','uaena','iloveu1993','010-5646-2346',2,'서울시 광진구',to_date('1993-05-16','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (U_NO_SEQ.nextval,'김태리','kimtaeri','taeriyakki','010-0424-0424',2,'서울시 중랑구',to_date('1990-04-24','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (U_NO_SEQ.nextval,'손예진','yejinhand','hand0111','010-0111-0111',2,'대구시 수성구',to_date('1982-01-11','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (U_NO_SEQ.nextval,'현빈','taepyung','bin0925','010-0925-0925',1,'대구시 수성구',to_date('1982-09-25','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (U_NO_SEQ.nextval,'김고은','ggonekim','gone0702','010-0702-0702',2,'서울시 서대문구',to_date('1991-07-02','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (U_NO_SEQ.nextval,'공유','gongyoo','jicheol0710','010-0710-0710',1,'부산시 동래구',to_date('1979-07-10','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (U_NO_SEQ.nextval,'한지민','romaemo','jimin105','010-1105-1105',2,'서울시 영등포구',to_date('1982-11-05','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (U_NO_SEQ.nextval,'배수지','suzybae','bae1010','010-1010-1010',2,'서울시 강남구',to_date('1994-10-10','YYYY-MM-DD'));
insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) 
values (U_NO_SEQ.nextval,'김연아','yunakim','kim0905','010-0905-0905',2,'경기도 부천시',to_date('1990-09-05','YYYY-MM-DD'));

commit;


update userdata set u_no=26 where name ='이지윤';
select * from userdata;
select * from product;
commit;