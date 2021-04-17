package gr.athtech.coolmovies;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavMovieAdapter extends RecyclerView.Adapter<FavMovieAdapter.viewHolder> {

    Context context;
    List<MovieData> movieData;

    public FavMovieAdapter(Context context, List <MovieData> movieData){
        this.movieData = movieData;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_fav_list,parent,false);
        viewHolder viewHolder = new viewHolder(view);

        viewHolder.view_container_fav.setOnClickListener(v -> {
            Intent i = new Intent(context, DetailsFavActivity.class);
            i.putExtra("movie_name",movieData.get(viewHolder.getAdapterPosition()).getMovieName());
            i.putExtra("movie_date",movieData.get(viewHolder.getAdapterPosition()).getMovieData());
            i.putExtra("movie_category",movieData.get(viewHolder.getAdapterPosition()).getMovieCategory());
            i.putExtra("movie_image",movieData.get(viewHolder.getAdapterPosition()).getMovieImage());
            i.putExtra("movie_text_rating",movieData.get(viewHolder.getAdapterPosition()).getMovieRatingText());
            i.putExtra("movie_rating",movieData.get(viewHolder.getAdapterPosition()).getMovieRating());
            i.putExtra("movie_description",movieData.get(viewHolder.getAdapterPosition()).getMovieDescription());
            i.putExtra("movie_image_cover",movieData.get(viewHolder.getAdapterPosition()).getMovieImageCover());
            i.putExtra("movie_director",movieData.get(viewHolder.getAdapterPosition()).getMovieDirector());
            i.putExtra("movie_actor",movieData.get(viewHolder.getAdapterPosition()).getMovieActor());
            context.startActivity(i);
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.textViewName.setText(movieData.get(position).getMovieName());
        holder.textViewDate.setText(movieData.get(position).getMovieData());
        holder.textViewCategory.setText(movieData.get(position).getMovieCategory());
        holder.movieImage.setImageResource(movieData.get(position).getMovieImage());
        holder.textViewMRating.setText(movieData.get(position).getMovieRatingText());
        holder.ratingBar.setRating(movieData.get(position).getMovieRating());
    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView textViewName;
        TextView textViewDate;
        TextView textViewCategory;
        TextView textViewMRating;
        RatingBar ratingBar;
        LinearLayout view_container_fav;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            view_container_fav = itemView.findViewById(R.id.view_container_fav);
            movieImage = itemView.findViewById(R.id.movie_imageView);
            textViewName = itemView.findViewById(R.id.textName);
            textViewDate = itemView.findViewById(R.id.textDate);
            textViewCategory = itemView.findViewById(R.id.textCategory);
            textViewMRating = itemView.findViewById(R.id.ratingText);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }

}
