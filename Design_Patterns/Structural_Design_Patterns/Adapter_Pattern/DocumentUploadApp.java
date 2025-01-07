public class DocumentUploadApp {
  public static void main(String[] args) {
      var pdfDocumentUploader = new PdfDocumentUploader();
      var onlineApplication = new OnlineApplication(pdfDocumentUploader);
      onlineApplication.uploadDocument();

      var wordDocumentUploader = new WordDocumentAdater();
      var onlineApplication2 = new OnlineApplication(wordDocumentUploader);
      onlineApplication2.uploadDocument();
  }
}

class OnlineApplication {

  private final DocumentUploader documentUploader;

  public OnlineApplication(DocumentUploader documentUploader) {
    this.documentUploader = documentUploader;
  }

  public void uploadDocument() {
    documentUploader.upload();
  }

}

interface DocumentUploader {
  void upload();
}

class PdfDocumentUploader implements DocumentUploader {
  
  @Override
  public void upload() {
    System.out.println("Preparing PDF document...");
    System.out.println("Uploading PDF document");
  }
}

class WordDocumentUploader {

  public void uploadWordDocument() {
    System.out.println("Preparing Word document");
    System.out.println("Uploading Word document");
  }
}

class WordDocumentAdater extends WordDocumentUploader implements DocumentUploader{
  
  @Override
  public void upload() {
    uploadWordDocument();
  }

  @Override
  public void uploadWordDocument() {
    System.out.println("Preparing Word document...");
    System.out.println("Uploading Word document");
  }
}