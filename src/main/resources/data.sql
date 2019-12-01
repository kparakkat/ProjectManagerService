-- Insert Projects
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('1', 'Digital Mobile', '2019-11-23', '2019-12-15', '1');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('2', 'Analytics Metrics', '2020-01-02', '2020-01-30', '2');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('3', 'Book Portfolio', '2020-02-01', '2020-03-02', '3');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('4', 'Asset Reporting', '2020-03-05', '2020-03-25', '4');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('5', 'Alien Research', '2020-04-02', '2020-06-15', '5');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('6', 'Cam Insights', '2020-05-02', '2020-06-25', '5');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('7', 'Proof of Concepts', '2020-01-02', '2020-06-30', '2');
-- Insert Users
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`) VALUES ('1', 'Tim', 'Cook', '1231','5');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`) VALUES ('2', 'Jim', 'Stephen', '1232', '4');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`) VALUES ('3', 'Keren', 'Mike', '1233', '2');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`) VALUES ('4', 'John', 'Greg', '1234', '3');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`) VALUES ('5', 'Adam', 'Kris', '1235', '6');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`) VALUES ('6', 'Ray', 'Dan', '1236', '1');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`) VALUES ('7', 'Patrik', 'Mark', '1237','7');