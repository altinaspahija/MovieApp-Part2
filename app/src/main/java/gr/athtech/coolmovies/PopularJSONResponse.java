package gr.athtech.coolmovies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PopularJSONResponse implements Serializable, Parcelable{

        private int id;

        private String originalTitle;

        private String originalLanguage;

        private String title;

        private String posterPath;

        private boolean adult;

        private String overview;

        private String releaseDate;

        private List<Integer> genreIds;

        private String backdropPath;

        private double popularity;

        private int voteCount;

        private boolean video;

        private double voteAverage;

        public PopularJSONResponse(String posterPath){}
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.originalTitle);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.title);
        dest.writeString(this.posterPath);
        dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
        dest.writeString(this.overview);
        dest.writeString(this.releaseDate);
        dest.writeList(this.genreIds);
        dest.writeString(this.backdropPath);
        dest.writeDouble(this.popularity);
        dest.writeInt(this.voteCount);
        dest.writeByte(this.video ? (byte) 1 : (byte) 0);
        dest.writeDouble(this.voteAverage);
    }

        @Override
        public int describeContents() {
            return 0;
        }



        protected PopularJSONResponse(Parcel in) {
            this.id = in.readInt();
            this.originalTitle = in.readString();
            this.originalLanguage = in.readString();
            this.title = in.readString();
            this.posterPath = in.readString();
            this.adult = in.readByte() != 0;
            this.overview = in.readString();
            this.releaseDate = in.readString();
            this.genreIds = new ArrayList<Integer>();
            in.readList(this.genreIds, Integer.class.getClassLoader());
            this.backdropPath = in.readString();
            this.popularity = in.readDouble();
            this.voteCount = in.readInt();
            this.video = in.readByte() != 0;
            this.voteAverage = in.readDouble();
        }

        public static final Parcelable.Creator<PopularJSONResponse> CREATOR = new Parcelable.Creator<PopularJSONResponse>() {
            @Override
            public PopularJSONResponse createFromParcel(Parcel source) {
                return new PopularJSONResponse(source);
            }

            @Override
            public PopularJSONResponse[] newArray(int size) {
                return new PopularJSONResponse[size];
            }
        };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PopularJSONResponse that = (PopularJSONResponse) o;
        return id == that.id &&
                adult == that.adult &&
                Double.compare(that.popularity, popularity) == 0 &&
                voteCount == that.voteCount &&
                video == that.video &&
                Double.compare(that.voteAverage, voteAverage) == 0 &&
                Objects.equals(originalTitle, that.originalTitle) &&
                Objects.equals(originalLanguage, that.originalLanguage) &&
                Objects.equals(title, that.title) &&
                Objects.equals(posterPath, that.posterPath) &&
                Objects.equals(overview, that.overview) &&
                Objects.equals(releaseDate, that.releaseDate) &&
                Objects.equals(genreIds, that.genreIds) &&
                Objects.equals(backdropPath, that.backdropPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originalTitle, originalLanguage, title, posterPath, adult, overview, releaseDate, genreIds, backdropPath, popularity, voteCount, video, voteAverage);
    }

    @Override
    public String toString() {
        return "PopularJSONResponse{" +
                "id=" + id +
                ", originalTitle='" + originalTitle + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", title='" + title + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", genreIds=" + genreIds +
                ", backdropPath='" + backdropPath + '\'' +
                ", popularity=" + popularity +
                ", voteCount=" + voteCount +
                ", video=" + video +
                ", voteAverage=" + voteAverage +
                '}';
    }
}

