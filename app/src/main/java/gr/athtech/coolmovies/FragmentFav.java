package gr.athtech.coolmovies;

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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentFav extends Fragment {
    public FragmentFav() {
    }

    View v;

    private RecyclerView recyclerView;
    private List<MovieData> listMovieData;
    private String JSON_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=40219592510d78632bfd917982326cc7&language=en-US&page=1";
    Context context;
    RequestQueue requestQueue;
    JsonArrayRequest request;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fav_movies,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.favourite_movies);
        FavMovieAdapter favMovieAdapter = new FavMovieAdapter(getContext(),listMovieData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(favMovieAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listMovieData = new ArrayList<>();
        jsonrequest();
//        listMovies = new ArrayList<>();
//        listMovies.add(new MovieData("Hereditary", "2018", R.drawable.hereditary,"Drama|Horror|Mystery", "4.8", 4.8f, getString(R.string.hereditary),R.drawable.hereditary_cover,"Toni Collette, Milly Shapiro, Gabriel Byrne","Ari Aster"));
//        listMovies.add(new MovieData("Get Out", "2017", R.drawable.get_out, "Horror|Mystery|Thriller", "5.0", 5.0f, getString(R.string.getOut),R.drawable.get_out_cover,"Daniel Kaluuya, Allison Williams, Bradley Whitford ","Jordan Peele"));
//        listMovies.add(new MovieData("Black Widow", "2021", R.drawable.black_widow, "Action", "4.5", 4.5f, getString(R.string.blackWidow),R.drawable.black_widow_cover,"Scarlett Johansson, Florence Pugh, David Harbour","Cate Shortland"));
//        listMovies.add(new MovieData("Last Holiday", "2006", R.drawable.last_holiday, "Adventure|Comedy|Romance", "4.0", 4.0f, getString(R.string.lastHoliday),R.drawable.last_holiday_cover,"Queen Latifah, LL Cool J, Timothy Hutton ","Wayne Wang"));
//        listMovies.add(new MovieData("Us", "2019", R.drawable.us, "Horror|Mystery|Thriller", "4.8", 4.8f, getString(R.string.joker),R.drawable.us_cover,"Lupita Nyong'o, Winston Duke, Elisabeth Moss","Jordan Peele"));
    }
    private void jsonrequest() {
    RequestQueue queue = Volley.newRequestQueue(getContext());
    StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    Log.i("COMM", response);

//                    PopularJSONResponse json = new Gson().fromJson(response, PopularJSONResponse.class);
//
//                    Log.i("COMM", json.toString());
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("COMM", error.getMessage());
        }
    });

    // Add the request to the RequestQueue.
                queue.add(stringRequest);

}

//    private void jsonrequest() {
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                JSONObject jsonObject = new JSONObject();
//                JSONArray jsonArray = null;
//                try {
//                    jsonArray = jsonObject.getJSONArray("results");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                for (int i = 0; i < jsonArray.length(); i++) {
//                    try {
//                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//
//                        MovieData movieData = new MovieData();
//                        movieData.setMovieData(jsonObject1.getString("original_title"));
//                        movieData.setMovieDescription(jsonObject1.getString("overview"));
//                        movieData.setMovieRating(jsonObject1.getInt("vote_average"));
//                        listMovieData.add(movieData);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("tag", "onErrorResponse: " + error.getMessage());
//            }
//        });
//
//        queue.add(jsonArrayRequest);
//    }

}