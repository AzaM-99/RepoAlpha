DROP TABLE IF EXISTS db.user_data cascade;
CREATE TABLE db.user_data
(
    -- P-Key
    id                  serial        NOT NULL,
    -- Data
    name                varchar(400)   NOT NULL,
    birth_date          date           NOT NULL,
    country             character varying(50)    NOT NULL DEFAULT 'FRANCE',

    phone               varchar(50)    NULL,
    -- Enumeration
    gender              int2           NULL     DEFAULT 0,
    -- Constraints
    CONSTRAINT pk_user_data_id PRIMARY KEY (id)
);
commit;
