create sequence address_seq start 1 increment 1
create sequence admin_user_seq start 1 increment 1
create sequence customer_seq start 1 increment 1
create sequence school_rep_seq start 1 increment 1
create sequence uschool_id_seq start 1 increment 1
create sequence user_info_seq start 1 increment 1
create sequence user_role_seq start 1 increment 1
create table address (address_id int8 not null, city varchar(255), state varchar(255), street_address varchar(255), zip varchar(255), primary key (address_id))
create table admin_user (admin_user_id int8 not null, user_id int8, primary key (admin_user_id))
create table customer (customer_id int8 not null, event_id int8, ticket_id int8, user_id int8, primary key (customer_id))
create table record (id  bigserial not null, data varchar(255) not null, primary key (id))
create table school (school_id int8 not null, phone int4, school_address varchar(255), school_name varchar(255), school_rep_id varchar(255), primary key (school_id))
create table school_representative (school_rep_id int8 not null, school_id int8, user_id int8, primary key (school_rep_id))
create table user_info (user_info_id int8 not null, active int4, address_id int8, created_date timestamp, date_of_birth date, email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), phone_number varchar(255), primary key (user_info_id))
create table user_info_user_role (user_info_id int8 not null, user_role_id int8 not null, primary key (user_info_id, user_role_id))
create table user_role (user_role_id int8 not null, role_short_description varchar(255), user_role varchar(255), primary key (user_role_id))
alter table user_info_user_role add constraint FKrrsj80l4ad26wga1fyr7c376r foreign key (user_role_id) references user_role
alter table user_info_user_role add constraint FK2ogptm1w0hdl42okwmd8tftxn foreign key (user_info_id) references user_info
