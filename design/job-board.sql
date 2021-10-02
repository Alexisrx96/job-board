DROP DATABASE IF EXISTS job_board;
CREATE DATABASE job_board CHARACTER SET utf8mb4 ;

USE job_board;
CREATE TABLE account_state(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(11) NOT NULL,
    CONSTRAINT pk_account_state_id PRIMARY KEY (id)
)ENGINE = innoDB CHARACTER SET utf8mb4 ;
-- Activo | Inactivo | Pendiente | No aprobada

CREATE TABLE account_type(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(18) NOT NULL,
    CONSTRAINT pk_account_type_id PRIMARY KEY (id)
)ENGINE = innoDB CHARACTER SET utf8mb4 ;
-- ROLE_profesional | ROLE_empresa | ROLE_administrador

CREATE TABLE account(
    email VARCHAR(255) NOT NULL,
    pwrd VARCHAR(300) NOT NULL,
    type INT NOT NULL,
    state INT NOT NULL,
    confirm_code VARCHAR(6) NOT NULL,
    CONSTRAINT pk_account_id PRIMARY KEY (email),
    CONSTRAINT fk_account_account_type FOREIGN KEY(type) REFERENCES account_type(id),
    CONSTRAINT fk_account_account_state FOREIGN KEY(state) REFERENCES account_state(id)
)ENGINE = innoDB CHARACTER SET utf8mb4 ROW_FORMAT=DYNAMIC;

CREATE TABLE area(
    id INT AUTO_INCREMENT NOT NULL,
	name VARCHAR(200) NOT NULL,
    CONSTRAINT pk_area_id PRIMARY KEY (id)
)ENGINE = innoDB CHARACTER SET utf8mb4 ;

CREATE TABLE tag(
    id INT AUTO_INCREMENT NOT NULL,
	name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_tag_id PRIMARY KEY (id)
)ENGINE = innoDB CHARACTER SET utf8mb4 ;

CREATE TABLE profesional_profile(
    id INT AUTO_INCREMENT NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
    area_id INT NOT NULL,
    CONSTRAINT pk_profesional_profile_id PRIMARY KEY (id),
    CONSTRAINT fk_profesional_profile_area FOREIGN KEY(area_id) REFERENCES area(id),
    CONSTRAINT fk_profesional_profile_account FOREIGN KEY(email) REFERENCES account(email)
)ENGINE = innoDB CHARACTER SET utf8mb4 ROW_FORMAT=DYNAMIC;

CREATE TABLE profesional_profile_tag(
    profesional_profile_id INT NOT NULL,
    tag_id INT NOT NULL,
    CONSTRAINT pk_profesional_profile_tag PRIMARY KEY (profesional_profile_id,tag_id),
    CONSTRAINT fk_profesional_profile FOREIGN KEY(profesional_profile_id) REFERENCES profesional_profile(id),
    CONSTRAINT fk_tag FOREIGN KEY(tag_id) REFERENCES tag(id)
)ENGINE = innoDB CHARACTER SET utf8mb4 ;

CREATE TABLE resume(
    id INT AUTO_INCREMENT NOT NULL,
    profesional_profile_id INT NOT NULL,
    file_address VARCHAR(500) NOT NULL UNIQUE,
    CONSTRAINT pk_resume PRIMARY KEY (id),
    CONSTRAINT fk_profesional_profile_resume FOREIGN KEY(profesional_profile_id) REFERENCES profesional_profile(id)
)ENGINE = innoDB CHARACTER SET utf8mb4 ROW_FORMAT=DYNAMIC;

CREATE TABLE company_profile(
    id INT AUTO_INCREMENT NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(200) NOT NULL,
    about VARCHAR(1000) NOT NULL,
    CONSTRAINT pk_company_profile_id PRIMARY KEY (id),
    CONSTRAINT fk_company_profile_account FOREIGN KEY(email) REFERENCES account(email)
)ENGINE = innoDB CHARACTER SET utf8mb4 ROW_FORMAT=DYNAMIC;

CREATE TABLE company_address(
	id int NOT NULL AUTO_INCREMENT,
    company_id int NOT NULL,
    address VARCHAR(500) NOT NULL,
    CONSTRAINT pk_company_address_id PRIMARY KEY (id),
    CONSTRAINT fk_company_profile_address FOREIGN KEY(company_id) REFERENCES company_profile(id)
)ENGINE = innoDB CHARACTER SET utf8mb4 ROW_FORMAT=DYNAMIC;

CREATE TABLE job_offer_state(
    id INT AUTO_INCREMENT NOT NULL,
	name VARCHAR(10) NOT NULL,
    CONSTRAINT pk_job_offer_state_id PRIMARY KEY (id)
)ENGINE = innoDB CHARACTER SET utf8mb4 ;
-- Activa, Finalizada

CREATE TABLE job_offer(
    id INT AUTO_INCREMENT NOT NULL,
	title VARCHAR(200) NOT NULL,
	description TEXT NOT NULL,
    company_id int NOT NULL,
    state_id INT NOT NULL,
    area_id INT NOT NULL,
    CONSTRAINT pk_job_offer_id PRIMARY KEY (id),
    CONSTRAINT fk_job_offer_company_profile FOREIGN KEY(company_id) REFERENCES company_profile(id),
    CONSTRAINT fk_job_offer_job_offer_state FOREIGN KEY(state_id) REFERENCES job_offer_state(id),
    CONSTRAINT fk_job_offer_area FOREIGN KEY(area_id) REFERENCES area(id)
)ENGINE = innoDB CHARACTER SET utf8mb4 ROW_FORMAT=DYNAMIC;

CREATE TABLE job_apply(
    id INT AUTO_INCREMENT NOT NULL,
    job_offer_id INT NOT NULL,
    resume_id INT NOT NULL,
    CONSTRAINT pk_job_apply_id PRIMARY KEY (id),
    CONSTRAINT fk_job_apply_area FOREIGN KEY(job_offer_id) REFERENCES job_offer(id),
    CONSTRAINT fk_job_apply_resume FOREIGN KEY(resume_id) REFERENCES resume(id)
    ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = innoDB CHARACTER SET utf8mb4;