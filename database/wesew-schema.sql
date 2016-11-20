-- Created: 2016-11-17 22:08
-- Model: wesew
-- Version: 1.0
-- Project: wesew
-- Author: Petrov Vladyslav Andreevich

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = TRADITIONAL, ALLOW_INVALID_DATES;

CREATE SCHEMA IF NOT EXISTS wesew
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS ARTICLE (
  id            INT(11)      NOT NULL AUTO_INCREMENT,
  title         VARCHAR(120) NOT NULL,
  body          TEXT         NULL     DEFAULT NULL,
  creation_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status        VARCHAR(20)  NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS IMAGE (
  id            VARCHAR(100) NOT NULL,
  url           VARCHAR(100) NOT NULL,
  title         VARCHAR(120) NOT NULL,
  creation_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status        VARCHAR(20)  NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS EVENT (
  id            INT(11)      NOT NULL,
  title         VARCHAR(120) NOT NULL,
  body          TEXT         NULL     DEFAULT NULL,
  creation_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status        VARCHAR(20)  NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS wesew.ARTICLE_HAS_IMAGE (
  article_id INT(11)      NOT NULL,
  image_id   VARCHAR(100) NOT NULL,
  PRIMARY KEY (article_id, image_id),
  INDEX fk_ARTICLE_has_IMAGE_IMAGE1_idx (image_id ASC),
  INDEX fk_ARTICLE_has_IMAGE_ARTICLE1_idx (article_id ASC),
  CONSTRAINT fk_ARTICLE_HAS_IMAGE_ARTICLE1
  FOREIGN KEY (article_id)
  REFERENCES wesew.ARTICLE (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ARTICLE_HAS_IMAGE_IMAGE1
  FOREIGN KEY (image_id)
  REFERENCES wesew.IMAGE (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS wesew.EVENT_HAS_IMAGE (
  event_id INT(11)      NOT NULL,
  image_id VARCHAR(100) NOT NULL,
  PRIMARY KEY (event_id, image_id),
  INDEX fk_EVENT_has_IMAGE_IMAGE1_idx (image_id ASC),
  INDEX fk_EVENT_has_IMAGE_EVENT1_idx (event_id ASC),
  CONSTRAINT fk_EVENT_HAS_IMAGE_EVENT1
  FOREIGN KEY (event_id)
  REFERENCES wesew.EVENT (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_EVENT_HAS_IMAGE_IMAGE1
  FOREIGN KEY (image_id)
  REFERENCES wesew.IMAGE (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
