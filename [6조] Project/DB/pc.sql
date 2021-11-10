create sequence pc_num_seq
increment by 1
start with 1;

insert into pc(pc_num, pc_no, u_no,pay,pc_use,pc_start, pc_end, manager) 
values (pc_num_seq.nextval, 2, 2, 2000, 2, to_date('2021-07-24 06:21','YYYY-MM-DD HH24:MI'), to_date('2021-07-24 08:21','YYYY-MM-DD HH24:MI'), '정직원');
insert into pc(pc_num, pc_no, u_no,pay,pc_use,pc_start, pc_end, manager) 
values (pc_num_seq.nextval, 4, 3, 5000, 5, to_date('2021-07-23 12:31','YYYY-MM-DD HH24:MI'), to_date('2021-07-23 17:31','YYYY-MM-DD HH24:MI'), '관리자');
insert into pc(pc_num, pc_no, u_no,pay,pc_use,pc_start, pc_end, manager) 
values (pc_num_seq.nextval, 8, 1, 10000, 10, to_date('2021-07-24 08:34','YYYY-MM-DD HH24:MI'), to_date('2021-07-24 18:34','YYYY-MM-DD HH24:MI'), '수습');
insert into pc(pc_num, pc_no, u_no,pay,pc_use,pc_start, pc_end, manager) 
values (pc_num_seq.nextval, 12, 4, 1000, 1, to_date('2021-07-22 18:55','YYYY-MM-DD HH24:MI'), to_date('2021-07-22 19:55','YYYY-MM-DD HH24:MI'), '사장');
insert into pc(pc_num, pc_no, u_no,pay,pc_use,pc_start, pc_end, manager) 
values (pc_num_seq.nextval, 7, 5, 3000, 3, to_date('2021-07-21 20:46','YYYY-MM-DD HH24:MI'), to_date('2021-07-21 23:46','YYYY-MM-DD HH24:MI'), '사장');
commit;