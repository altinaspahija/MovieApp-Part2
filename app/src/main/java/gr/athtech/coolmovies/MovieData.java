package gr.athtech.coolmovies;

public class MovieData {
    private String movieName;
    private String movieData;
    private Integer movieImage;
    private String movieCategory;
    private String movieRatingText;
    private float movieRating;
    private String movieDescription;
    private Integer movieImageCover;
    private String movieActor;
    private String movieDirector;

    public MovieData(){}
    public MovieData(String movieName, String movieData, Integer movieImage, String movieCategory,
                     String movieRatingText, float movieRating, String movieDescription, Integer movieImageCover,
                    String movieActor, String movieDirector) {
        this.movieName = movieName;
        this.movieData = movieData;
        this.movieImage = movieImage;
        this.movieCategory = movieCategory;
        this.movieRatingText = movieRatingText;
        this.movieRating = movieRating;
        this.movieDescription = movieDescription;
        this.movieImageCover = movieImageCover;
        this.movieActor = movieActor;
        this.movieDirector = movieDirector;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieData() {
        return movieData;
    }

    public void setMovieData(String movieData) {
        this.movieData = movieData;
    }

    public Integer getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Integer movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieCategory(){ return movieCategory;}

    public void setMovieCategory(String movieCategory){this.movieCategory = movieCategory;}

    public String getMovieRatingText(){ return movieRatingText;}

    public void setMovieRatingText(String movieRatingText) { this.movieRatingText = movieRatingText;}

    public float getMovieRating(){return movieRating;}

    public void setMovieRating(float movieRating) { this.movieRating = movieRating;}

    public String getMovieDescription(){return movieDescription;}

    public void setMovieDescription(String movieDescription) {this.movieDescription = movieDescription;}

    public Integer getMovieImageCover() {
        return movieImageCover;
    }

    public void setMovieImageCover(Integer movieImageCover) { this.movieImageCover = movieImageCover; }

    public String getMovieActor(){return movieActor;}

    public void setMovieActor(){this.movieActor=movieActor;}

    public String getMovieDirector(){return movieDirector;}

    public void setMovieDirector(){this.movieDirector=movieDirector;}
}
