--!drone table insert queries
INSERT INTO drone (serial_number, model, maximum_weight, battery_percentage, state) VALUES ( 'D360', 'LIGHTWEIGHT', 550, 30, 'LOADING');
INSERT INTO drone (serial_number, model, maximum_weight, battery_percentage, state) VALUES ( 'D560', 'MIDDLEWEIGHT', 850, 20, 'IDLE');
INSERT INTO drone (serial_number, model, maximum_weight, battery_percentage, state) VALUES ( 'D1000', 'CRUISERWEIGHT', 1250, 35, 'DELIVERING');
INSERT INTO drone (serial_number, model, maximum_weight, battery_percentage, state) VALUES ( 'D1250', 'HEAVYWEIGHT', 1500, 40, 'IDLE');
INSERT INTO drone (serial_number, model, maximum_weight, battery_percentage, state) VALUES ( 'D1500', 'LIGHTWEIGHT', 200, 60, 'DELIVERING');

--!medication table insert queries
INSERT INTO medication (name, weight, code, img) VALUES ('covex', 100, 'MED001', 'abcnhy438r9akjuwe7qoklf565gshcbnx65maswutjfkslde725dgj73hkdksk');
