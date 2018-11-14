SET SCHEMA 'project-1';

CREATE TABLE ers_reimbursement_status(
	reimb_status_id INTEGER,
	reimb_status varchar(10),
	
	PRIMARY KEY (reimb_status_id)
);

CREATE TABLE ers_reimbursement_type(
	reimb_type_id INTEGER,
	reimb_type varchar(10),
	
	PRIMARY KEY (reimb_type_id)
);

CREATE TABLE ers_user_roles(
	ers_user_role_id INTEGER,
	user_role varchar(10),
	
	PRIMARY KEY (ers_user_role_id)
);

CREATE TABLE ers_users(
	ers_users_id SERIAL PRIMARY KEY,
	ers_username varchar(50) UNIQUE,
	ers_password varchar(50),
	user_first_name varchar(100),
	user_last_name varchar(100),
	user_email varchar(150) UNIQUE,
	user_role_id INTEGER,
	
	FOREIGN KEY (user_role_id) REFERENCES ers_user_roles (ers_user_role_id)
);

CREATE TABLE ers_reimbursement(
	reimb_id SERIAL PRIMARY KEY,
	reimb_amount NUMERIC,
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_description varchar(250),
	reimb_receipt TEXT,
	reimb_author INTEGER,
	reimb_resolver INTEGER,
	reimb_status_id INTEGER,
	reimb_type_id INTEGER,
	
	
	FOREIGN KEY(reimb_author) REFERENCES ers_users(ers_users_id),
	FOREIGN KEY(reimb_resolver) REFERENCES ers_users (ers_users_id),
	FOREIGN KEY(reimb_status_id) REFERENCES ers_reimbursement_status (reimb_status_id),
	FOREIGN KEY(reimb_type_id) REFERENCES ers_reimbursement_type (reimb_type_id)

);



