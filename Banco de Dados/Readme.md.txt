README - Importação de Dados e Atualização de Relatório no MySQL

Descrição

Este script SQL realiza a importação de dados de arquivos CSV para tabelas temporárias e, em seguida, atualiza a tabela Relatorio_cadop com os dados importados.

Pré-requisitos

Antes de executar o script, certifique-se de:

Ter um servidor MySQL instalado e em execução.

Ter permissões para utilizar LOAD DATA INFILE (o secure_file_priv deve permitir importação de arquivos).

Garantir que os arquivos CSV estejam corretamente formatados e localizados no caminho especificado.

Configuração

Verifique as permissões do MySQL

Execute o seguinte comando para verificar se a importação de arquivos é permitida:

SHOW VARIABLES LIKE 'secure_file_priv';

Se necessário, altere a configuração no arquivo my.cnf (Linux/macOS) ou my.ini (Windows) para permitir importação de arquivos externos:

[mysqld]
secure_file_priv = ""

Reinicie o serviço MySQL após a alteração.

Confirme a existência das tabelas de destino

As tabelas 1T2023, 2T2023, 3T2023, 4T2023, 1T2024, 2T2024, 3T2024 e 4T2024 devem existir no banco de dados antes da execução.

Verifique os arquivos CSV

Certifique-se de que os arquivos 1T2023.csv, 2T2023.csv, etc., estão no caminho correto:C:/Users/Gean/Desktop/Teste/Repositorio/

O formato correto do CSV deve ser:

Campos separados por ;

Valores opcionais delimitados por "

Quebras de linha no formato \n

Primeira linha com cabeçalhos ignorada (IGNORE 1 ROWS no script)

Como Executar

Abra o terminal do MySQL ou um gerenciador como MySQL Workbench.

Conecte-se ao banco de dados desejado:

USE nome_do_banco;

Copie e cole o script SQL e execute-o.

Possíveis Problemas e Soluções

Erro de permissão ao carregar arquivos CSV

Verifique se secure_file_priv está configurado corretamente.

Tente executar com LOCAL:

LOAD DATA LOCAL INFILE 'C:/Users/Gean/Desktop/Teste/Repositorio/1T2023.csv'
INTO TABLE temp_1T2023
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

Erro de estrutura de tabela incompatível

Confirme que as tabelas temporárias possuem a mesma estrutura das tabelas originais.

Erro de caminho do arquivo

Use barras duplas (\\) em vez de barras simples (/) no Windows.

Confirme se o usuário MySQL tem acesso ao diretório dos arquivos CSV.

Autor

Criado por Gean.

