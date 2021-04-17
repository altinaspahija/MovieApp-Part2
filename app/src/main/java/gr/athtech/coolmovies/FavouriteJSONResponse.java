package gr.athtech.coolmovies;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Objects;

public class FavouriteJSONResponse implements Serializable, Parcelable {
    private String maximum;
    private String minimum;

    protected FavouriteJSONResponse(Parcel in) {
        maximum = in.readString();
        minimum = in.readString();
    }

    public static final Creator<FavouriteJSONResponse> CREATOR = new Creator<FavouriteJSONResponse>() {
        @Override
        public FavouriteJSONResponse createFromParcel(Parcel in) {
            return new FavouriteJSONResponse(in);
        }

        @Override
        public FavouriteJSONResponse[] newArray(int size) {
            return new FavouriteJSONResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(maximum);
        dest.writeString(minimum);
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavouriteJSONResponse that = (FavouriteJSONResponse) o;
        return Objects.equals(maximum, that.maximum) &&
                Objects.equals(minimum, that.minimum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maximum, minimum);
    }

    @Override
    public String toString() {
        return "FavouriteJSONResponse{" +
                "maximum='" + maximum + '\'' +
                ", minimum='" + minimum + '\'' +
                '}';
    }
}
