alter table LOOKUP_VALUE modify column LOOKUP_ID INTEGER AUTO_INCREMENT NOT NULL;

update DATABASE_VERSION set DATABASE_VERSION = 121 where DATABASE_VERSION = 120;
