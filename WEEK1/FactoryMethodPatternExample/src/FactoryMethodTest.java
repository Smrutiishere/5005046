public class FactoryMethodTest {
    public static void main(String[] args) {
        // Create factories for different document types
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory PdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Create documents using the factories
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = PdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        // Open the documents
        wordDoc.open();
        pdfDoc.open();
        excelDoc.open();
    }
}
