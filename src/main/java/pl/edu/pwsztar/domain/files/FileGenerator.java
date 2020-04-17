package pl.edu.pwsztar.domain.files;

import org.springframework.core.io.InputStreamResource;
import pl.edu.pwsztar.domain.dto.FileDto;

import java.io.IOException;


// TODO: Czy interfejs nie lamie zasady SOLID?
public interface FileGenerator {

    InputStreamResource toTxt(FileDto fileDto) throws IOException;
}
