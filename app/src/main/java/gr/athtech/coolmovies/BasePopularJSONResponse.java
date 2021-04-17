package gr.athtech.coolmovies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class BasePopularJSONResponse implements Serializable, Parcelable {
   private FavouriteJSONResponse dates;

   private int page;

   private PopularJSONResponse results;

   protected BasePopularJSONResponse(Parcel in) {

            page = in.readInt();
            results = in.readParcelable(PopularJSONResponse.class.getClassLoader());
   }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeParcelable(results, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BasePopularJSONResponse> CREATOR = new Creator<BasePopularJSONResponse>() {
        @Override
        public BasePopularJSONResponse createFromParcel(Parcel in) {
            return new BasePopularJSONResponse(in);
        }

        @Override
        public BasePopularJSONResponse[] newArray(int size) {
            return new BasePopularJSONResponse[size];
        }
    };

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public PopularJSONResponse getResults() {
        return results;
    }

    public void setResults(PopularJSONResponse results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasePopularJSONResponse that = (BasePopularJSONResponse) o;
        return page == that.page &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, results);
    }

    @Override
    public String toString() {
        return "BasePopularJSONResponse{" +
                "page=" + page +
                ", results=" + results +
                '}';
    }
}
