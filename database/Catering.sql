
/*
码表
序号		id	自增
Code名称	codeName	数字代表的含义名称
Code		code	数字
*/

create table codetable
(
	id int identity(1,1)primary key,
	codeName	varchar(20),
	code	int
)

/*
员工账号密码表		
id		enterId
账号 	account	
密码 	pwd
账号状态	enterState 详见码表
*/
create table staffEnter
(
	enterId int identity(1,1)primary key,
	account varchar(30) unique,
	pwd varchar(20),
	enterState int 
)

/*
顾客账号密码表		
id		enterId
账号 	account	
密码 	pwd

*/
create table  customerEnter
(
	enterId int identity(1,1)primary key,
	account varchar(30) unique,
	pwd varchar(20)
)

/*
2角色表：
职务编号 	partId
职务名称 	partName
*/
create table part
(
	partId int identity(1,1)primary key,
	partName varchar(20)
)
/*
3员工信息表：
人员ID		ID			自增
员工编号 	staffID		
姓名 		Name  非空
性别		sex		1为男或者2为女 参照码表
年龄		age
手机号		phone，
地址		varchar(20)，
入职时间	accession	
角色id		partId	参照角色表
账号		enterID		未建
*/
create table staffInfo
(
	Id		int identity(1,1)primary key,
	staffId int unique,
	Name varchar(20) not null,
	sex	int foreign key references codetable(id),
	age int,
	phone varchar(11),
	adress varchar(100),
	accession date,
	partId int foreign key references part(partId ),
	endetId		int foreign key references staffEnter(enterId )	
)
select s1.Name,s1.staffId,s1.phone,s1.sex,s1.age,s1.adress,s1.accession,p1.partId,d1.deskId
				from staffInfo s1,part p1, desk_staff d1

/*
3顾客信息表：
人员ID		ID			自增	
姓名 		Name  非空
性别		sex		1为男或者2为女 参照码表
手机号		phone，
地址		adress
账号		enterId 
*/
create table customerInfo
(
	Id		int identity(1,1)primary key,
	Name varchar(20) not null,
	sex	int foreign key references codetable(id),
	phone varchar(11),
	adress varchar(100),
	enterId int foreign key references customerEnter(enterId)
)

/*
4桌位表：
桌位id		deskId
桌位人数	personNum
桌名字		deskName	
桌位状态	deskState(0:可用，1：占用，2：脏台)参照码表

*/
create table desk
(
	deskId int identity(1,1)primary key,
	personNum int,
	deskName varchar(20),
	deskState int foreign key references codetable(id),
)
/*
6桌位—服务员表：
关系序号	id	
桌位id		deskId  外键桌位表（桌位id）
员工id		staffID 外键员工信息表(员工编号)

*/
create table desk_staff
(
	id int identity(1,1)primary key,
	deskId int foreign key references desk(deskId),
	staffId int foreign key references staffInfo(staffId)
)

/*
7菜类别表：
类别编号 	kindId自增 主键
类别		kindName（如汤类，热菜，凉菜，饮品）
*/
create table kind
(
	kindId int identity(1,1)primary key,
	kindName varchar(50)
)
/*
8菜品表：
菜品编号 	dishId 自增 主键
菜名 		dishName
价格 		price
类别编号 	kindId外键 类别表（类别编号）
制作时长 	makeTime，
优先等级 	priority
菜品图		pictureName 图片储存在本地数据库只储存名字
最大并菜份数		int 
*/
create table dish
(
	dishId int identity(1,1)primary key,
	dishName varchar(20),
	price int,
	kindId int foreign key references kind(kindId),
	makeTime int,
	priority int,
	picture varbinary,
	maxCopies int
)
select * from staffInfo  where Name like '%u%'
select * from staffInfo where Name like'%2%' or sex like'%2%' or age like'%2%' or phone like'%2%' or adress like'%2%' or accession like'%2%' or partId like'%2%'		
/*

9权限表：
权限编号 	authorityId 自增 主键
权限名称	authorityName
权限等级 	int
权限路径	varchar

*/
create table authority
(
	authorityId int identity(1,1)primary key,
	authorityName varchar(20),
	authorityLevel int	,
	authorityUrl	varchar(50)
)
/*
10角色权限表：
编号		id		int，自增 主键
职务编号 	partId，外键 角色表（职务编号）
权限编号 	authorityId	外键 权限表（权限编号）

*/
create table part_authority
(
	id int identity(1,1)primary key,
	partId int foreign key references part(partId),
	authorityId int foreign key references authority(authorityId)
)

/*
11订单表：
订单ID 		OrderId int identity primary key, 	
订单状态	OrderStatus 参照码表(进行中，完成 ，取消，审核中)
订单价格	OrderPrice int not null,
点菜数量	FoodNum int not null
结账方式 	varchar（现金，支付宝，微信）
订单时间	OrderDate datetime not null,
桌位		deskId 外键 桌位表（桌位id）
*/
create table orders
(
	ordersId int identity(1,1)primary key,
	ordersStatus int  foreign key references codetable(id),
	ordersPrice int not null,
	FoodNum int not null,
	cost int foreign key references codetable(id),
	ordersTime datetime not null,
	deskId int foreign key references desk(deskId)
)
/*
12订单点菜表：
字段		类型
id		id	自增
订单ID		ordersId 外键 订单表（订单ID）
菜品ID		vegetableId 外键 菜品表（菜品编号 ）
菜品状态	vegetableStatus 参照码表(1：已上，2：在做，0：未做)	
桌号		diskId 外键桌号
*/
create table orders_dish
(
	id	int identity(1,1)primary key,
	ordersId int foreign key references orders(ordersId),
	dishId int foreign key references dish(dishId),
	dishStatus int foreign key references codetable(id),
	deskId int  foreign key references desk(deskId),
)
/*
13建议表：
字段		类型
退单id			suggestId
订单号		ordersId 外键 订单表（订单ID ）
桌位id		deskId，外键 桌位表（桌位id）
建议信息 	suggest
*/
create table suggest
(
	suggestId int identity(1,1)primary key,
	ordersId int foreign key references orders(ordersId),
	deskId int foreign key references desk(deskId),
	suggest varchar(200)
)

/*
14退单表：
字段		类型
id			chargebackId 自增 主键
订单号		ordersId，外键 订单表（订单ID ）
原因		reason
*/
create table chargeback
(
	chargebackId int identity(1,1)primary key,
	ordersId int foreign key references orders(ordersId),
	reason varchar(200)
)

/*
15收入表:	
id		id  自增 主键
日期		incomeTime
现金收入 	cash
支付宝收入	alipay 
微信收入	wechat
订单总数	ordersum
营业总收入	Total
*/
create table income
(
	id int identity(1,1)primary key,
	incomeTime datetime,
	cash int,
	alipay int,
	wechat int,
	ordersum int,
	total int
)


/*
16.创建桌子信息视图
desk 桌位表
staffInfo 员工表
desk_staff 桌位员工关系表
codetable 码表
*/
create view desk_refresh
as
select d.deskId,d.deskName,d.personNum,s.Name,co.codeName from
desk d left join desk_staff ds on d.deskId=ds.deskId
left join staffInfo s on s.staffId=ds.staffId
left join codetable co on d.deskState=co.id

/*
桌子名字添加约束--唯一
*/
alter table desk
add constraint desk_unique unique(deskName)

/*
桌子名字添加约束--不能为空
*/
alter table desk
alter column deskName varchar(20) not null