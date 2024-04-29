--������̺�(�����ȣ,�����,����ó,�̸���,�Ի�����,�޿�)
-- drop table emp purge;
create table emp (
 emp_no number primary key, --emp_seq nextval
 emp_name varchar2(40) not null,
 emp_phone varchar2(12) not null, --02-1234-1234
 email varchar2(30) not null,
 hire_date date default sysdate,
 salary number
);
alter table emp add dept varchar2(10);

--C(reate)R(ead)U(pdate)D(elete)
create sequence emp_seq;
insert into emp (emp_no, emp_name, emp_phone, email, salary)
values (emp_seq.nextval, 'kildongHong', '01-1234-5678', 'kildong@email', 2000);
insert into emp (emp_no, emp_name, emp_phone, email, salary)
values (emp_seq.nextval, 'kildongPark', '01-3333-5678', 'pkildong@email', 2300);

select *
from emp
order by emp_no;


update emp
set salary = salary + 500,
    emp_phone = '01-1111-1111'
where emp_name = 'kildongPark';

delete from emp
where emp_no = 3;



create table  member(
member_no number primary key,
member_name varchar2(40) not null,
member_phone varchar2(20) not null, 
member_birthday varchar2(20) not null,
member_sex varchar2(5) not null
);




create sequence member_seq;
insert into member (member_no, member_name, member_phone, member_birthday, member_sex)
values (member_seq.nextval, 'ȫ�浿', '010-1211-1111', '98-04-02', '��');
insert into member (member_no, member_name, member_phone, member_birthday, member_sex)
values (member_seq.nextval, '�ڱ浿', '010-1211-2222', '99-04-02','��');
insert into member (member_no, member_name, member_phone, member_birthday, member_sex)
values (member_seq.nextval, '�踸��', '010-1211-3333', '98-04-02','��');

select *
from member
order by member_no;

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
create table users(
users_id varchar2(50) primary key,
users_date varchar2(50) not null,
users_pw varchar2(50) not null, 
users_name varchar2(50) not null, 
users_birthday varchar2(50) not null, 
users_phone varchar2(50) not null
);
--drop table users;
select sysdate from dual;

create table board(
board_postnum varchar2(50) primary key,
board_title varchar2(200) not null,
board_detail varchar2(200) not null,
board_views varchar2(50) not null
);

--drop table board;

select *
from board
order by board_postnum;


create sequence board_seq;
insert into board (board_postnum, board_title, board_detail, board_views)
values (board_seq.nextval, '�Ұ��� �Խù� ����ó��' , '���������� ���� �ȴٰ� �ǴܵǴ� ���' , '5');
insert into board  (board_postnum, board_title, board_detail, board_views)
values (board_seq.nextval, '������ǰ��' , '���� ��û�� ������ ����ǰ�� �����ؾ��մϴ�' , '0');
insert into board  (board_postnum, board_title, board_detail, board_views)
values(board_seq.nextval, '�ͼ����ؾ' , '������⿡ ���ں� â�� ������ ����������' , '2');
insert into board  (board_postnum, board_title, board_detail, board_views)
values(board_seq.nextval, 'ȭõ�� ������ �뿩��' , '������ ���� ������ �ñ��մϴ�' , '0');






