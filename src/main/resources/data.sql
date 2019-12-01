-- Insert Projects
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('1', 'Digital Mobile', '2019-11-23', '2019-12-15', '1');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('2', 'Analytics Metrics', '2020-01-02', '2020-01-30', '2');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('3', 'Book Portfolio', '2019-11-20', '2020-03-30', '3');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('4', 'Asset Reporting', '2020-03-05', '2020-03-25', '4');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('5', 'Alien Research', '2020-04-02', '2020-06-15', '5');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('6', 'Cam Insights', '2020-05-02', '2020-06-25', '5');
INSERT IGNORE INTO `pmdb`.`project` (`projectid`, `project`, `startdate`, `enddate`, `priority`) VALUES ('7', 'Proof of Concepts', '2020-01-02', '2020-06-30', '2');
-- Insert Parent Tasks
INSERT IGNORE INTO `pmdb`.`parent_task` (`parenttaskid`, `parenttask`) VALUES ('1', 'Requirement Analysis, preparing BRD document and approval');
INSERT IGNORE INTO `pmdb`.`parent_task` (`parenttaskid`, `parenttask`) VALUES ('2', 'Design Document Preparation, Review and Approval');
INSERT IGNORE INTO `pmdb`.`parent_task` (`parenttaskid`, `parenttask`) VALUES ('3', 'Development and Unit Testing');
INSERT IGNORE INTO `pmdb`.`parent_task` (`parenttaskid`, `parenttask`) VALUES ('4', 'System Testing, Integration Testing and UAT Testing');
INSERT IGNORE INTO `pmdb`.`parent_task` (`parenttaskid`, `parenttask`) VALUES ('5', 'Production Release and Business and IT Validation');
INSERT IGNORE INTO `pmdb`.`parent_task` (`parenttaskid`, `parenttask`) VALUES ('6', 'Maintenance and Bug Fixes');
INSERT IGNORE INTO `pmdb`.`parent_task` (`parenttaskid`, `parenttask`) VALUES ('7', 'Others');
-- Insert Tasks
INSERT IGNORE INTO `pmdb`.`task` (`taskid`, `parenttaskid`, `projectid`, `task`, `startdate`, `enddate`, `priority`, `status`) VALUES ('1', '1', '3', 'Requirement Gathering', '2019-11-23', '2019-12-15', '5', 'In Progress');
INSERT IGNORE INTO `pmdb`.`task` (`taskid`, `parenttaskid`, `projectid`, `task`, `startdate`, `enddate`, `priority`, `status`) VALUES ('2', '1', '3', 'BRD Initial Draft', '2019-12-16', '2019-12-24', '8', 'Yet to start');
INSERT IGNORE INTO `pmdb`.`task` (`taskid`, `parenttaskid`, `projectid`, `task`, `startdate`, `enddate`, `priority`, `status`) VALUES ('3', '1', '3', 'BRD Review', '2020-01-02', '2020-01-05', '6', 'Yet to start');
INSERT IGNORE INTO `pmdb`.`task` (`taskid`, `parenttaskid`, `projectid`, `task`, `startdate`, `enddate`, `priority`, `status`) VALUES ('4', '1', '3', 'BRD Approval', '2020-01-06', '2020-01-10', '1', 'Yet to start');
INSERT IGNORE INTO `pmdb`.`task` (`taskid`, `parenttaskid`, `projectid`, `task`, `startdate`, `enddate`, `priority`, `status`) VALUES ('5', '2', '3', 'FSD Preparation', '2020-01-11', '2020-01-20', '5', 'In Progress');
INSERT IGNORE INTO `pmdb`.`task` (`taskid`, `parenttaskid`, `projectid`, `task`, `startdate`, `enddate`, `priority`, `status`) VALUES ('6', '2', '3', 'FSD Review', '2020-01-21', '2020-01-23', '2', 'Yet to start');
INSERT IGNORE INTO `pmdb`.`task` (`taskid`, `parenttaskid`, `projectid`, `task`, `startdate`, `enddate`, `priority`, `status`) VALUES ('7', '2', '3', 'FSD Approval', '2020-01-24', '2020-01-25', '1', 'Yet to start');
INSERT IGNORE INTO `pmdb`.`task` (`taskid`, `parenttaskid`, `projectid`, `task`, `startdate`, `enddate`, `priority`, `status`) VALUES ('8', '2', '3', 'Cooling Time to start development', '2020-01-26', '2020-01-30', '15', 'Yet to start');
-- Insert Users
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`,`taskid`) VALUES ('1', 'Tim', 'Cook', '1231','5','4');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`,`taskid`) VALUES ('2', 'Jim', 'Stephen', '1232', '4','2');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`,`taskid`) VALUES ('3', 'Keren', 'Mike', '1233', '2','1');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`,`taskid`) VALUES ('4', 'John', 'Greg', '1234', '3','3');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`,`taskid`) VALUES ('5', 'Adam', 'Kris', '1235', '6','6');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`,`taskid`) VALUES ('6', 'Ray', 'Dan', '1236', '1','5');
INSERT IGNORE INTO `pmdb`.`user` (`userid`, `firstname`, `lastname`,`employeeid`,`projectid`,`taskid`) VALUES ('7', 'Patrik', 'Mark', '1237','7','7');