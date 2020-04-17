package pl.edu.pwsztar.domain.dto;

import java.util.List;

public class FileDto {
    private List<MovieDto> moveList;

    public FileDto(List<MovieDto> moveList) {
        this.moveList = moveList;
    }

    public List<MovieDto> getMoveList() {
        return moveList;
    }
}
