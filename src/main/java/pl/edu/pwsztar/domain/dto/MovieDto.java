package pl.edu.pwsztar.domain.dto;

import java.io.Serializable;

public class MovieDto implements Serializable {
    private Long movieId;
    private String title;
    private String image;
    private Integer year;

    public MovieDto() {
    }

    public MovieDto(Builder builder){
        this.movieId = builder.movieId;
        this.title = builder.title;
        this.image = builder.image;
        this.year = builder.year;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", year=" + year +
                '}';
    }
    public static final class Builder {
        private Long movieId;
        private String title;
        private String image;
        private Integer year;

        public Builder() {
        }

        public Builder(MovieDto copy) {
            this.title = copy.getTitle();
            this.image = copy.getImage();
            this.year = copy.getYear();
            this.movieId = copy.getMovieId();
        }

        public MovieDto.Builder title(String title) {
            this.title = title;
            return this;
        }

        public MovieDto.Builder image(String image) {
            this.image = image;
            return this;
        }

        public MovieDto.Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public MovieDto.Builder id(Long id) {
            this.movieId = id;
            return this;
        }

        public MovieDto build() {
            return new MovieDto(this);
        }
    }
}
