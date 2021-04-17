package gr.athtech.coolmovies;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class FragmentPopular extends Fragment {
    public FragmentPopular() {
    }

    View v;

    private RecyclerView recyclerView;
    private List<MovieData> listMovieData;
    private String JSON_URL = "https://api.themoviedb.org/3/movie/popular?api_key=40219592510d78632bfd917982326cc7";


    Context context;
    RequestQueue requestQueue;
    JsonArrayRequest request;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.popular_movies, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.popular_movies);
        MovieAdapter movieAdapter = new MovieAdapter(getContext(), listMovieData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(movieAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listMovieData = new ArrayList<>();
        jsonrequest();
        Log.i("list",listMovieData.toString());
//        listMovies.add(new MovieData("Coming 2 America", "2021", R.drawable.coming_to_america, "Comedy", "3.3", 3.3f, getString(R.string.comming2america),R.drawable.coming_to_america_cover,"Eddie Murphy, Arsenio Hall, Shari Headley","Craig Brewer"));
//        listMovies.add(new MovieData("Raya and the Last Dragon", "2021", R.drawable.raya, "Animation", "4.8", 4.8f, getString(R.string.raya),R.drawable.raya_cover,"Kelly Marie Tran, Awkwafina, Gemma Chan"," Don Hall, Carlos López Estrada"));
//        listMovies.add(new MovieData("I care a lot", "2020", R.drawable.care_a_lot, "Comedy|Crime", "4.0", 4.0f, getString(R.string.careAlot),R.drawable.care_a_lot_cover,"Rosamund Pike, Peter Dinklage, Eiza González","J Blakeson"));
//        listMovies.add(new MovieData("Joker", "2019", R.drawable.joker, "Crime|Drama|Thriller", "5.0", 5.0f, getString(R.string.joker),R.drawable.joker_cover,"Joaquin Phoenix, Robert De Niro, Zazie Beetz ","Todd Phillips"));
//        listMovies.add(new MovieData("The little things", "2021", R.drawable.little_things, "Crime|Drama|Thriller", "4.5", 4.5f, getString(R.string.littleThings),R.drawable.little_things_cover,"Denzel Washington, Rami Malek, Jared Leto","John Lee Hancock"));
    }

//    private void jsonrequest() {
//
//        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                try {
//                    JSONObject jsonObject = new JSONObject();
//                    JSONArray jsonArray = jsonObject.getJSONArray("results");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                        MovieData movieData = new MovieData();
//                        movieData.setMovieData(jsonObject1.getString("original_title"));
//                        movieData.setMovieDescription(jsonObject1.getString("overview"));
//                        movieData.setMovieRating(jsonObject1.getInt("vote_average"));
////                        movieData.setMovieCategory(jsonObject.getInt(""));
////                        movieData.setNb_episode(jsonObject.getInt("episode"));
////                        movieData.setStudio(jsonObject.getString("studio"));
////                        movieData.setImage_url(jsonObject.getString("img"));
//                        listMovieData.add(movieData);
//
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue = Volley.newRequestQueue(getContext());
//        requestQueue.add(request) ;
//
//    }

//    private void jsonrequest() {
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, response -> {
//            JSONObject jsonObject = new JSONObject();
//            JSONArray jsonArray = null;
//            try {
//                jsonArray = jsonObject.getJSONArray("results");
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            for (int i = 0; i < jsonArray.length(); i++) {
//                try {
//                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//
//                    MovieData movieData = new MovieData();
//                    movieData.setMovieData(jsonObject1.getString("original_title"));
//                    movieData.setMovieDescription(jsonObject1.getString("overview"));
//                    movieData.setMovieRating(jsonObject1.getInt("vote_average"));
//                    listMovieData.add(movieData);
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }, error -> Log.d("tag", "onErrorResponse: " + error.getMessage()));
//
//        queue.add(jsonArrayRequest);
//    }

    //    private void jsonrequest() {
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        MovieData movieData = new MovieData();
//
//                        // Display the first 500 characters of the response string.
//                        Log.i("COMM", response);
//
//                        PopularJSONResponse json = new Gson().fromJson(response, PopularJSONResponse.class);
//
//                        Log.i("COMM", json.toString());
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("COMM", error.getMessage());
//            }
//        });
//
//        // Add the request to the RequestQueue.
//        queue.add(stringRequest);
//
//    }
    private void jsonrequest() {
        //creating a string request to send request to the url
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Showing json data in log monitor
                        Log.d("json", response.toString());
                        try {

                            JSONArray jsonArray = response.getJSONArray("results");
                            //now looping through all the elements of the json array
                            for (int i = 0; i < jsonArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                MovieData movieData = new MovieData();
                                movieData.setMovieName(jsonObject.getString("title"));
                                movieData.setMovieData(jsonObject.getString("release_date"));
                                //adding the json data to list
                                listMovieData.add(movieData);
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


