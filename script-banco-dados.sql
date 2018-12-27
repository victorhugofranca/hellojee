-- TABELA category
create database hellojee_app;
create sequence sq_category;
create table category (
	id integer primary key default nextval('sq_category'), 
	nome text not null
);
create index category_idx1 on category using btree (id);