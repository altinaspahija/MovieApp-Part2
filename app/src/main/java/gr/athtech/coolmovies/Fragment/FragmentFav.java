package gr.athtech.coolmovies.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import gr.athtech.coolmovies.Adapter.FavMovieAdapter;
import gr.athtech.coolmovies.Model.MovieData;
import gr.athtech.coolmovies.R;


public class FragmentFav extends Fragment {
    public FragmentFav() {

    }

    View v;

    private RecyclerView recyclerView;
    private List<MovieData> favMovieDataList;

    // Retrieve now playing movies (in our case favourite movies), first page of them
    private String JSON_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=c1c68db8f902d5b4cd68ba02816b02ef&page=1";
    public static final String IMAGE_URI = "https://image.tmdb.org/t/p/w500"; // Image uri

    Context context;
    RequestQueue requestQueue;
    JsonArrayRequest request;
    FavMovieAdapter favMovieAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fav_movies, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.favourite_movies);
        FavMovieAdapter favMovieAdapter = new FavMovieAdapter(getContext(), favMovieDataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(favMovieAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        favMovieDataList = new ArrayList<>();
        jsonRequestFavMovies();
    }

    private void jsonRequestFavMovies() {
        // Creating a request to the url
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Showing json data in log monitor
                        Log.d("json", response.toString());
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            // Now looping through all the elements of the json array
                            for (int i = 0; i < jsonArray.length(); i++) {
                                // Getting the json object of the particular index inside the array
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                MovieData movieData = new MovieData();
                                movieData.setTitle(jsonObject.getString("title"));
                                movieData.setReleaseDate(jsonObject.getString("release_date"));
                                movieData.setOverview(jsonObject.getString("overview"));
                                movieData.setPosterPath(IMAGE_URI + jsonObject.getString("poster_path"));
                                movieData.setVoteAverage(jsonObject.getDouble("vote_average"));
                                // Adding the json data to list
                                favMovieDataList.add(movieData);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        queue.add(jsonObjectRequest);
    }

}


