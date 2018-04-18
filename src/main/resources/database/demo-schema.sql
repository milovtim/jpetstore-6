create table IF NOT EXISTS category (
	catid varchar(10) not null,
	name varchar(80) null,
	descn varchar(255) null,
	constraint pk_category primary key (catid)
);

create table IF NOT EXISTS product (
    productid varchar(10) not null,
    category varchar(10) not null,
    name varchar(80) null,
    descn varchar(255) null,
    constraint pk_product primary key (productid),
        constraint fk_product_1 foreign key (category)
        references category (catid)
);

create index IF NOT EXISTS productCat on product (category);
create index IF NOT EXISTS productName on product (name);
