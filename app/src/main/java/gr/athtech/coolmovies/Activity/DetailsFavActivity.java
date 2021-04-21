
package gr.athtech.coolmovies.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import gr.athtech.coolmovies.Adapter.FavMovieAdapter;
import gr.athtech.coolmovies.Fragment.FragmentFav;
import gr.athtech.coolmovies.Fragment.FragmentPopular;
import gr.athtech.coolmovies.R;

public class DetailsFavActivity extends AbstractActivity {

    @Override
    int getLayout() {
        return R.layout.activity_details_fav;
    }


    @Override
    void initLayout() {
        String name = getIntent().getExtras().getString("movie_name");
        String image = getIntent().getExtras().getString("movie_image_cover");
        String date = getIntent().getExtras().getString("movie_date");
        double textRating = getIntent().getExtras().getDouble("movie_text_rating");
        String description = getIntent().getExtras().getString("movie_description");

        ImageView movie_image = findViewById(R.id.movie_imageView_details_cover_fav);
        TextView movie_text = findViewById(R.id.textName_details_fav);
        TextView movie_date = findViewById(R.id.textDate_details_fav);
        TextView movie_textrating = findViewById(R.id.ratingText_details_fav);
        TextView movie_description = findViewById(R.id.description_details_fav);
        TextView textViewMore = findViewById(R.id.textView_more_fav);
        TextView textViewLess = findViewById(R.id.textView_less_fav);
        ScrollView scrollView = findViewById(R.id.scrollView_details_fav);

        movie_text.setText(name);
        Picasso.get().load(image).into(movie_image);
        movie_date.setText(new StringBuilder().append("Released: ").append(date));
        movie_textrating.setText(new StringBuilder().append(textRating).toString());
        movie_description.setText(description);

        textViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie_description.setVisibility(View.VISIBLE);
                textViewMore.setVisibility(View.INVISIBLE);
                textViewLess.setVisibility(View.VISIBLE);
            }
        });

        textViewLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie_description.setVisibility(View.INVISIBLE);
                textViewLess.setVisibility(View.INVISIBLE);
                textViewMore.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    void runOperations() {

    }

    @Override
    void stopOperations() {

    }
}
