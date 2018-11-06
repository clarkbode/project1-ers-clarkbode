SET SCHEMA 'project-1';

CREATE TABLE ers_reimbursement_status(
	reimb_status_id NUMERIC,
	reimb_status varchar(10),
	
	PRIMARY KEY (reimb_status_id)
);

CREATE TABLE ers_reimbursement_type(
	reimb_type_id NUMERIC,
	reimb_type varchar(10),
	
	PRIMARY KEY (reimb_type_id)
);

CREATE TABLE ers_user_roles(
	ers_user_role_id NUMERIC,
	user_role varchar(10),
	
	PRIMARY KEY (ers_user_role_id)
);

CREATE TABLE ers_users(
	ers_users_id NUMERIC,
	ers_username varchar(50) UNIQUE,
	ers_password varchar(50),
	user_first_name varchar(100),
	user_last_name varchar(100),
	user_email varchar(150) UNIQUE,
	user_role_id NUMERIC,
	
	PRIMARY KEY (ers_users_id),
	FOREIGN KEY (user_role_id) REFERENCES ers_user_roles (ers_user_role_id)
);

CREATE TABLE ers_reimbursement(
	reimb_id NUMERIC,
	reimb_amount NUMERIC,
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_description varchar(250),
	reimb_receipt TEXT,
	reimb_author NUMERIC,
	reimb_resolver NUMERIC,
	reimb_status_id NUMERIC,
	reimb_type_id NUMERIC,
	
	PRIMARY KEY (reimb_id),
	FOREIGN KEY(reimb_author) REFERENCES ers_users(ers_users_id),
	FOREIGN KEY(reimb_resolver) REFERENCES ers_users (ers_users_id),
	FOREIGN KEY(reimb_status_id) REFERENCES ers_reimbursement_status (reimb_status_id),
	FOREIGN KEY(reimb_type_id) REFERENCES ers_reimbursement_type (reimb_type_id)

);



