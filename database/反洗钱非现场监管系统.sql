INSERT INTO T_PUB_PRIVILEGE (PID, PNAME, PISMENU, PPID) VALUES (1505, '一级指标管理', 1, 60);
INSERT INTO T_PUB_PRIVILEGE (PID, PNAME, PISMENU, PPID) VALUES (1507, '二级指标管理', 1, 60);

INSERT INTO T_PUB_RESOURCE (PRID, PID, PRNAME, PRISMENU, PRURL, PRUPDATETIME, PRAUTHOR) VALUES ('1505', 1505, '一级指标管理', 1, 'assess/assess_oneClassIndex.shtml', '2017/03/01', 'liuxz');
INSERT INTO T_PUB_RESOURCE (PRID, PID, PRNAME, PRISMENU, PRURL, PRUPDATETIME, PRAUTHOR) VALUES ('1507', 1507, '二级指标管理', 1, 'assess/assess_twoClassIndex.shtml', '2017/09/05', 'lyl');

INSERT INTO T_PUB_PRIVILEGE (PID, PNAME, PISMENU, PPID) VALUES (1508, '金融机构自评管理', 1, 60);
INSERT INTO T_PUB_RESOURCE (PRID, PID, PRNAME, PRISMENU, PRURL, PRUPDATETIME, PRAUTHOR) VALUES ('1508', 1508, '金融机构自评管理', 1, 'assess/assess_selfAssessment.shtml', '2017/09/05', 'lyl');
INSERT INTO T_PUB_PRIVILEGE (PID, PNAME, PISMENU, PPID) VALUES (1509, '金融机构评级异议', 1, 60);
INSERT INTO T_PUB_RESOURCE (PRID, PID, PRNAME, PRISMENU, PRURL, PRUPDATETIME, PRAUTHOR) VALUES ('1509', 1509, '金融机构评级异议', 1, 'assess/assess_applyOppositionList.shtml', '2017/09/07', 'lyl');

INSERT INTO T_PUB_PRIVILEGE (PID, PNAME, PISMENU, PPID) VALUES (1514, '异议申请处理查询界面', 1, 60);
INSERT INTO T_PUB_RESOURCE (PRID, PID, PRNAME, PRISMENU, PRURL, PRUPDATETIME, PRAUTHOR) VALUES ('1514', 1514, '异议申请处理查询界面', 1, 'assess/assess_manageOppositionList.shtml', '2017/09/08', 'lyl');

INSERT INTO T_PUB_PRIVILEGE (PID, PNAME, PISMENU, PPID) VALUES (1515, '评级状态管理', 1, 60);
INSERT INTO T_PUB_RESOURCE (PRID, PID, PRNAME, PRISMENU, PRURL, PRUPDATETIME, PRAUTHOR) VALUES ('1515', 1515, '评级状态管理', 1, 'assess/assess_assessmentStatusManager.shtml', '2017/09/08', 'lyl');





//
insert into T_PUB_PRIVILEGE (PID, PNAME, PISMENU, PPID) VALUES
(1506, '人行初评', 1, 60);

insert into T_PUB_RESOURCE (PRID, PID, PRNAME, PRISMENU, PRURL, PRUPDATETIME, PRAUTHOR) VALUES
('1506', 1506, '人行初评', 1, 'assess/peopleBankFirstRate.shtml', '', 'yuanpc');


insert into T_PUB_PRIVILEGE (PID, PNAME, PISMENU, PPID) VALUES
(1510, '监管意见书管理(人行端)', 1, 60);


insert into T_PUB_RESOURCE (PRID, PID, PRNAME, PRISMENU, PRURL, PRUPDATETIME, PRAUTHOR) VALUES
('1510', 1510, '监管意见书管理(人行端)', 1, 'assess/assess_superviseOpinionManager.shtml', '', 'yuanpc');



insert into T_PUB_PRIVILEGE (PID, PNAME, PISMENU, PPID) VALUES
(1511, '监管意见书管理(机构端)', 1, 60);

insert into T_PUB_RESOURCE (PRID, PID, PRNAME, PRISMENU, PRURL, PRUPDATETIME, PRAUTHOR) VALUES
('1511', 1511, '监管意见书管理(机构端)', 1, 'assess/assess_superviseOpinionBankManager.shtml', '', 'yuanpc');




insert into T_PUB_PRIVILEGE (PID, PNAME, PISMENU, PPID) VALUES
(1512, '整改报告管理(人行端)', 1, 60);

insert into T_PUB_RESOURCE (PRID, PID, PRNAME, PRISMENU, PRURL, PRUPDATETIME, PRAUTHOR) VALUES
('1512', 1512, '整改报告管理(人行端)', 1, 'assess/assess_rectificationReportManager.shtml', '', 'yuanpc');

insert into T_PUB_PRIVILEGE (PID, PNAME, PISMENU, PPID) VALUES
(1513, '整改报告管理(机构端)', 1, 60);

insert into T_PUB_RESOURCE (PRID, PID, PRNAME, PRISMENU, PRURL, PRUPDATETIME, PRAUTHOR) VALUES
('1513', 1513, '整改报告管理(机构端)', 1, 'assess/assess_rectificationReportBankManager.shtml', '', 'yuanpc');




