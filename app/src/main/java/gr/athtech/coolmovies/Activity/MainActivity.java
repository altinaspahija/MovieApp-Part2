package gr.athtech.coolmovies.Activity;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import gr.athtech.coolmovies.Activity.AbstractActivity;
import gr.athtech.coolmovies.Adapter.ViewPagerAdapter;
import gr.athtech.coolmovies.Fragment.FragmentFav;
import gr.athtech.coolmovies.Fragment.FragmentPopular;
import gr.athtech.coolmovies.Fragment.FragmentSearch;
import gr.athtech.coolmovies.R;

public class MainActivity extends AbstractActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    int getLayout() {
        return R.layout.activity_main;
    }


    @Override
    void initLayout() {
        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentPopular(), "");
        adapter.AddFragment(new FragmentFav(), "");
        adapter.AddFragment(new FragmentSearch(), "");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.getAdapter().notifyDataSetChanged();

        tabLayout.getTabAt(0).setIcon(R.drawable.fire);
        tabLayout.getTabAt(1).setIcon(R.drawable.heart);
        tabLayout.getTabAt(2).setIcon(R.drawable.search);

    }

    @Override
    void runOperations() {

    }

    @Override
    void stopOperations() {

    }

}