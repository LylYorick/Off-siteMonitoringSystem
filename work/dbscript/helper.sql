--==============================================================
-- DBMS name:      IBM DB2 UDB 8.x Common Server
-- Created on:     2010/5/4 16:36:39
--==============================================================


ALTER TABLE P_NAV
   DROP FOREIGN KEY "F_RELATIONSHIP_2";

ALTER TABLE P_NODE
   DROP FOREIGN KEY "F_RELATIONSHIP_1";

DROP TABLE P_FUNCTION;

DROP INDEX "RELATIONSHIP_2_FK";

DROP TABLE P_NAV;

DROP INDEX "RELATIONSHIP_1_FK";

DROP TABLE P_NODE;

--==============================================================
-- Table: P_FUNCTION
--==============================================================
CREATE TABLE P_FUNCTION
(
   ID                   INTEGER                NOT NULL,
   "NODENAME"           VARCHAR(40)            NOT NULL,
   CONSTRAINT "P_IDENTIFIER_1" PRIMARY KEY (ID)
);

--==============================================================
-- Table: P_NAV
--==============================================================
CREATE TABLE P_NAV
(
   VID                  INTEGER                NOT NULL,
   NID                  INTEGER,
   VNAME                VARCHAR(40)            NOT NULL,
   NODEID               INTEGER                NOT NULL,
   URL                  VARCHAR(80)            NOT NULL,
   CONSTRAINT "P_IDENTIFIER_1" PRIMARY KEY (VID)
);

--==============================================================
-- Index: "RELATIONSHIP_2_FK"
--==============================================================
CREATE INDEX "RELATIONSHIP_2_FK" ON P_NAV (
   NID                  ASC
);

--==============================================================
-- Table: P_NODE
--==============================================================
CREATE TABLE P_NODE
(
   NID                  INTEGER                NOT NULL,
   ID                   INTEGER,
   N_NAME               VARCHAR(40)            NOT NULL,
   PID                  INTEGER                NOT NULL,
   CONSTRAINT "P_IDENTIFIER_1" PRIMARY KEY (NID)
);

--==============================================================
-- Index: "RELATIONSHIP_1_FK"
--==============================================================
CREATE INDEX "RELATIONSHIP_1_FK" ON P_NODE (
   ID                   ASC
);

ALTER TABLE P_NAV
   ADD CONSTRAINT "F_RELATIONSHIP_2" FOREIGN KEY (NID)
      REFERENCES P_NODE (NID)
      ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE P_NODE
   ADD CONSTRAINT "F_RELATIONSHIP_1" FOREIGN KEY (ID)
      REFERENCES P_FUNCTION (ID)
      ON DELETE RESTRICT ON UPDATE RESTRICT;

