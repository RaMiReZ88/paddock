/* ============================================================================
USER
============================================================================ */

CREATE SEQUENCE USR_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS USR (
    ID        INTEGER      NOT NULL,
    USERNAME  VARCHAR(255) NOT NULL,
    NICKNAME  VARCHAR(255) NOT NULL,
    AGE       DATE         NULL,
    CITY      VARCHAR(255) NULL,
    RATING    INTEGER      NOT NULL,
    USER_ROLE VARCHAR(255) NOT NULL
);

ALTER TABLE USR ADD CONSTRAINT PK_USR PRIMARY KEY (ID);
ALTER TABLE USR ADD CONSTRAINT UQ_USR_NICKNAME UNIQUE (NICKNAME);

/* ============================================================================
NEWS
============================================================================ */

CREATE SEQUENCE NEWS_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS NEWS (
    ID              INTEGER      NOT NULL,
    TITLE           VARCHAR(255) NOT NULL,
    CREATION_DATE   DATE         NOT NULL,
    DESCRIPTION     TEXT         NOT NULL,
    THEME           VARCHAR(255) NOT NULL,
    IMAGE           BYTEA        NOT NULL,
    USER_ID         INTEGER      NOT NULL
);

ALTER TABLE NEWS ADD CONSTRAINT PK_NEWS PRIMARY KEY (ID);
ALTER TABLE NEWS ADD CONSTRAINT UQ_NEWS_TITLE UNIQUE (TITLE);

/* ============================================================================
MOVIE
============================================================================ */

CREATE SEQUENCE MOVIE_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS MOVIE (
    ID           INTEGER      NOT NULL,
    TITLE        VARCHAR(255) NOT NULL,
    GENRE        VARCHAR(255) NOT NULL,
    DESCRIPTION  TEXT         NOT NULL,
    DURATION     INTEGER      NOT NULL,
    RATING       DECIMAL      NOT NULL,
    RELEASE_DATE DATE         NOT NULL,
    IMAGE        BYTEA        NOT NULL
);

ALTER TABLE MOVIE ADD CONSTRAINT PK_MOVIE PRIMARY KEY (ID);

/* ============================================================================
CLAN
============================================================================ */

CREATE SEQUENCE CLAN_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS CLAN (
    ID            INTEGER      NOT NULL,
    CLAN_NAME     VARCHAR(255) NOT NULL,
    RATING        INTEGER      NOT NULL,
    CREATION_DATE DATE         NOT NULL,
    PARTISIPANTS
);

ALTER TABLE CLAN ADD CONSTRAINT PK_CLAN PRIMARY KEY (ID);

/* ============================================================================
COMMENT
============================================================================ */

CREATE SEQUENCE COMMENT START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS COMMENT (
    ID INTEGER  NOT NULL,
    TEXT TEXT NOT NULL,
    DATE_ADDED TIMESTAMP NOT NULL,

);

ALTER TABLE COMMENT ADD CONSTRAINT PK_COMMENT PRIMARY KEY (ID);

/* ============================================================================
PAYMENT_HISTORY
============================================================================ */

CREATE SEQUENCE PAYMENT_HISTORY START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS PAYMENT_HISTORY (
    ID INTEGER NOT NULL,
    SUM_PAYMENT DECIMAL NOT NULL,
    PAYMENT_DATE TIMESTAMP  NOT NULL,
    STATUS
);

ALTER TABLE PAYMENT_HISTORY ADD CONSTRAINT PK_PAYMENT_HISTORY PRIMARY KEY (ID);

/* ============================================================================

============================================================================ */