select pc_num,pc_no, u_no, pc_use, pay, pc_start, pc_end, manager from pc;

insert into p_enter(e_num, p_name, e_cnt, e_price, expiry, remark, manager ) values(e_num_seq.nextval,?,?,?,?,?,?);

select * from userdata;

select ud.u_no, ud.name, ud.sex, ud.id, 
to_char(ud.write_date, 'YYYY-MM-DD') write_date, pc.pc_use, pc.pay from userdata ud join pc pc on ud.u_no= pc.u_no 
and ud.name like '%이%' ;

select * from member where username like '%김%';


select ps.s_num, co.p_class, ps.p_name, pd.s_price, ps.s_cnt, ps.s_date, ps.manager from p_code co join product pd on co.p_code = pd.p_code
join p_sale ps on pd.p_name = ps.p_name;

select * from pc;
-- pc.u_no,
select pc.u_no from p_sale ps join manager mn on ps.manager = mn.manager join pc pc on mn.manager = pc.manager ;

select * from p_sale;

select pc_num, pc_no, u_no, pc_use, pay, pc_start, pc_end, manager from pc;

--상품 종류
create sequence p_code_seq
INCREMENT by 10
start with 10;


insert into p_code(p_code, p_class) values (p_code_seq.nextval,'스낵/과자');
insert into p_code(p_code, p_class) values (p_code_seq.nextval,'세트/중식/튀김');
insert into p_code(p_code, p_class) values (p_code_seq.nextval,'식사류');
insert into p_code(p_code, p_class) values (p_code_seq.nextval,'분식/양식');
insert into p_code(p_code, p_class) values (p_code_seq.nextval,'라면/우동');
insert into p_code(p_code, p_class) values (p_code_seq.nextval,'커피/음료');

--상품
create sequence p_num_seq
increment by 1
start with 1;

--p_code 10 과자/스낵
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'자유시간', 10,30, 1000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'콘칩', 10,15,1500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'꼬깔콘', 10,20,1500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'새우깡', 10,40,1500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'허니버터칩', 10,50,2000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'버터와플', 10,20,2000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'자갈치', 10,30,1500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'포스틱', 10,40,1500);

--p_code 20	세트/중식/튀김

insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'짜장면', 20,50,4500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'짬뽕', 20,50,4500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'우동', 20,40,4500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'볶음밥', 20,20,4500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'짬짜면', 20,20,4500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'감자튀김', 20,50,2500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'양파튀김', 20,25,2500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'야채튀김', 20,15,2500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'새우튀김', 20,15,2500);
-- 30	식사류
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'제육볶음', 30,20,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'참치김치볶음밥', 30,20,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'부대찌개', 30,10,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'김치찌개', 30,10,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'삼겹덮밥', 30,15,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'1인삼겹', 30,15,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'닭갈비덮밥', 30,20,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'스팸계란비빔밥', 30,10,6000);
-- 40	분식/양식
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'돈까스', 40,15,5500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'치즈돈까스', 40,5,5500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'생선돈까스', 40,5,5500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'까르보나라', 40,10,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'오므라이스', 40,15,5500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'서로인스테이크', 40,5,7000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'토마토파스타', 40,15,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'바베큐 폭찹', 40,5,7000);

-- 50	라면/우동
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'신라면', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'진라면-매운맛', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'짜파게티', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'너구리', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'비빔면', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'새우탕', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'튀김우동', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'육개장-큰컵', 50,30,3000);

-- 60	커피/음료
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'아메리카노', 60,50,2500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'생과일주스', 60,10,4000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'스무디', 60,10,4000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'아이스티', 60,50,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'식혜', 60,10,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'콜라', 60,60,2000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'사이다', 60,50,2000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'오렌지쥬스', 60,30,2000);

--상품 입고
create sequence e_num_seq
increment by 1
start with 1; 

insert into p_enter(e_num, p_name, e_price, e_cnt) 
values(e_num_seq.nextval, '자유시간', 500, 20);
insert into p_enter(e_num, p_name, e_price, e_cnt) 
values(e_num_seq.nextval, '너구리', 1000, 10);
insert into p_enter(e_num, p_name, e_price, e_cnt) 
values(e_num_seq.nextval, '콜라', 300, 20);
insert into p_enter(e_num, p_name, e_price, e_cnt) 
values(e_num_seq.nextval, '우동', 450, 15);
insert into p_enter(e_num, p_name, e_price, e_cnt) 
values(e_num_seq.nextval, '치즈돈까스', 1500, 5);

--상품 판매
create sequence s_num_seq
INCREMENT by 1
start with 1;

select * from p_sale;

insert into p_sale(s_num, p_name, s_cnt,u_no) 
values (s_num_seq.nextval, '자유시간', 1,21 );
insert into p_sale(s_num, p_name, s_cnt,u_no) 
values (s_num_seq.nextval, '너구리', 1,22);
insert into p_sale(s_num, p_name, s_cnt,u_no) 
values (s_num_seq.nextval, '콜라', 1,23);
insert into p_sale(s_num, p_name, s_cnt,u_no) 
values (s_num_seq.nextval, '아메리카노', 1,24);
insert into p_sale(s_num, p_name, s_cnt,u_no) 
values (s_num_seq.nextval, '자유시간', 1,25);
commit;
