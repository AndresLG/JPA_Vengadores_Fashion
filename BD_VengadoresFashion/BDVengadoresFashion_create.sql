-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-01-13 19:09:19.775

-- tables
-- Table: CLIENTE
CREATE TABLE CLIENTE (
    CODCLI integer  NOT NULL,
    NOMCLI varchar2(100)  NULL,
    ESTCLI varchar2(1)  DEFAULT 'A' NULL,
    CONSTRAINT CLIENTE_pk PRIMARY KEY (CODCLI)
) ;

-- Table: PROFESIONAL
CREATE TABLE PROFESIONAL (
    CODPRO integer  NOT NULL,
    TIPPRO varchar2(100)  NULL,
    PREPRO varchar2(10)  NULL,
    ESTPRO varchar2(1)  DEFAULT 'A' NULL,
    CONSTRAINT PROFESIONAL_pk PRIMARY KEY (CODPRO)
) ;

-- Table: SERVICIO
CREATE TABLE SERVICIO (
    CODSER integer  NOT NULL,
    CODCLI integer  NOT NULL,
    CODPRO integer  NOT NULL,
    CODTIPSER integer  NOT NULL,
    TOTPRESER varchar2(10)  NULL,
    CONSTRAINT SERVICIO_pk PRIMARY KEY (CODSER)
) ;

-- Table: SERVICIO_TIPO
CREATE TABLE SERVICIO_TIPO (
    CODTIPSER integer  NOT NULL,
    NOMTIPSER varchar2(100)  NULL,
    SUBTIPSER varchar2(50)  NULL,
    PRECTIPSER varchar2(10)  NULL,
    ESTTIPSER varchar2(10)  NULL,
    BARTIPSER varchar2(10)  NULL,
    INSTIPSER varchar2(10)  NULL,
    CONSTRAINT SERVICIO_TIPO_pk PRIMARY KEY (CODTIPSER)
) ;

-- foreign keys
-- Reference: SERVICIO_CLIENTE (table: SERVICIO)
ALTER TABLE SERVICIO ADD CONSTRAINT SERVICIO_CLIENTE
    FOREIGN KEY (CODCLI)
    REFERENCES CLIENTE (CODCLI);

-- Reference: SERVICIO_PROFESIONAL (table: SERVICIO)
ALTER TABLE SERVICIO ADD CONSTRAINT SERVICIO_PROFESIONAL
    FOREIGN KEY (CODPRO)
    REFERENCES PROFESIONAL (CODPRO);

-- Reference: SERVICIO_SERVICIO_TIPO (table: SERVICIO)
ALTER TABLE SERVICIO ADD CONSTRAINT SERVICIO_SERVICIO_TIPO
    FOREIGN KEY (CODTIPSER)
    REFERENCES SERVICIO_TIPO (CODTIPSER);

CREATE SEQUENCE "CLIENTE_SEQUENCE" MINVALUE 1 MAXVALUE 100000 INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE "PROFESIONAL_SEQUENCE" MINVALUE 1 MAXVALUE 100000 INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE "SERVICIO_TIPO_SEQUENCE" MINVALUE 1 MAXVALUE 100000 INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE "SERVICIO_SEQUENCE" MINVALUE 1 MAXVALUE 100000 INCREMENT BY 1 START WITH 1;

CREATE TRIGGER "CLIENTE_TRG"
   before insert on "CLIENTE"
   for each row
begin 
   if inserting then
      if :NEW."CODCLI" is null then
         select CLIENTE_SEQUENCE.nextval into :NEW."CODCLI" from dual;
      end if;
   end if;
end;

CREATE TRIGGER "PROFESIONAL_TRG"
   before insert on "PROFESIONAL"
   for each row
begin 
   if inserting then
      if :NEW."CODPRO" is null then
         select PROFESIONAL_SEQUENCE.nextval into :NEW."CODPRO" from dual;
      end if;
   end if;
end;

CREATE TRIGGER "SERVICIO_TIPO_TRG"
   before insert on "SERVICIO_TIPO"
   for each row
begin 
   if inserting then
      if :NEW."CODTIPSER" is null then
         select SERVICIO_TIPO_SEQUENCE.nextval into :NEW."CODTIPSER" from dual;
      end if;
   end if;
end;

CREATE TRIGGER "SERVICIO_TRG"
   before insert on "SERVICIO"
   for each row
begin 
   if inserting then
      if :NEW."CODSER" is null then
         select SERVICIO_SEQUENCE.nextval into :NEW."CODSER" from dual;
      end if;
   end if;
end;

-- End of file.

