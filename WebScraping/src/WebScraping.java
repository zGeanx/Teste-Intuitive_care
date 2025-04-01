import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraping {
    private static final String URL_ANS = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
    private static final String DOWNLOAD_DIR = "anexos";
    private static final String ZIP_FILE = "anexos_completos.zip";

    public static void main(String[] args) {
        try {
            // Cria o diretório de download
            Files.createDirectories(Paths.get(DOWNLOAD_DIR));
            
            //pega o html da página
            Document doc = Jsoup.connect(URL_ANS).get();
            Elements links = doc.select("a[href$=.pdf]");

            for (Element link : links) {
                String pdfUrl = link.absUrl("href");

                // Verificação se o PDF é "Anexo_I_" e "Anexo_II_"
                if (pdfUrl.contains("Anexo_I_") || pdfUrl.contains("Anexo_II_")) {
                    downloadFile(pdfUrl, DOWNLOAD_DIR);
                }
            }
            //compacta os aquivos em ZIP
            zipFiles(DOWNLOAD_DIR, ZIP_FILE);
            System.out.println("ZIP Gerado: " + ZIP_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Função para fazer o download dos arquivos
    private static void downloadFile(String fileURL, String saveDir) throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        int responseCode = httpCon.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1);
            InputStream inputStream = httpCon.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(saveDir + File.separator + fileName);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
            System.out.println("Baixado: " + fileName);
        }
        httpCon.disconnect();
    }
    //Funçao para compactar arquivos em um arquivo ZIP 
    private static void zipFiles(String sourceDir, String zipFile) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            Files.walk(Paths.get(sourceDir)).filter(Files::isRegularFile).forEach(path -> {
                try {
                    zos.putNextEntry(new ZipEntry(path.getFileName().toString()));
                    Files.copy(path, zos);
                    zos.closeEntry();
                    System.out.println("Adição ao ZIP: " + path.getFileName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
