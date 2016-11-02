SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attendance`
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `lesson_name` varchar(50) NOT NULL,
  `teacher_name` varchar(50) NOT NULL,
  `time` date NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('1', '数据结构', '数据结构', '吴斌', '2016-09-01', '数据结构');
INSERT INTO `attendance` VALUES ('2', '操作系统', '操作系统', '王曦曦', '2016-09-01', '操作系统');

-- ----------------------------
-- Table structure for `audition`
-- ----------------------------
DROP TABLE IF EXISTS `audition`;
CREATE TABLE `audition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson` varchar(50) NOT NULL,
  `student_id` int(11) NOT NULL,
  `time` date NOT NULL,
  `address` varchar(50) NOT NULL,
  `desecration` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audition
-- ----------------------------
INSERT INTO `audition` VALUES ('1', '数据结构', '1', '2016-09-01', '新1', '数据结构');
INSERT INTO `audition` VALUES ('2', '操作系统', '2', '2016-09-01', '新1', '操作系统');

-- ----------------------------
-- Table structure for `authority`
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '1', 'ADMIN', 'www.baidu.com', '无');
INSERT INTO `authority` VALUES ('2', '2', 'USER', 'www.douyu.com', '无');

-- ----------------------------
-- Table structure for `classroom`
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `number` int(11) NOT NULL,
  `device_info` varchar(255) NOT NULL,
  `remark` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES ('1', '新1', '30', '投影仪/电脑', '无');
INSERT INTO `classroom` VALUES ('2', '新1', '30', '投影仪/电脑', '无');

-- ----------------------------
-- Table structure for `clazz`
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `number` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `schedule_id` int(11) NOT NULL,
  `clazz_id` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('1', '数据结构', '2016-09-01', '2017-01-01', '30', '1', '1', '1', '1', '数据结构');
INSERT INTO `clazz` VALUES ('2', '操作系统', '2016-09-01', '2017-01-01', '30', '2', '2', '2', '2', '操作系统');

-- ----------------------------
-- Table structure for `communication`
-- ----------------------------
DROP TABLE IF EXISTS `communication`;
CREATE TABLE `communication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `time` date NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of communication
-- ----------------------------
INSERT INTO `communication` VALUES ('1', '1', '2016-10-09', '交流');
INSERT INTO `communication` VALUES ('2', '2', '2016-10-16', '交流');

-- ----------------------------
-- Table structure for `dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('1', '学习', '学习', '好好学习');
INSERT INTO `dictionary` VALUES ('2', '祝福', '祝福', '快乐生活');
INSERT INTO `dictionary` VALUES ('3', '健康', '健康', '幸福安康');

-- ----------------------------
-- Table structure for `email`
-- ----------------------------
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `send` varchar(50) NOT NULL,
  `receive` varchar(50) NOT NULL,
  `time` date NOT NULL,
  `receive_address` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email
-- ----------------------------
INSERT INTO `email` VALUES ('1', '吴斌', '王曦曦', '2017-01-01', '79223910@qq.com', '祝福', '快乐生活');
INSERT INTO `email` VALUES ('2', '王曦曦', '李璇', '2017-01-10', '328397651@qq.com', '学习', '好好学习');

-- ----------------------------
-- Table structure for `evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `lesson_name` varchar(50) NOT NULL,
  `teacher_name` varchar(50) NOT NULL,
  `time` date NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('1', '评价', '数据结构', '吴斌', '2017-01-15', '优秀');
INSERT INTO `evaluate` VALUES ('2', '评价', '操作系统', '王曦曦', '2017-01-15', '优秀');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT '0',
  `menu_name` varchar(30) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `level` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '0', '游戏', '', '', '1');
INSERT INTO `menu` VALUES ('2', '0', '音乐', '', '', '2');
INSERT INTO `menu` VALUES ('3', '0', '书籍', '', '', '3');
INSERT INTO `menu` VALUES ('4', '0', '体育', '', '', '4');
INSERT INTO `menu` VALUES ('5', '1', 'lol', '', 'http://www.baidu.com', '1.1');
INSERT INTO `menu` VALUES ('6', '1', 'dota2', '', 'http://www.baidu.com', '1.2');
INSERT INTO `menu` VALUES ('7', '2', '欧美', '', 'http://www.baidu.com', '2.1');
INSERT INTO `menu` VALUES ('8', '2', '华语', '', 'http://www.baidu.com', '2.2');
INSERT INTO `menu` VALUES ('9', '3', '小说', '', 'http://www.baidu.com', '3.1');
INSERT INTO `menu` VALUES ('10', '3', '文学', '', 'http://www.baidu.com', '3.2');
INSERT INTO `menu` VALUES ('11', '4', '篮球', '', 'http://www.baidu.com', '4.1');
INSERT INTO `menu` VALUES ('12', '4', '足球', '', 'http://www.baidu.com', '4.2');
INSERT INTO `menu` VALUES ('13', '4', '乒乓球', '', 'http://www.baidu.com', '4.3');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `send` varchar(50) NOT NULL,
  `time` date NOT NULL,
  `receive` varchar(50) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '王大波', '2016-12-25', '李璇', '13788659961', '祝福');
INSERT INTO `message` VALUES ('2', '李璇', '2017-01-01', '王曦曦', '15217856113', '健康');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '管理员');
INSERT INTO `role` VALUES ('2', '员工', '员工');
INSERT INTO `role` VALUES ('3', '老师', '老师');
INSERT INTO `role` VALUES ('4', '学员', '学员');

-- ----------------------------
-- Table structure for `role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority` (
  `role_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_authority
-- ----------------------------
INSERT INTO `role_authority` VALUES ('1', '1');
INSERT INTO `role_authority` VALUES ('2', '2');

-- ----------------------------
-- Table structure for `schedule`
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) NOT NULL,
  `monday` varchar(20) NOT NULL,
  `tuesday` varchar(20) NOT NULL,
  `wednesday` varchar(20) NOT NULL,
  `thursday` varchar(20) NOT NULL,
  `friday` varchar(20) NOT NULL,
  `saturday` varchar(20) NOT NULL,
  `sunday` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', '数据结构', '上午', '无', '下午', '无', '无', '无', '无');
INSERT INTO `schedule` VALUES ('2', '操作系统', '无', '上', '无', '无', '下午', '无', '无');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `lesson_name` varchar(50) NOT NULL,
  `score` double(11,0) NOT NULL,
  `time` date NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '1', '数据结构', '80', '2017-01-10', '优秀');
INSERT INTO `score` VALUES ('2', '2', '操作系统', '60', '2017-01-10', '及格');

-- ----------------------------
-- Table structure for `sellactivity`
-- ----------------------------
DROP TABLE IF EXISTS `sellactivity`;
CREATE TABLE `sellactivity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `start_time` date NOT NULL,
  `state` varchar(50) NOT NULL,
  `end_time` date NOT NULL,
  `type` varchar(50) NOT NULL,
  `budget_cost` double NOT NULL,
  `actual_cost` double NOT NULL,
  `reaction` varchar(50) NOT NULL,
  `expect_student_num` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sellactivity
-- ----------------------------
INSERT INTO `sellactivity` VALUES ('1', '软件大赛', '2016-10-07', '准备中', '2016-11-10', '省赛', '10000', '12000', '很好', '5', '省赛');
INSERT INTO `sellactivity` VALUES ('2', '软通动力杯', '2016-10-20', '进行中', '2016-11-20', '国赛', '10000', '10000', '良好', '5', '国赛');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `name` varchar(50) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` tinyint(2) NOT NULL,
  `age` int(3) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `hire_time` date NOT NULL,
  `role_id` int(11) NOT NULL,
  `province` varchar(20) NOT NULL,
  `idcard` varchar(20) NOT NULL,
  `birthday` date NOT NULL,
  `tel` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `education` varchar(50) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('光头强', '1', '0', '23', '15767676767', '15676767676', '2016-10-08', '2', '湖北', '42032119930101869673', '1993-01-05', '15893204713', '15676767676@qq.com', '湖北省武汉市', '本科', 'staff', 'Gtq', '123456');
INSERT INTO `staff` VALUES ('张三', '2', '0', '21', '18525252525', '18252525252', '2016-09-01', '2', '广州', '42390119950901898976', '1995-09-01', '15286973750', '18252525252@qq.com', '广州省天河区', '本科', 'staff', 'Zs', '123456');
INSERT INTO `staff` VALUES ('李蕊', '3', '1', '22', '18656565656', '18565656565', '2016-09-10', '2', '江苏', '32019941010869312', '1994-10-10', '15883927112', '185656565652qq.com', '江苏省苏州市', '本科', 'staff', 'Lr', '123456');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `name` varchar(50) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` tinyint(2) NOT NULL,
  `age` int(3) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `idcard` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `school` varchar(50) NOT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `parent_name` varchar(50) DEFAULT NULL,
  `province` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `parent_phone` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('王大波', '1', '0', '21', '13277878891', '569089665@qq.com', '42082319950910886170', '湖北省武汉市', '1995-09-10', '武汉理工大学', '569089669', '王强', '湖北', '武汉', '在读', '学生', '15223834782');
INSERT INTO `student` VALUES ('李璇', '2', '1', '21', '13788659961', '328397651@qq.com', '42988119950823669501', '湖南省岳阳市', '1995-08-23', '武汉理工大学', '328397651', '李建', '湖南', '岳阳', '在读', '学生', '13902761880');

-- ----------------------------
-- Table structure for `subject`
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `cost` double NOT NULL,
  `class_hour` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', '数据结构', '1000', '2', 'PRIMARY');
INSERT INTO `subject` VALUES ('2', '操作系统', '800', '2', 'PRIMARY');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `sex` tinyint(2) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `qq` varchar(20) NOT NULL,
  `hire_time` date NOT NULL,
  `role_id` int(11) NOT NULL,
  `province` varchar(20) NOT NULL,
  `idcard` varchar(20) NOT NULL,
  `birthday` date NOT NULL,
  `tel` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `education` varchar(50) NOT NULL,
  `remark` varchar(255) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '吴斌', '35', '0', '18962711056', '886769510', '2010-09-01', '3', '湖北省', '42398019810723998012', '1981-07-23', '027-88108951', '886769510@qq.com', '湖北省天门市', '博士', '无', 'Wb', '654321');
INSERT INTO `teacher` VALUES ('2', '王曦曦', '32', '1', '15217856113', '792239105', '2012-01-01', '3', '江苏省', '32069319840521689750', '1984-05-21', '0513-84566787', '79223910@qq.com', '江苏省南通市', '博士', '无', 'Wxx', '654321');

-- ----------------------------
-- Table structure for `template`
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of template
-- ----------------------------
INSERT INTO `template` VALUES ('1', '生日', '祝你生日快乐', '祝福');
INSERT INTO `template` VALUES ('2', '周年', '恭喜你入职5周年', '庆祝');

-- ----------------------------
-- Table structure for `trace`
-- ----------------------------
DROP TABLE IF EXISTS `trace`;
CREATE TABLE `trace` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `student_id` varchar(50) NOT NULL,
  `time` date NOT NULL,
  `next_time` date NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trace
-- ----------------------------
INSERT INTO `trace` VALUES ('1', '了解课程', '1', '2016-11-10', '2016-11-10', '有意向');
INSERT INTO `trace` VALUES ('2', '熟悉', '2', '2016-11-10', '2016-11-12', '意向强烈');