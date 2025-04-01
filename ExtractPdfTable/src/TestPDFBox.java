import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.IOException;

public class TestPDFBox {
    public static void main(String[] args) {
        try {
            PDDocument doc = PDDocument.load(new File("Anexo_1.pdf"));
            System.out.println("PDF carregado com sucesso!");
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
