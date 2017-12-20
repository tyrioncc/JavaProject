DROP TABLE IF EXISTS R6Matches;
DROP TABLE IF EXISTS R6Teams;
DROP TABLE IF EXISTS R6Players;

CREATE TABLE `R6Matches`(
  `match_id` BIGINT(20) NOT NULL COMMENT '比赛ID',
  `blue_team_name` varchar(100) NOT NULL COMMENT '蓝队名称',
  `red_team_name` varchar(100) NOT NULL COMMENT '红队名称',
  `win_team_name` varchar(100) NOT NULL COMMENT '红队名称',
  `turn` int(11) NOT NULL COMMENT '比赛回合数',
  PRIMARY KEY (`match_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='比赛记录';

CREATE TABLE `R6Teams`(
  `team_name` varchar(100) NOT NULL COMMENT '战队名称',
  `point` int(11) NOT NULL COMMENT '战力'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='比赛队伍';


CREATE TABLE `R6Players`(
  `player_id` BIGINT(20) NOT NULL COMMENT 'ID',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `sex` enum('男','女','保密')default '保密' COMMENT '性别',
  `team_name` varchar(100) NOT NULL COMMENT '战队名称',
  `kd` FLOAT NOT NULL COMMENT '战力',
  PRIMARY KEY (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='比赛队伍';


INSERT INTO `R6Matches` (`match_id`, `blue_team_name`, `red_team_name`, `win_team_name`,`turn`)
VALUES
  (1, 'TeamA', 'TeamB', 'TeamB', '6'),
  (2, 'TeamA', 'TeamC', 'TeamA', '4'),
  (3, 'TeamB', 'TeamC', 'TeamB', '5')
;

INSERT INTO `R6Teams` (`team_name`, `point`)
VALUES
  ('TeamA', 2000),
  ('TeamB', 2500),
  ('TeamC', 1800)
;

INSERT INTO `R6Players` (`player_id`, `name`, `team_name`, `kd`)
VALUES
  (1, 'Ash', 'TeamA', 1.9),
  (2, 'Fuze', 'TeamA', 1.2),
  (3, 'Mont', 'TeamA', 0.6),
  (4, 'Ela', 'TeamB', 1.6),
  (5, 'Jager', 'TeamB', 1.3),
  (6, 'Twitch', 'TeamB', 1.4),
  (7, 'Glaz', 'TeamC', 0.98),
  (8, 'Rook', 'TeamC', 1.3),
  (9, 'Ying', 'TeamC', 1.2)
;
