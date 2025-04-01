# README - Extração de Tabelas de PDF

## Descrição
Este projeto realiza a extração de tabelas de um arquivo PDF e salva os dados em um arquivo CSV. Em seguida, o arquivo CSV é compactado em um arquivo ZIP.

## Pré-requisitos
Antes de executar o projeto, certifique-se de ter instalado:

- **Java** (versão 8 ou superior)
- **Maven** (caso utilize para gerenciamento de dependências)
- **Bibliotecas Necessárias**:
  - [Apache PDFBox](https://pdfbox.apache.org/)
  - [Tabula](https://github.com/tabulapdf/tabula-java)

## Dependências
O projeto utiliza as bibliotecas **PDFBox** e **Tabula**. Se estiver usando Maven, adicione as seguintes dependências no seu `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.apache.pdfbox</groupId>
        <artifactId>pdfbox</artifactId>
        <version>2.0.27</version>
    </dependency>
    <dependency>
        <groupId>technology.tabula</groupId>
        <artifactId>tabula</artifactId>
        <version>1.0.4</version>
    </dependency>
</dependencies>
```

Caso não utilize Maven, baixe os arquivos JAR dessas bibliotecas e adicione ao classpath do projeto.

## Como Executar

1. Certifique-se de que o arquivo **Anexo_1.pdf** está no diretório do projeto.
2. Compile o código-fonte utilizando o seguinte comando no terminal:

   ```sh
   javac -cp ".;pdfbox-2.0.27.jar;tabula-1.0.4.jar" ExtractPdfTable.java
   ```

   No Linux/macOS:

   ```sh
   javac -cp ":pdfbox-2.0.27.jar:tabula-1.0.4.jar" ExtractPdfTable.java
   ```

3. Execute o programa:

   ```sh
   java -cp ".;pdfbox-2.0.27.jar;tabula-1.0.4.jar" ExtractPdfTable
   ```

   No Linux/macOS:

   ```sh
   java -cp ":pdfbox-2.0.27.jar:tabula-1.0.4.jar" ExtractPdfTable
   ```

4. Após a execução, os seguintes arquivos serão gerados:
   - **Rol_Procedimentos.csv**: Contém os dados extraídos da tabela do PDF.
   - **Teste_Gean.zip**: Arquivo ZIP contendo o CSV compactado.

## Possíveis Problemas e Soluções
- **Erro: O arquivo PDF não foi encontrado**: Certifique-se de que o arquivo **Anexo_1.pdf** está na pasta do projeto.
- **Falta de dependências**: Certifique-se de que as bibliotecas necessárias estão corretamente configuradas.
- **Permissão negada**: Em alguns sistemas, pode ser necessário executar o comando com `sudo`.

## Autor
Criado por Gean.

