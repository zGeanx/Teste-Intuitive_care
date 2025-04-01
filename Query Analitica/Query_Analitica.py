import mysql.connector
import pandas as pd

connection = mysql.connector.connect(
    host='127.0.0.1',
    user='root',
    password='',
    database='meu.banco'
)

# query para o último trimestre
query_ultimo_trimestre = """
SELECT 
    r.REG_ANS, 
    c.razao_social, 
    SUM(r.VL_SALDO_FINAL) AS total_despesas 
FROM `3T2024` r
JOIN Relatorio_cadop c ON r.REG_ANS = c.registro_ans 
WHERE r.DESCRICAO LIKE '%EVENTOS%' OR r.DESCRICAO LIKE '%SINISTROS%'
GROUP BY r.REG_ANS, c.razao_social 
ORDER BY total_despesas DESC 
LIMIT 10;
"""

# query para o último ano
query_ultimo_ano = """
SELECT 
    r.REG_ANS, 
    c.razao_social, 
    SUM(r.VL_SALDO_FINAL) AS total_despesas 
FROM ( 
    SELECT * FROM `1T2024` 
    UNION ALL 
    SELECT * FROM `2T2024` 
    UNION ALL 
    SELECT * FROM `3T2024` 
    UNION ALL 
    SELECT * FROM `4T2024` 
) r
JOIN Relatorio_cadop c ON r.REG_ANS = c.registro_ans 
WHERE r.DESCRICAO LIKE '%EVENTOS%' OR r.DESCRICAO LIKE '%SINISTROS%'
GROUP BY r.REG_ANS, c.razao_social 
ORDER BY total_despesas DESC 
LIMIT 10;
"""

# função para executar a query e retornar como DataFrame do Pandas
def executar_query(query):
    df = pd.read_sql(query, connection)
    return df

# executa as consultas
df_trimestre = executar_query(query_ultimo_trimestre)
df_ano = executar_query(query_ultimo_ano)

# exibi os resultados
print("10 operadoras com maiores despesas no último trimestre:")
print(df_trimestre)

print("\n10 operadoras com maiores despesas no último ano:")
print(df_ano)

# encerra
connection.close()
