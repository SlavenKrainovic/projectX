-- ALTER TABLE PRE_SET_GEARBOX ADD "FINAL_DRIVE_2" FLOAT NULL;
-- ALTER TABLE PRE_SET_GEARBOX ADD "FINAL_DRIVE_PATTERN" TEXT NULL;

INSERT INTO PRE_SET_GEARBOX ("ID", "NAME", "CAR_BRAND", "GEAR1", "GEAR2", "GEAR3", "GEAR4", "GEAR5", "GEAR6", "GEAR7", "FINAL_DRIVE", "FINAL_DRIVE_2", "FINAL_DRIVE_PATTERN") VALUES
('1','S80 5-Speed Manual', 'Honda', 3.230, 2.105, 1.458, 1.103, 0.848, 0, 0, 4.40, NULL, '1,1,1,1,1'),
('2','S4C 5-Speed LSD Manual', 'Honda', 3.266, 1.904, 1.269, 0.972, 0.780, 0, 0, 4.40, NULL, '1,1,1,1,1'),
('3','J1 5-Speed Manual', 'Honda', 3.166, 2.052, 1.416, 1.103, 0.870, 0, 0, 4.266, NULL, '1,1,1,1,1'),
('4','DQ250 HFQ', 'Volkswagen', 3.461, 2.050, 1.300, 0.902, 0.914, 0.756, 0, 4.118, 3.043, '1,1,1,1,2,2'),
('5','J1/S1 5-Speed Manual', 'Honda', 3.230, 2.105, 1.458, 1.107, 0.848, 0, 0, 4.40, NULL, '1,1,1,1,1'),
('6','DQ381/DQ500', 'Volkswagen', 3.75, 2.27, 1.53, 1.15, 0.86, 0.68, 0.56, 4.77, 3.450, '1,1,1,1,2,2,2'),
('7','Y21 5-Speed Manual', 'Honda', 3.23, 2.105, 1.458, 1.107, 0.848, 0, 0, 4.4, NULL, '1,1,1,1,1'),
('8','S4C 5-Speed Manual', 'Honda', 3.23, 2.105, 1.458, 1.107, 0.848, 0, 0, 4.4, NULL, '1,1,1,1,1'),
('9','YS1 5-Speed Manual', 'Honda', 3.307, 2.105, 1.458, 1.107, 0.848, 0, 0, 4.4, NULL, '1,1,1,1,1'),
('10','Y80 5-Speed Manual', 'Honda', 3.23, 1.9, 1.36, 1.034, 0.787, 0, 0, 4.4, NULL, '1,1,1,1,1'),
('11','S80/Y80 R 5-Speed Manual', 'Honda', 3.23, 2.105, 1.458, 1.034, 0.787, 0, 0, 4.4, NULL, '1,1,1,1,1'),
('12','S80 5-Speed R Manual', 'Honda', 3.23, 2.105, 1.458, 1.034, 0.787, 0, 0, 4.785, NULL, '1,1,1,1,1');
