create table IF NOT EXISTS category (
	catid varchar(80) not null,
	name varchar(80) null,
	descn varchar(255) null,
	constraint pk_category primary key (catid)
);

CREATE SEQUENCE IF NOT EXISTS productIdSeq START 1;

create table IF NOT EXISTS product (
    productid INTEGER not null,
    category varchar(80) not null,
    name varchar(80) null,
    descn varchar(255) null,
    constraint pk_product primary key (productid),
        constraint fk_product_1 foreign key (category)
        references category (catid)
);

create index IF NOT EXISTS productCat on product (category);
create index IF NOT EXISTS productName on product (name);
