create database daily;

use daily;

create table daily
(
id int primary key identity(1,1),
name varchar(32),		--学员姓名
proName varchar(64),	--项目名
progress int,			--进度
time datetime,			--提交时间
ip varchar(32),			--ip地址
detail varchar(2000)	--日报详情
)

insert into daily values('周杰伦','晓菜易碟点餐系统(后台管理)',60,GETDATE(),'128.0.44.141','完成餐品发布以及餐品列表功能，实现前端以及后台数据校验');
insert into daily values('王大锤','中国地质大学后勤保障系统',85,GETDATE(),'128.0.44.125','完成食堂工作人员管理模块，以及食堂蔬菜库存管理');
insert into daily values('易小星','12306售票系统后台统计',20,GETDATE(),'128.0.44.33','实现管理员登录,角色权限分配功能');

insert into daily values('周杰伦','晓菜易碟点餐系统(后台管理)',50,GETDATE(),'128.0.44.141','完成餐品发布以及餐品列表功能，实现前端以及后台数据校验');

insert into daily values('周杰伦','晓菜易碟点餐系统(后台管理)',50,GETDATE(),'128.0.44.141','完成餐品发布以及餐品列表功能，实现前端以及后台数据校验');
insert into daily values('王大锤','中国地质大学后勤保障系统',75,GETDATE(),'128.0.44.125','完成食堂工作人员管理模块，以及食堂蔬菜库存管理');


--查询指定工程师最后一次提交的日报信息（取进度最大值）
select top 1 * from daily where name='周杰伦' order by time desc;

select * from daily;

--截断表
--truncate table daily;

--排行总榜，去除重复，按进度降序排序
select d.* from daily d,
	(select MAX(progress) p,name n,MAX(id) id from daily group by name) t 
	where d.name=t.n and d.progress=t.p and d.id=t.id order by d.progress desc;
	
--今日日报(12小时为临界)，去除重复，按进度降序排序
select d.* from daily d,	
(select name,MAX(progress) p,MAX(id) id from daily where DATEDIFF(HH,time,GETDATE())<=12 group by name) t
where d.name=t.name and d.progress=t.p and d.id=t.id order by d.progress desc;

--select MAX(progress) p,name n,MAX(id) id from daily group by name order by p desc;
