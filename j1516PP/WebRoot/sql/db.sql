create database daily;

use daily;

create table daily
(
id int primary key identity(1,1),
name varchar(32),		--ѧԱ����
proName varchar(64),	--��Ŀ��
progress int,			--����
time datetime,			--�ύʱ��
ip varchar(32),			--ip��ַ
detail varchar(2000)	--�ձ�����
)

insert into daily values('�ܽ���','�����׵����ϵͳ(��̨����)',60,GETDATE(),'128.0.44.141','��ɲ�Ʒ�����Լ���Ʒ�б��ܣ�ʵ��ǰ���Լ���̨����У��');
insert into daily values('����','�й����ʴ�ѧ���ڱ���ϵͳ',85,GETDATE(),'128.0.44.125','���ʳ�ù�����Ա����ģ�飬�Լ�ʳ���߲˿�����');
insert into daily values('��С��','12306��Ʊϵͳ��̨ͳ��',20,GETDATE(),'128.0.44.33','ʵ�ֹ���Ա��¼,��ɫȨ�޷��书��');

insert into daily values('�ܽ���','�����׵����ϵͳ(��̨����)',50,GETDATE(),'128.0.44.141','��ɲ�Ʒ�����Լ���Ʒ�б��ܣ�ʵ��ǰ���Լ���̨����У��');

insert into daily values('�ܽ���','�����׵����ϵͳ(��̨����)',50,GETDATE(),'128.0.44.141','��ɲ�Ʒ�����Լ���Ʒ�б��ܣ�ʵ��ǰ���Լ���̨����У��');
insert into daily values('����','�й����ʴ�ѧ���ڱ���ϵͳ',75,GETDATE(),'128.0.44.125','���ʳ�ù�����Ա����ģ�飬�Լ�ʳ���߲˿�����');


--��ѯָ������ʦ���һ���ύ���ձ���Ϣ��ȡ�������ֵ��
select top 1 * from daily where name='�ܽ���' order by time desc;

select * from daily;

--�ضϱ�
--truncate table daily;

--�����ܰ�ȥ���ظ��������Ƚ�������
select d.* from daily d,
	(select MAX(progress) p,name n,MAX(id) id from daily group by name) t 
	where d.name=t.n and d.progress=t.p and d.id=t.id order by d.progress desc;
	
--�����ձ�(12СʱΪ�ٽ�)��ȥ���ظ��������Ƚ�������
select d.* from daily d,	
(select name,MAX(progress) p,MAX(id) id from daily where DATEDIFF(HH,time,GETDATE())<=12 group by name) t
where d.name=t.name and d.progress=t.p and d.id=t.id order by d.progress desc;

--select MAX(progress) p,name n,MAX(id) id from daily group by name order by p desc;
