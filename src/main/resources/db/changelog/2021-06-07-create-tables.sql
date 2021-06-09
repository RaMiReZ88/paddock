/* ============================================================================
USER
============================================================================ */

CREATE SEQUENCE USR_SEQ START WITH 1000 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS USR
(
    ID        INTEGER      NOT NULL,
    USERNAME  VARCHAR(255) NOT NULL,
    NICKNAME  VARCHAR(255) NOT NULL,
    AGE       DATE         NULL,
    CITY      VARCHAR(255) NULL,
    RATING    INTEGER      NOT NULL,
    USER_ROLE VARCHAR(255) NOT NULL
);

ALTER TABLE USR
    ADD CONSTRAINT PK_USR PRIMARY KEY (ID);
ALTER TABLE USR
    ADD CONSTRAINT UQ_USR_NICKNAME UNIQUE (NICKNAME);

/* ============================================================================
NEWS
============================================================================ */

CREATE SEQUENCE NEWS_SEQ START WITH 1000 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS NEWS
(
    ID            INTEGER      NOT NULL,
    TITLE         VARCHAR(255) NOT NULL,
    CREATION_DATE DATE         NOT NULL,
    DESCRIPTION   TEXT         NOT NULL,
    THEME         VARCHAR(255) NOT NULL,
    IMAGE         BYTEA        NOT NULL,
    USER_ID       INTEGER      NOT NULL
);

ALTER TABLE NEWS
    ADD CONSTRAINT PK_NEWS PRIMARY KEY (ID);