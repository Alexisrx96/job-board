INSERT INTO `job_board`.`account_state` (`name`)
VALUES
('Activo'),('Inactivo'),('Pendiente'),('No aprobada');

INSERT INTO `job_board`.`account_type`
(`name`)
VALUES
('ROLE_ADMIN'),('ROLE_COMPANY'),('ROLE_PROFESSIONAL');
INSERT INTO `job_board`.`area`
(`name`)
VALUES
('IT');

INSERT INTO `job_board`.`job_offer_state`
(`name`)
VALUES
("Activa"),("Finalizada");



SELECT * FROM job_board.account;
SELECT * FROM job_board.profesional_profile;
SELECT * FROM `job_board`.`job_offer`;