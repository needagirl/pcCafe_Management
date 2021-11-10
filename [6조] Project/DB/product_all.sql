select pc_num,pc_no, u_no, pc_use, pay, pc_start, pc_end, manager from pc;

insert into p_enter(e_num, p_name, e_cnt, e_price, expiry, remark, manager ) values(e_num_seq.nextval,?,?,?,?,?,?);

select * from userdata;

select ud.u_no, ud.name, ud.sex, ud.id, 
to_char(ud.write_date, 'YYYY-MM-DD') write_date, pc.pc_use, pc.pay from userdata ud join pc pc on ud.u_no= pc.u_no 
and ud.name like '%��%' ;

select * from member where username like '%��%';


select ps.s_num, co.p_class, ps.p_name, pd.s_price, ps.s_cnt, ps.s_date, ps.manager from p_code co join product pd on co.p_code = pd.p_code
join p_sale ps on pd.p_name = ps.p_name;

select * from pc;
-- pc.u_no,
select pc.u_no from p_sale ps join manager mn on ps.manager = mn.manager join pc pc on mn.manager = pc.manager ;

select * from p_sale;

select pc_num, pc_no, u_no, pc_use, pay, pc_start, pc_end, manager from pc;

--��ǰ ����
create sequence p_code_seq
INCREMENT by 10
start with 10;


insert into p_code(p_code, p_class) values (p_code_seq.nextval,'����/����');
insert into p_code(p_code, p_class) values (p_code_seq.nextval,'��Ʈ/�߽�/Ƣ��');
insert into p_code(p_code, p_class) values (p_code_seq.nextval,'�Ļ��');
insert into p_code(p_code, p_class) values (p_code_seq.nextval,'�н�/���');
insert into p_code(p_code, p_class) values (p_code_seq.nextval,'���/�쵿');
insert into p_code(p_code, p_class) values (p_code_seq.nextval,'Ŀ��/����');

--��ǰ
create sequence p_num_seq
increment by 1
start with 1;

--p_code 10 ����/����
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�����ð�', 10,30, 1000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'��Ĩ', 10,15,1500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'������', 10,20,1500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�����', 10,40,1500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'��Ϲ���Ĩ', 10,50,2000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'���Ϳ���', 10,20,2000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�ڰ�ġ', 10,30,1500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'����ƽ', 10,40,1500);

--p_code 20	��Ʈ/�߽�/Ƣ��

insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'¥���', 20,50,4500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'«��', 20,50,4500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�쵿', 20,40,4500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'������', 20,20,4500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'«¥��', 20,20,4500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'����Ƣ��', 20,50,2500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'����Ƣ��', 20,25,2500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'��äƢ��', 20,15,2500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'����Ƣ��', 20,15,2500);
-- 30	�Ļ��
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'��������', 30,20,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'��ġ��ġ������', 30,20,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�δ��', 30,10,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'��ġ�', 30,10,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'��㵤��', 30,15,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'1�λ��', 30,15,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�߰��񵤹�', 30,20,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'���԰�������', 30,10,6000);
-- 40	�н�/���
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'���', 40,15,5500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'ġ��', 40,5,5500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�������', 40,5,5500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�������', 40,10,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'���Ƕ��̽�', 40,15,5500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�����ν�����ũ', 40,5,7000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�丶���Ľ�Ÿ', 40,15,6000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�ٺ�ť ����', 40,5,7000);

-- 50	���/�쵿
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�Ŷ��', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�����-�ſ��', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'¥�İ�Ƽ', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�ʱ���', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�����', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'������', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'Ƣ��쵿', 50,30,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'������-ū��', 50,30,3000);

-- 60	Ŀ��/����
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�Ƹ޸�ī��', 60,50,2500);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�������ֽ�', 60,10,4000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'������', 60,10,4000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'���̽�Ƽ', 60,50,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'����', 60,10,3000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�ݶ�', 60,60,2000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'���̴�', 60,50,2000);
insert into product(p_num, p_name,p_code,p_stock,s_price) values(p_num_seq.nextval,'�������꽺', 60,30,2000);

--��ǰ �԰�
create sequence e_num_seq
increment by 1
start with 1; 

insert into p_enter(e_num, p_name, e_price, e_cnt) 
values(e_num_seq.nextval, '�����ð�', 500, 20);
insert into p_enter(e_num, p_name, e_price, e_cnt) 
values(e_num_seq.nextval, '�ʱ���', 1000, 10);
insert into p_enter(e_num, p_name, e_price, e_cnt) 
values(e_num_seq.nextval, '�ݶ�', 300, 20);
insert into p_enter(e_num, p_name, e_price, e_cnt) 
values(e_num_seq.nextval, '�쵿', 450, 15);
insert into p_enter(e_num, p_name, e_price, e_cnt) 
values(e_num_seq.nextval, 'ġ��', 1500, 5);

--��ǰ �Ǹ�
create sequence s_num_seq
INCREMENT by 1
start with 1;

select * from p_sale;

insert into p_sale(s_num, p_name, s_cnt,u_no) 
values (s_num_seq.nextval, '�����ð�', 1,21 );
insert into p_sale(s_num, p_name, s_cnt,u_no) 
values (s_num_seq.nextval, '�ʱ���', 1,22);
insert into p_sale(s_num, p_name, s_cnt,u_no) 
values (s_num_seq.nextval, '�ݶ�', 1,23);
insert into p_sale(s_num, p_name, s_cnt,u_no) 
values (s_num_seq.nextval, '�Ƹ޸�ī��', 1,24);
insert into p_sale(s_num, p_name, s_cnt,u_no) 
values (s_num_seq.nextval, '�����ð�', 1,25);
commit;
