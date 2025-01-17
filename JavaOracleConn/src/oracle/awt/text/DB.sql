CREATE TABLE account (
	id varchar2(20) PRIMARY KEY,
	pwd varchar2(20) NOT NULL
);

CREATE TABLE account (
	id varchar2(20), 
	pwd varchar2(20) NOT NULL,
	CONSTRAINT PK_ACCOUNT PRIMARY key(id)
);

INSERT INTO account VALUES ('sahmyook','qwer1234');