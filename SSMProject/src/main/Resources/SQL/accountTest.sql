DROP TABLE IF EXISTS signon;
DROP TABLE IF EXISTS account;

create table signon (
  username varchar(25) not null,
  password varchar(25)  not null,
  constraint pk_signon primary key (username)
);

create table account (
  userid varchar(25) not null,
  email varchar(80) not null,
  role varchar(10) not null,
  constraint pk_account primary key (userid)
);

INSERT INTO signon VALUES('user','password');
INSERT INTO account VALUES('user','uesr@gmail.com','admin');