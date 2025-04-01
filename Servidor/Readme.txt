Este é um servidor Flask que fornece uma API para buscar operadoras de planos de saúde a partir de um arquivo CSV. O servidor permite buscar por termos em vários campos relevantes e retorna resultados paginados ordenados por relevância.

Pré-requisitos
Python 3.x instalado

Pip (gerenciador de pacotes Python)

Instalação
Clone o repositório ou copie os arquivos do projeto para sua máquina

Crie um ambiente virtual (recomendado):

bash
Copy
python -m venv venv
Ative o ambiente virtual:

No Windows:

bash
Copy
venv\Scripts\activate
No Linux/MacOS:

bash
Copy
source venv/bin/activate
Instale as dependências:

bash
Copy
pip install flask pandas flask-cors
Certifique-se de que o arquivo CSV Relatorio_cadop.csv está no caminho especificado no código:
C:/Users/Gean/Desktop/Teste/Relatorio/Relatorio_cadop.csv

Executando o Servidor
Com o ambiente virtual ativado, execute:

bash
Copy
python nome_do_arquivo.py
(Substitua nome_do_arquivo.py pelo nome do arquivo onde você salvou o código)

O servidor estará rodando em:

Copy
http://127.0.0.1:5000
Utilizando a API
Endpoint
GET /buscar

Parâmetros
q: Termo de busca (obrigatório)

page: Número da página (padrão: 1)

per_page: Itens por página (padrão: 10)

Exemplo de Uso
Copy
http://127.0.0.1:5000/buscar?q=saude&page=1&per_page=5
Resposta
A API retornará um JSON com os seguintes campos:

total_results: Total de resultados encontrados

page: Página atual

per_page: Itens por página

results: Array com os resultados

Configuração
Para alterar o arquivo CSV ou campos de busca, edite as variáveis no código:

df = pd.read_csv('caminho/do/arquivo.csv', ...)

campos_relevantes = [...]

Dependências
Flask: Framework web

Pandas: Manipulação de dados

Flask-CORS: Habilita CORS para requisições entre domínios

Observações
O servidor está configurado para modo debug, o que é útil para desenvolvimento mas não deve ser usado em produção

Certifique-se de que o arquivo CSV está no formato correto e no caminho especificado

Para uso em produção, considere usar um servidor WSGI como Gunicorn ou uWSGI