
package gr.athtech.coolmovies;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsFavActivity extends AbstractActivity{

    @Override
    int getLayout() {
        return R.layout.activity_details_fav;
    }


    @Override
    void initLayout() {
        String name = getIntent().getExtras().getString("movie_name");
        Integer image = getIntent().getExtras().getInt("movie_image_cover");
        String date = getIntent().getExtras().getString("movie_date");
        String category = getIntent().getExtras().getString("movie_category");
        String textRating = getIntent().getExtras().getString("movie_text_rating");
        Float  rating = getIntent().getExtras().getFloat("movie_rating");
        String description = getIntent().getExtras().getString("movie_description");
        String director = getIntent().getExtras().getString("movie_director");
        String actor = getIntent().getExtras().getString("movie_actor");



        ImageView movie_image = findViewById(R.id.movie_imageView_details_cover_fav);
        TextView movie_text = findViewById(R.id.textName_details_fav);
        TextView movie_date = findViewById(R.id.textDate_details_fav);
        TextView movie_category = findViewById(R.id.textCategory_details_fav);
        TextView movie_textrating = findViewById(R.id.ratingText_details_fav);
        RatingBar movie_rating = findViewById(R.id.ratingBar_details_fav);
        TextView movie_description = findViewById(R.id.description_details_fav);
        TextView textViewMore = findViewById(R.id.textView_more_fav);
        TextView textViewLess = findViewById(R.id.textView_less_fav);
        TextView movie_director = findViewById(R.id.textView_director_details_fav);
        TextView movie_actor = findViewById(R.id.textView_actor_details_fav);
        ScrollView scrollView = findViewById(R.id.scrollView_details_fav);

        movie_text.setText(name);
        movie_image.setImageResource(image);
        movie_date.setText(date);
        movie_category.setText(category);
        movie_rating.setRating(rating);
        movie_textrating.setText(textRating);
        movie_description.setText(description);
        movie_director.setText(director);
        movie_actor.setText(actor);

        textViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie_description.setVisibility(View.VISIBLE);
                textViewMore.setVisibility(View.INVISIBLE);
                textViewLess.setVisibility(View.VISIBLE);
            }});

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
