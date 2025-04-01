INSERT INTO Relatorio_cadop
SELECT * FROM temp_relatorio
ON DUPLICATE KEY UPDATE 
    cnpj = VALUES(cnpj),
    razao_social = VALUES(razao_social),
    nome_fantasia = VALUES(nome_fantasia),
    modalidade = VALUES(modalidade),
    logradouro = VALUES(logradouro),
    numero = VALUES(numero),
    complemento = VALUES(complemento),
    bairro = VALUES(bairro),
    cidade = VALUES(cidade),
    uf = VALUES(uf),
    cep = VALUES(cep),
    ddd = VALUES(ddd),
    telefone = VALUES(telefone),
    fax = VALUES(fax),
    endereco_eletronico = VALUES(endereco_eletronico),
    representante = VALUES(representante),
    cargo_representante = VALUES(cargo_representante),
    regiao_comercializacao = VALUES(regiao_comercializacao),
    data_registro_ans = VALUES(data_registro_ans);
    
CREATE TEMPORARY TABLE temp_1T2023 LIKE `1T2023`;
LOAD DATA INFILE 'C:/Users/Gean/Desktop/Teste/Repositorio/1T2023.csv'
INTO TABLE temp_1T2023
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

CREATE TEMPORARY TABLE temp_2T2023 LIKE `2T2023`;
LOAD DATA INFILE 'C:/Users/Gean/Desktop/Teste/Repositorio/2T2023.csv'
INTO TABLE temp_2T2023
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

CREATE TEMPORARY TABLE temp_3T2023 LIKE `3T2023`;
LOAD DATA INFILE 'C:/Users/Gean/Desktop/Teste/Repositorio/3T2023.csv'
INTO TABLE temp_3T2023
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

CREATE TEMPORARY TABLE temp_4T2023 LIKE `4T2023`;
LOAD DATA INFILE 'C:/Users/Gean/Desktop/Teste/Repositorio/4T2023.csv'
INTO TABLE temp_4T2023
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

CREATE TEMPORARY TABLE temp_1T2024 LIKE `1T2024`;
LOAD DATA INFILE 'C:/Users/Gean/Desktop/Teste/Repositorio/1T2024.csv'
INTO TABLE temp_1T2024
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

CREATE TEMPORARY TABLE temp_2T2024 LIKE `2T2024`;
LOAD DATA INFILE 'C:/Users/Gean/Desktop/Teste/Repositorio/2T2024.csv'
INTO TABLE temp_2T2024
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

CREATE TEMPORARY TABLE temp_3T2024 LIKE `3T2024`;
LOAD DATA INFILE 'C:/Users/Gean/Desktop/Teste/Repositorio/3T2024.csv'
INTO TABLE temp_3T2024
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

CREATE TEMPORARY TABLE temp_4T2024 LIKE `4T2024`;
LOAD DATA INFILE 'C:/Users/Gean/Desktop/Teste/Repositorio/4T2024.csv'
INTO TABLE temp_4T2024
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;