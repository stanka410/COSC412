create table address (address_id bigint not null auto_increment, city varchar(255), state varchar(255), street_address varchar(255), zip varchar(255), primary key (address_id))
create table admin_user (admin_user_id bigint not null auto_increment, user_id bigint, primary key (admin_user_id))
create table customer (customer_id bigint not null auto_increment, event_id bigint, ticket_id bigint, user_id bigint, primary key (customer_id))
create table record (id bigint not null auto_increment, data varchar(255) not null, primary key (id))
create table school (school_id bigint not null auto_increment, phone integer, school_address varchar(255), school_name varchar(255), school_rep_id varchar(255), primary key (school_id))
create table school_representative (school_rep_id bigint not null auto_increment, school_id bigint, user_id bigint, primary key (school_rep_id))
create table user_info (user_info_id bigint not null auto_increment, active integer, address_id bigint, created_date datetime, date_of_birth date, email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), phone_number varchar(255), primary key (user_info_id))
create table user_info_user_role (user_info_id bigint not null, user_role_id bigint not null, primary key (user_info_id, user_role_id))
create table user_role (user_role_id bigint not null auto_increment, role_short_description varchar(255), user_role varchar(255), primary key (user_role_id))
alter table user_info_user_role add constraint FKrrsj80l4ad26wga1fyr7c376r foreign key (user_role_id) references user_role (user_role_id)
alter table user_info_user_role add constraint FK2ogptm1w0hdl42okwmd8tftxn foreign key (user_info_id) references user_info (user_info_id)
