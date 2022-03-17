DROP TABLE IF EXISTS `PERSON` CASCADE;
CREATE TABLE `person` (
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT, 
	`bench_presskg` INTEGER, 
	`bicep_curlkg` INTEGER, 
	`habitat` INTEGER, 
	`name` VARCHAR(255) NOT NULL UNIQUE,
    `shoulder_presskg` INTEGER, 
    `squatkg` INTEGER 
);

