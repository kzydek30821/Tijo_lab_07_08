package pl.edu.pwsztar.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movies")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "year")
    private Integer year;

    public Movie() {
    }

    public Movie(Builder builder){
        this.image = builder.image;
        this.title = builder.title;
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

    public static final class Builder {
        private Long movieId;
        private String title;
        private String image;
        private Integer year;

        public Builder() {
        }

        public Builder(Movie copy) {
            this.title = copy.getTitle();
            this.image = copy.getImage();
            this.year = copy.getYear();
            this.movieId = copy.getMovieId();
        }

        public Movie.Builder title(String title) {
            this.title = title;
            return this;
        }

        public Movie.Builder image(String image) {
            this.image = image;
            return this;
        }

        public Movie.Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public Movie.Builder id(Long id) {
            this.movieId = id;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
