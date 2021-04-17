package gr.athtech.coolmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AbstractActivity{

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

        adapter.AddFragment(new FragmentPopular(),"");
        adapter.AddFragment(new FragmentFav(),"");
        adapter.AddFragment(new FragmentSearch(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

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