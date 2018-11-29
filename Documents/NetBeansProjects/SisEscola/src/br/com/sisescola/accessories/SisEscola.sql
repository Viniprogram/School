DROP DATABASE IF EXISTS escola;

CREATE DATABASE escola;

USE escola;

CREATE TABLE ESCOLA(
    CNPJ CHAR(14) NOT NULL PRIMARY KEY,
    RAZAO_SOCIAL VARCHAR(45) NOT NULL,
    LOGRADOURO VARCHAR(40) NOT NULL,
    NUMERO SMALLINT(5) NOT NULL,
    COMPLEMENTO VARCHAR(10) NULL,
    BAIRRO VARCHAR(20) NOT NULL,
    CEP CHAR(8) NOT NULL,
    CIDADE VARCHAR(20) NOT NULL,
    UF CHAR(2) NOT NULL,
    FONE CHAR(10) NULL,
    EMAIL VARCHAR(40) NULL
);

CREATE TABLE ALUNO(
    MATRICULA INT(7) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FOTO LONGBLOB NULL,
    NOME VARCHAR(40) NOT NULL,
    SEXO CHAR (1) NOT NULL,  
    NASCIMENTO DATE NOT NULL,
    NACIONALIDADE VARCHAR(40) NOT NULL,  
    PAI VARCHAR(40) NULL,
    MAE VARCHAR(40) NOT NULL,
    RESP_FINANC VARCHAR(5) NOT NULL,
    CPF_RESP_FINANC CHAR(11) NOT NULL,
    NOME_OUTRO VARCHAR(40) NULL,  
    LOGRADOURO VARCHAR(40) NOT NULL,
    NUMERO SMALLINT(5) NOT NULL,
    COMPLEMENTO VARCHAR(10) NULL,
    BAIRRO VARCHAR(20) NOT NULL,
    CEP CHAR(8) NOT NULL,
    CIDADE VARCHAR(20) NOT NULL,
    UF CHAR(2) NOT NULL,
    FONE CHAR(10) NULL,
    CELULAR_RESP CHAR(11) NULL,
    EMAIL_RESP VARCHAR(40) NULL,
    BOLSISTA CHAR(1) NOT NULL,  
    ALERGIA CHAR(1) NOT NULL,
    TIPO_ALERGIA VARCHAR(40) NULL,
    DOENCA CHAR(1) NOT NULL,
    TIPO_DOENCA VARCHAR(40) NULL,  
    ID_TURMA INT(5) NOT NULL,
    FALTAS SMALLINT(3) NULL 
);

CREATE TABLE DISCIPLINA(
    CODDIS INT(3) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(20) NOT NULL,
    ID_PROFESSOR INT(5) NOT NULL  
);

CREATE TABLE TURMA(
    CODTURMA INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(15) NOT NULL,
    TURNO CHAR(5) NOT NULL  
);

CREATE TABLE PROFESSOR(
    CODPROF INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FOTO LONGBLOB NULL,  
    NOME VARCHAR(40) NOT NULL,  
    NASCIMENTO DATE NOT NULL,
    CPF CHAR(11) NOT NULL,
    RG CHAR(10) NOT NULL,  
    ADMISSAO DATE NOT NULL,
    DEMISSAO DATE NULL,
    LOGRADOURO VARCHAR(40) NOT NULL,
    NUMERO SMALLINT(5) NOT NULL,
    COMPLEMENTO VARCHAR(10) NULL,
    BAIRRO VARCHAR(20) NOT NULL,
    CEP CHAR(8) NOT NULL,
    CIDADE VARCHAR(20) NOT NULL,
    UF CHAR(2) NOT NULL,
    FONE CHAR(10) NULL,
    CELULAR CHAR(11) NOT NULL  
); 

CREATE TABLE USUARIO(
    ID_USUARIO INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,  
    LOGIN VARCHAR(40) NOT NULL,
    SENHA CHAR(8) NOT NULL  
);

CREATE TABLE ETAPA(
    CODETA INT(1) NOT NULL PRIMARY KEY,
    DESCRICAO VARCHAR(20) NOT NULL
);

CREATE TABLE AVALIACAO(
    CODAVA INT(2) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    DESCRICAO VARCHAR(20) NOT NULL
);

CREATE TABLE DIARIO_CLASSE(
    ID_ESCOLA CHAR(14) NOT NULL,
    ANO_LETIVO INT(4) NOT NULL,
    CURSO VARCHAR(40) NOT NULL,
    ID_TURMA INT(5) NOT NULL,
    CLASSE SMALLINT(3) NULL,
    ID_PROFESSOR INT(5) NOT NULL,
    ID_DISCIPLINA INT(3) NULL,
    ID_ETAPA INT(1) NOT NULL,
    
);

ALTER TABLE ALUNO ADD CONSTRAINT FK_ALUNO_TURMA
FOREIGN KEY (ID_TURMA) REFERENCES TURMA(CODTURMA)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE DISCIPLINA ADD CONSTRAINT FK_DISCIPLINA_PROFESSOR
FOREIGN KEY (ID_PROFESSOR) REFERENCES PROFESSOR(CODPROF)
ON DELETE RESTRICT ON UPDATE RESTRICT;
