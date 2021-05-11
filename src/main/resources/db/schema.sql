/* ============================================================================
USER
============================================================================ */

CREATE SEQUENCE USR_SEQ START WITH 1000 INCREMENT BY 1;

CREATE TABLE USR (
    ID       INTEGER      NOT NULL,
    USERNAME VARCHAR(255) NOT NULL,
    NICKNAME VARCHAR(255) NOT NULL,
    AGE      DATE         NULL,
    CITY     VARCHAR(255) NULL,
    RATING   INTEGER      NOT NULL,
    ROLE     VARCHAR(255) NOT NULL
);

ALTER TABLE USR ADD CONSTRAINT PK_USR PRIMARY KEY (ID)
ALTER TABLE USR ADD CONSTRAINT UQ_USR_NICKNAME UNIQUE (NICKNAME)

/* ============================================================================

============================================================================ */
