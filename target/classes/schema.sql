create table al387_users_tbl(id int auto_increment primary key,username varchar(25) unique,password varchar(25),fullname varchar(25),email varchar(35) unique);

create table al387_products_tbl(pid int auto_increment primary key,prod_name varchar(100),prod_desc varchar(100),image mediumblob,initial_bid  float,category varchar(30),seller_id int,foreign key(seller_id) references al387_users_tbl(id) on update cascade on delete cascade);

create table al387_bids_tbl(bid_id int primary key auto_increment,bid_val float,customer_id int,product_id int,bid_status boolean,foreign key(customer_id)references al387_users_tbl(id) on update cascade on delete cascade,foreign key(product_id)references al387_products_tbl(pid)on delete cascade on update cascade);

create table al387_orders_tbl(order_id int primary key auto_increment,order_date date,product_id int,product_name varchar(30),image mediumblob,category varchar(30),price float,customer_id int,seller_id int,foreign key(customer_id)references al387_users_tbl(id) on update cascade on delete cascade,foreign key(seller_id)references al387_users_tbl(id) on update cascade on delete cascade);

create table al387_card_details_tbl(card_id int primary key auto_increment,cardholder varchar(30),card_number long,month int,year int,cvv int,customer_id int,foreign key(customer_id)references al387_users_tbl(id) on update cascade on delete cascade);