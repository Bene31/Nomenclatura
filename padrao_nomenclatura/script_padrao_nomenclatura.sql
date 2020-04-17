create database padrao_documento;

use padrao_documento;

CREATE TABLE IF NOT EXISTS `padrao_documento`.`T_SPDC_VOCB_CNTLD` (
  `ID_VOCB_CNTLD` INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador unico da tabela de vocabularios controlados.',
  `SG_VOCB_CNTLD` VARCHAR(10) NOT NULL COMMENT 'Sigla do termo usado no vocabulário controlado',
  `DS_VOCB_CNTLD` VARCHAR(1000) NOT NULL COMMENT 'Descricao do termo usado no vocabulario controlado',
  `FL_TIPO_VOCB_CNTLD` VARCHAR(1) NULL COMMENT 'Flag do tipo de vocabulario controlado usado para compor nomes de objetos e suas propriedades.');


CREATE INDEX `PK_VOCB_CONTLD` ON `padrao_documento`.`T_SPDC_VOCB_CNTLD` (`ID_VOCB_CNTLD` ASC);

CREATE TABLE IF NOT EXISTS `padrao_documento`.`T_SPDC_PRFX` (
  `ID_PRFX` INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador unico do prefixo de objetos do banco. Por exemplo, DS para atributos usados como descricao, e T para tabelas.',
  `SG_PRFX` VARCHAR(4) NOT NULL COMMENT 'Sigla do prefixo de objeto de banco.',
  `DS_TIPO_DADO_PRFX` VARCHAR(400) NOT NULL COMMENT 'Descricao do tipo de dado do prefixo de objeto',
  `DS_CNTD_PRFX` VARCHAR(400) NOT NULL COMMENT 'Descricao do conteudo do prefixo de objeto',
  `DS_EXPLO_PRFX` VARCHAR(400) NOT NULL COMMENT 'Descricao do exemplo do prefixo',
  `DS_DFNC_PRFX` VARCHAR(400) NOT NULL COMMENT 'Descricao ampla da definicao do prefixo de objeto.');


CREATE INDEX `PK_PRFX_OBJT` ON `padrao_documento`.`T_SPDC_PRFX` (`ID_PRFX` ASC);

CREATE TABLE IF NOT EXISTS `padrao_documento`.`T_TIPO_OBJT` (
  `ID_TIPO_OBJT` INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único do tipo do objeto',
  `DS_TIPO_OBJT` VARCHAR(45) NOT NULL COMMENT 'Descricao do tipo de objeto');


CREATE TABLE IF NOT EXISTS `padrao_documento`.`T_SPDC_OBJT` (
  `ID_OBJT` INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único do objeto inserido no sistema de padronizao de documentos.',
  `ID_TIPO_OBJT` INT DEFAULT NULL,
  `ID_PRFX` INT DEFAULT NULL COMMENT 'Identificador único do prefixo que compoe o nome do objeto',
  `NM_OBJT` VARCHAR(50) NOT NULL COMMENT 'Nome do objeto de padronizacao de documentos.',
  `DC_OBJT` VARCHAR(1000) NULL COMMENT 'Descricao a respeito do objeto.',
  CONSTRAINT `fk_tipo_objt_01` FOREIGN KEY (`ID_TIPO_OBJT`) REFERENCES `padrao_documento`.`T_TIPO_OBJT` (`ID_TIPO_OBJT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_prfx_objt_02` FOREIGN KEY (`ID_PRFX`) REFERENCES `padrao_documento`.`T_SPDC_PRFX` (`ID_PRFX`) ON DELETE NO ACTION ON UPDATE NO ACTION);


CREATE INDEX `IX_SPDC_OBJT01` ON `padrao_documento`.`T_SPDC_OBJT` (`ID_TIPO_OBJT` ASC);
CREATE INDEX `FK_PRFX_OBJT_01` ON `padrao_documento`.`T_SPDC_OBJT` (`ID_PRFX` ASC);

CREATE TABLE IF NOT EXISTS `padrao_documento`.`T_SPDC_OBJT_VOCB_CNTLD` (
  `ID_OBJT` INT DEFAULT NULL COMMENT 'Identificador único do objeto inserido no sistema de padronizao de documentos.',
  `ID_VOCB_CNTLD` INT DEFAULT NULL COMMENT 'Identificador unico da tabela de vocabularios controlados.',
  PRIMARY KEY (`ID_OBJT`, `ID_VOCB_CNTLD`),
  CONSTRAINT `FK_SPDC_OBJT_VOCB_CNTLD` FOREIGN KEY (`ID_OBJT`) REFERENCES `padrao_documento`.`T_SPDC_OBJT` (`ID_OBJT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SPDC_VOCB_CNTLD` FOREIGN KEY (`ID_VOCB_CNTLD`) REFERENCES `padrao_documento`.`T_SPDC_VOCB_CNTLD` (`ID_VOCB_CNTLD`) ON DELETE NO ACTION ON UPDATE NO ACTION);


CREATE INDEX `IX_SPDC_VOCB_CNTLD` ON `padrao_documento`.`T_SPDC_OBJT_VOCB_CNTLD` (`ID_VOCB_CNTLD` ASC);
CREATE INDEX `IX_SPDC_OBJT_VOCB_CNTLD` ON `padrao_documento`.`T_SPDC_OBJT_VOCB_CNTLD` (`ID_OBJT` ASC);

CREATE TABLE IF NOT EXISTS `padrao_documento`.`T_SPDC_PRPD_OBJT` (
  `ID_PRPD_OBJT` INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador unico das propriedades de um objeto.',
  `ID_PRFX` INT DEFAULT NULL COMMENT 'Identificador unico do prefixo de objetos do banco. Por exemplo, DS para atributos usados como descricao, e T para tabelas.',
  `ID_OBJT` INT DEFAULT NULL COMMENT 'Identificador único do objeto inserido no sistema de padronizao de documentos.',
  `NM_PRPD_OBJT` VARCHAR(50) NOT NULL,
  `DC_PRPD_OBJT` VARCHAR(1000) NOT NULL,
  CONSTRAINT `FK_OBJT_PRPD_01` FOREIGN KEY (`ID_OBJT`) REFERENCES `padrao_documento`.`T_SPDC_OBJT` (`ID_OBJT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRFX_PRPD_OBJT_02` FOREIGN KEY (`ID_PRFX`) REFERENCES `padrao_documento`.`T_SPDC_PRFX` (`ID_PRFX`) ON DELETE NO ACTION ON UPDATE NO ACTION);


CREATE INDEX `IX_SPDC_OBJT_PRPD1` ON `padrao_documento`.`T_SPDC_PRPD_OBJT` (`ID_OBJT` ASC);
CREATE INDEX `IX_SPDC_OBJT_PRPD2` ON `padrao_documento`.`T_SPDC_PRPD_OBJT` (`ID_PRFX` ASC);

CREATE TABLE IF NOT EXISTS `padrao_documento`.`T_SPDC_PRPD_VOCB_CNTLD` (
  `ID_PRPD_OBJT` INT DEFAULT NULL COMMENT 'Identificador unico das propriedades de um objeto.',
  `ID_VOCB_CNTLD` INT DEFAULT NULL COMMENT 'Identificador unico da tabela de vocabularios controlados.',
  PRIMARY KEY (`ID_PRPD_OBJT`, `ID_VOCB_CNTLD`),
  CONSTRAINT `FK_SPDC_PRPD_VOCB_CNTLD01` FOREIGN KEY (`ID_VOCB_CNTLD`) REFERENCES `padrao_documento`.`T_SPDC_VOCB_CNTLD` (`ID_VOCB_CNTLD`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SPDC_PRPD_VOCB_CNTLD02` FOREIGN KEY (`ID_PRPD_OBJT`) REFERENCES `padrao_documento`.`T_SPDC_PRPD_OBJT` (`ID_PRPD_OBJT`) ON DELETE NO ACTION ON UPDATE NO ACTION);


CREATE INDEX `IX_SPDC_PRPD_VOCB_CNTLD` ON `padrao_documento`.`T_SPDC_PRPD_VOCB_CNTLD` (`ID_VOCB_CNTLD` ASC);

CREATE TABLE IF NOT EXISTS `padrao_documento`.`T_SPDC_PRMT_ACSSO_TXTO` (
  `ID_PRMT_ACSSO_TXTO` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `DS_PRMT_ACSSO_TXTO` VARCHAR(100) NULL COMMENT 'Descricao do parametro de acesso a texto. Por exemplo, PUBLIC CLASS, CREATE TABLE.',
  `NU_INIC_ACSSO_TXTO` VARCHAR(10) NULL COMMENT 'Numero do inicio de acesso ao texto lido.',
  `NU_FIM_ACSSO_TXTO` VARCHAR(10) NULL COMMENT 'Numero do fim de acesso ao texto lido.',
  `FL_INIC_ACSSO_TXTO` VARCHAR(5) NULL COMMENT 'Flag de inicio de leitura do acesso ao texto a ser reconhecido na leitura de um documento a ser verificado de acordo com os padrÃµes.',
  `FL_FIM_ACSSO_TXTO` VARCHAR(5) NULL COMMENT 'Flag de fim de leitura do acesso ao texto a ser reconhecido na leitura de um documento a ser verificado de acordo com os padrÃµes.',
  `IC_TIPO_ACSSO_TXTO` VARCHAR(100) NULL COMMENT 'Indicador do tipo do texto a ser lido. (T) Tabela, (P) Primary Key, Foreign Key (F).')



