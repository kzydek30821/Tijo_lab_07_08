package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.FileDto;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.domain.files.FileGenerator;

import java.io.*;
import java.util.Comparator;
import java.util.List;

@Service(value = "fileGenerator")
public class FileGeneratorImpl implements FileGenerator{
    @Override
    public InputStreamResource toTxt(FileDto fileDto) throws IOException{
        FileDto preFileDto = sortFileDtoByYear(fileDto);

        File file=File.createTempFile("tmp", ".txt");
        FileOutputStream fos=new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for(MovieDto movie : preFileDto.getMoveList()){
            bw.write(movie.getYear() + " " + movie.getTitle());
            bw.newLine();
        }

        bw.close();

        fos.flush();
        fos.close();

        InputStream stream = new FileInputStream(file);
        return new InputStreamResource(stream);
    }
    private FileDto sortFileDtoByYear(FileDto fileDto){
        List<MovieDto> movieDtoList = fileDto.getMoveList();
        movieDtoList.sort(Comparator.comparing(MovieDto::getYear).reversed());
        return new FileDto(movieDtoList);
    }
}