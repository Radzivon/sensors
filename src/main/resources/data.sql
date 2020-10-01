-- -----------------------------------------------------
-- Data for table `monitor_sensor`.`sensor_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `monitor_sensor`;
INSERT INTO `monitor_sensor`.`sensor_type` (`id`, `value`) VALUES (1, 'Pressure');
INSERT INTO `monitor_sensor`.`sensor_type` (`id`, `value`) VALUES (2, 'Voltage');
INSERT INTO `monitor_sensor`.`sensor_type` (`id`, `value`) VALUES (3, 'Temperature');
INSERT INTO `monitor_sensor`.`sensor_type` (`id`, `value`) VALUES (4, 'Humidity');

COMMIT;


-- -----------------------------------------------------
-- Data for table `monitor_sensor`.`sensor_unit`
-- -----------------------------------------------------
START TRANSACTION;
USE `monitor_sensor`;
INSERT INTO `monitor_sensor`.`sensor_unit` (`id`, `value`, `sensor_type_id`) VALUES (1, 'bar', 1);
INSERT INTO `monitor_sensor`.`sensor_unit` (`id`, `value`, `sensor_type_id`) VALUES (2, 'voltage', 2);
INSERT INTO `monitor_sensor`.`sensor_unit` (`id`, `value`, `sensor_type_id`) VALUES (3, '℃', 3);
INSERT INTO `monitor_sensor`.`sensor_unit` (`id`, `value`, `sensor_type_id`) VALUES (4, '%', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `monitor_sensor`.`role`
-- -----------------------------------------------------
START TRANSACTION;
USE `monitor_sensor`;
INSERT INTO `monitor_sensor`.`role` (`id`, `name`) VALUES (1, 'Administrator');
INSERT INTO `monitor_sensor`.`role` (`id`, `name`) VALUES (2, 'Viewer');

COMMIT;


-- -----------------------------------------------------
-- Data for table `monitor_sensor`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `monitor_sensor`;
INSERT INTO `monitor_sensor`.`users` (`id`, `username`, `password`, `role_id`) VALUES (1, 'user1', '111111', 1);
INSERT INTO `monitor_sensor`.`users` (`id`, `username`, `password`, `role_id`) VALUES (2, 'user2', '111111', 2);

COMMIT;