package gvarni.unitn.esercizio22bis;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "empty file!";
        }

        String contentType = file.getContentType();
        if (!isAllowedContentType(contentType)) {
            return "Content type not allowed!";
        }

        try {
            File dir = new File("C:\\Users\\giova\\Documents\\Corsi_2024-2025\\Web\\mycourse\\new_edition\\esempi_codice");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File destination = new File(dir, file.getOriginalFilename());
            file.transferTo(destination);

           return "File uploaded correctly!";
        } catch (IOException e) {

           return "error uploading file!";
        }

    }

    private boolean isAllowedContentType(String contentType) {

        if (contentType!= null && (contentType.equals("image/jpeg") ||
                contentType.equals("image/png") ||
                contentType.equals("image/gif") ||
                contentType.equals("application/pdf")))
                return true;
        else
                return false;
    }

}
