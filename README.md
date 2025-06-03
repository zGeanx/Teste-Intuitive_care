# 🩺 Sistema de Processamento de Dados ANS

**Autor:** Gean  
**Descrição:** Solução integrada para coleta, análise e visualização de dados da ANS (Agência Nacional de Saúde Suplementar), utilizando técnicas de web scraping, processamento de PDFs, APIs e visualização interativa.

---

## 🚀 Tecnologias Utilizadas

- **Backend:**
  - Java (Web Scraping com Jsoup, processamento de PDFs com PDFBox e Tabula)
  - Python (API REST com Flask)
- **Banco de Dados:**
  - MySQL
- **Frontend:**
  - Vue.js
- **Bibliotecas e Ferramentas:**
  - Pandas
  - Flask-CORS
  - MySQL Connector
  - Postman (para testes de API)

---

## ⚙️ Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu ambiente de desenvolvimento:

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [Python 3.8+](https://www.python.org/downloads/)
- [MySQL 5.7+](https://dev.mysql.com/downloads/mysql/)
- [Node.js 14+](https://nodejs.org/en/download/)

---

## 🛠️ Instalação e Execução

### 1. Backend Java (Web Scraping e Processamento de PDFs)

- Instale as bibliotecas necessárias:
  - [Jsoup](https://jsoup.org/)
  - [PDFBox](https://pdfbox.apache.org/)
  - [Tabula](https://tabula.technology/)

- Compile e execute os arquivos Java localizados na pasta `WebScraping`.

### 2. API Python (Flask)

- Navegue até o diretório `Servidor`:

  ```bash
  cd Servidor
  ```

- Instale as dependências:

  ```bash
  pip install flask flask-cors pandas mysql-connector-python
  ```

- Inicie a API:

  ```bash
  python api.py
  ```

### 3. Frontend Vue.js

- Navegue até o diretório `Relatorio`:

  ```bash
  cd Relatorio
  ```

- Instale as dependências:

  ```bash
  npm install
  ```

- Inicie o servidor de desenvolvimento:

  ```bash
  npm run serve
  ```

---

## 📂 Estrutura do Projeto

```
Teste-Intuitive_care/
├── Banco de Dados/
├── ExtractPdfTable/
├── Postman/
├── Query Analitica/
├── Relatorio/
├── Repositorio/
├── Servidor/
├── WebScraping/
├── README.md
└── Teste_Gean.zip
```

---

## 📊 Funcionalidades

- Coleta automatizada de dados da ANS via web scraping
- Extração e processamento de informações de arquivos PDF
- Armazenamento estruturado em banco de dados MySQL
- API RESTful para acesso e manipulação dos dados
- Interface web interativa para visualização e análise dos dados

---

## 🧪 Testes

- Utilize o Postman para testar as rotas da API disponíveis na pasta `Postman`.

---

## 📄 Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo [LICENSE](LICENSE) para obter mais detalhes.

---

## 📞 Contato

Para dúvidas ou sugestões, entre em contato:

- **GitHub:** [zGeanx](https://github.com/zGeanx)
- **Email:** [seu-email@example.com](geanlucadias12@gmail.com)

---

