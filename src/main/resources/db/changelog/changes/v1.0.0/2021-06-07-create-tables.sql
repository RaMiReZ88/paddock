--liquibase formatted
--changeset Amir:1

/* ============================================================================
USER
============================================================================ */

CREATE SEQUENCE USER_SEQ START WITH 1000 INCREMENT BY 1;

CREATE TYPE USER_ROLE AS ENUM ('ADMIN', 'USER', 'MODERATOR', 'NEWSMAKER', 'SUPPORT');

CREATE TABLE IF NOT EXISTS "USER"
(
    RECORD_ID             NUMERIC(19)                                           NOT NULL,
    NICKNAME              VARCHAR(255)                                          NOT NULL,
    LOGIN                 VARCHAR(255)                                          NOT NULL,
    PASSWORD              VARCHAR(255)                                          NOT NULL,
    EMAIL                 VARCHAR(255)                                          NOT NULL,
    BIRTHDAY              DATE                                                  NULL,
    CITY                  VARCHAR(255)                                          NULL,
    USER_ROLE             USER_ROLE                   DEFAULT 'USER'            NOT NULL,
    AVATAR                BYTEA                                                 NULL,
    REGISTRATION_DATETIME TIMESTAMP    WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    GAME_RATING           BIGINT                      DEFAULT 0                 NOT NULL,
    MEDIA_RATING          BIGINT                      DEFAULT 0                 NOT NULL,
    BANNED                BOOLEAN                     DEFAULT FALSE             NOT NULL,
    SUBSCRIPTION          BOOLEAN                     DEFAULT FALSE             NOT NULL,
    EXPIRATION_SUBS_DATE  TIMESTAMP                                             NULL,
    CLAN_ID               INTEGER                     DEFAULT NULL              NULL
);

ALTER TABLE "USER" ADD CONSTRAINT PK_USER PRIMARY KEY (RECORD_ID);
ALTER TABLE "USER" ADD CONSTRAINT UQ_USER_NICKNAME UNIQUE (NICKNAME);

/* ============================================================================
NEWS
============================================================================ */

CREATE SEQUENCE NEWS_SEQ START WITH 1000 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS NEWS
(
    RECORD_ID     NUMERIC(19)                                           NOT NULL,
    TITLE         VARCHAR(255)                                          NOT NULL,
    CREATION_DATE DATE         WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    DESCRIPTION   TEXT                                                  NOT NULL,
    THEME         VARCHAR(255)                                          NOT NULL,
    IMAGE         BYTEA                                                 NOT NULL,
    LIKES         INTEGER                     DEFAULT 0                 NOT NULL,
    DISLIKES      INTEGER                     DEFAULT 0                 NOT NULL
    USER_ID       INTEGER                                               NOT NULL
);

ALTER TABLE NEWS ADD CONSTRAINT PK_NEWS PRIMARY KEY (RECORD_ID);
ALTER TABLE NEWS ADD CONSTRAINT FK_NEWS_USER FOREIGN KEY (USER_ID) REFERENCES "USER" (RECORD_ID);

/* ============================================================================
MOVIE
============================================================================ */

CREATE SEQUENCE MOVIE_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS MOVIE (
    RECORD_ID    NUMERIC(19)  NOT NULL,
    TITLE        VARCHAR(255) NOT NULL,
    GENRE        VARCHAR(255) NOT NULL,
    DESCRIPTION  TEXT         NOT NULL,
    DURATION     INTEGER      NOT NULL,
    RATING       DECIMAL          NULL,
    RELEASE_DATE DATE             NULL,
    IMAGE        BYTEA        NOT NULL
);

ALTER TABLE MOVIE ADD CONSTRAINT PK_MOVIE PRIMARY KEY (RECORD_ID);

/* ============================================================================
CLAN
============================================================================ */

CREATE SEQUENCE CLAN_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS CLAN (
    RECORD_ID              NUMERIC(19)                             NOT NULL,
    CLAN_NAME              VARCHAR(255)                            NOT NULL,
    RATING                 INTEGER          DEFAULT 0              NOT NULL,
    ADMINS                 VARCHAR(255)[]   DEFAULT 1              NOT NULL,
    NUMBER_OF_PARTICIPANTS BIGINT           DEFAULT 1              NOT NULL,
    EMBLEM                 BYTEA                                   NOT NULL,
    PROFIT                 DOUBLE PRECISION DEFAULT 0              NOT NULL,
    DEFEAT                 BIGINT           DEFAULT 0              NOT NULL,
    VICTORIES              BIGINT           DEFAULT 0              NOT NULL,
    LOSS                   DOUBLE PRECISION DEFAULT 0              NOT NULL,
    CREATION_DATE          DATE             DEFAULT CURRENT_DATE   NOT NULL
);

ALTER TABLE CLAN ADD CONSTRAINT PK_CLAN PRIMARY KEY (RECORD_ID);
ALTER TABLE "USER" ADD CONSTRAINT FK_USER_CLAN FOREIGN KEY (CLAN_ID) REFERENCES CLAN(RECORD_ID);

/* ============================================================================
COMMENT
============================================================================ */

CREATE SEQUENCE COMMENT_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS COMMENT (
    RECORD_ID  NUMERIC(19)                                        NOT NULL,
    TEXT       TEXT                                               NOT NULL,
    DATE_ADDED TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    USR_ID     INTEGER                                            NOT NULL,
    NEWS_ID    INTEGER                                            NOT NULL
);

ALTER TABLE COMMENT ADD CONSTRAINT PK_COMMENT PRIMARY KEY (RECORD_ID);
ALTER TABLE COMMENT ADD CONSTRAINT FK_COMMENT_USER FOREIGN KEY (USER_ID) REFERENCES "USER" (RECORD_ID);
ALTER TABLE COMMENT ADD CONSTRAINT FK_COMMENT_NEWS FOREIGN KEY (NEWS_ID) REFERENCES NEWS (RECORD_ID);

/* ============================================================================
PAYMENT_HISTORY
============================================================================ */

CREATE TYPE STATUS AS ENUM ('SUCCESS', 'FAILED', 'PROCESSED');

CREATE SEQUENCE PAYMENT_HISTORY_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS PAYMENT_HISTORY (
    RECORD_ID    NUMERIC(19)                                        NOT NULL,
    SUM_PAYMENT  DECIMAL                                            NOT NULL,
    PAYMENT_DATE TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    STATUS       STATUS                                             NOT NULL,
    USER_ID      INTEGER                                            NOT NULL
);

ALTER TABLE PAYMENT_HISTORY ADD CONSTRAINT PK_PAYMENT_HISTORY PRIMARY KEY (RECORD_ID);
ALTER TABLE PAYMENT_HISTORY ADD CONSTRAINT FK_PAYMENT_HISTORY_USER FOREIGN KEY (USER_ID) REFERENCES "USER" (RECORD_ID);