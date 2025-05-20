CREATE TABLE `board` (
	`boardid`	int	NOT NULL	COMMENT '게시판id',
	`memberID`	varchar(8)	NOT NULL	COMMENT '회원 id는 최대 8글자 까지',
	`name`	varchar(255)	NOT NULL	COMMENT '회원이름은 한글 기준으로 255글자 까지',
	`title`	varchar(100)	NULL,
	`content`	text	NULL
);


CREATE TABLE `member` (
	`memberID`	varchar(8)	NOT NULL	COMMENT '회원 id는 최대 8글자 까지',
	`name`	varchar(255)	NOT NULL	COMMENT '회원이름은 한글 기준으로 255글자 까지',
	`tell`	varchar(20)	NULL	COMMENT '연락처는 전화번호/집번호 모두 허용함'
);

ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`boardid`,
	`memberID`,
	`name`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`memberID`,
	`name`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (
	`memberID`
)
REFERENCES `member` (
	`memberID`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_member_TO_board_2` FOREIGN KEY (
	`name`
)
REFERENCES `member` (
	`name`
);
