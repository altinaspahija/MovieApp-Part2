package gr.athtech.coolmovies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSearch extends Fragment {

    public FragmentSearch() {
    }

    private String JSON_RULE = "https://api.themoviedb.org/3/search/movie?api_key=40219592510d78632bfd917982326cc7&language=en-US&query=batman&page=1";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.search_fragment, container,false);

        String[] movies = getResources().getStringArray(R.array.movies);
        AutoCompleteTextView editText = (AutoCompleteTextView) view.findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.search_custom_list_item, R.id.text_view_list_item, movies);
        editText.setAdapter(adapter);

        return view;
    }

}
