-- ShedLock 테이블 자동 생성 안 될 경우 사용
CREATE TABLE `shedlock` (
    `name` VARCHAR(64) NOT NULL,
    `lock_until` TIMESTAMP(3) NOT NULL,
    `locked_at` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    `locked_by` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`name`)
);
