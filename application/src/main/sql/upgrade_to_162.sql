ALTER TABLE ACCOUNT ADD COLUMN OFFSETTING_ALLOWABLE SMALLINT NOT NULL;
UPDATE ACCOUNT SET OFFSETTING_ALLOWABLE = 1 WHERE OFFSETTING_ALLOWABLE IS NULL;
UPDATE DATABASE_VERSION SET DATABASE_VERSION = 162 WHERE DATABASE_VERSION = 161;
  
