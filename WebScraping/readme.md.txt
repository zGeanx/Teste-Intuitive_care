# README - Web Scraping de PDFs da ANS

## Descrição

Este projeto realiza web scraping na página da ANS (Agência Nacional de Saúde Suplementar) para baixar arquivos PDF específicos e compactá-los em um arquivo ZIP.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- Java (versão 8 ou superior)
- Maven (opcional, caso deseje gerenciar dependências)
- Conexão com a internet

## Dependências

O projeto utiliza a biblioteca [JSoup](https://jsoup.org/) para realizar o scraping de dados da web. Certifique-se de baixar o arquivo JAR ou adicionar a dependência no seu projeto.

Se estiver utilizando Maven, adicione a seguinte dependência ao seu `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.jsoup</groupId>
        <artifactId>jsoup</artifactId>
        <version>1.13.1</version>
    </dependency>
</dependencies>
```

Caso contrário, baixe manualmente o JAR do [JSoup](https://jsoup.org/download) e adicione ao classpath do projeto.

## Como Executar

1. Clone ou baixe o repositório.

2. Compile o código-fonte utilizando o seguinte comando no terminal:

   ```sh
   javac -cp ".;jsoup-1.13.1.jar" WebScraping.java
   ```

   No Linux/macOS, use:

   ```sh
   javac -cp ":jsoup-1.13.1.jar" WebScraping.java
   ```

3. Execute o programa:

   ```sh
   java -cp ".;jsoup-1.13.1.jar" WebScraping
   ```

   No Linux/macOS:

   ```sh
   java -cp ":jsoup-1.13.1.jar" WebScraping
   ```

4. Os arquivos PDF baixados estarão na pasta `anexos`.

5. O arquivo compactado será salvo como `teste_gean.zip` no diretório do projeto.

## Possíveis Problemas e Soluções

- **Erro de conexão**: Verifique sua conexão com a internet e a disponibilidade da página da ANS.
- **Permissão negada**: No Linux/macOS, pode ser necessário rodar o comando com `sudo`.
- **Falta do JSoup**: Certifique-se de que a biblioteca está no classpath do Java.

## Autor

Criado por [Gean].

