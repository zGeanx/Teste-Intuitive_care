//code by Gean

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.*;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

public class ExtractPdfTable {
    private static final String PDF_FILE = System.getProperty("user.dir") + "/Anexo_1.pdf";
    private static final String CSV_FILE = "Rol_Procedimentos.csv";
    private static final String ZIP_FILE = "Teste_SeuNome.zip";

    public static void main(String[] args) {
        try {
            // Verifica se o PDF existe
            if (!Files.exists(Paths.get(PDF_FILE))) {
                System.err.println("Erro: O arquivo PDF não foi encontrado: " + PDF_FILE);
                return;
            }

            extractTableFromPDF(PDF_FILE, CSV_FILE);
            zipFile(CSV_FILE, ZIP_FILE);
            System.out.println("Arquivo ZIP gerado com sucesso: " + ZIP_FILE);
        } catch (IOException e) {
            System.err.println("Erro durante a extração ou compactação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void extractTableFromPDF(String pdfPath, String csvPath) throws IOException {
        System.out.println("Extraindo tabelas do PDF...");

         try (PDDocument document = PDDocument.load(new File(pdfPath));
             PrintWriter writer = new PrintWriter(new FileWriter(csvPath))) {

            SpreadsheetExtractionAlgorithm extractor = new SpreadsheetExtractionAlgorithm();
            PageIterator pages = new ObjectExtractor(document).extract();

            while (pages.hasNext()) {
                Page page = pages.next();
                List<Table> tables = extractor.extract(page);

                for (Table table : tables) {
                    for (List<RectangularTextContainer> row : table.getRows()) {
                        List<String> rowData = row.stream()
                                .map(cell -> cell.getText()
                                        .replace("OD", "Seg. Odontológica")
                                        .replace("AMB", "Seg. Ambulatorial"))
                                .toList();

                        writer.println(String.join(",", rowData));
                    }
                }
            }
        }

        System.out.println("Extração concluída. Arquivo salvo em: " + csvPath);
    }

    private static void zipFile(String filePath, String zipPath) throws IOException {
        System.out.println("Compactando arquivo CSV para ZIP...");

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath));
             FileInputStream fis = new FileInputStream(filePath)) {

            ZipEntry zipEntry = new ZipEntry(new File(filePath).getName());
            zos.putNextEntry(zipEntry);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zos.write(buffer, 0, length);
            }
            zos.closeEntry();
        }

        System.out.println("Arquivo ZIP criado! : " + zipPath);
    }
}
