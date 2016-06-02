package book.course.molareza.ir.collapse;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class ActivityMain extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AdapterViewPager adapterViewPager;

    public int[] icon = {

            R.mipmap.ic_heart,
            R.mipmap.ic_magnify,
            R.mipmap.ic_settings,
            R.mipmap.ic_tag_faces,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabLayout();


    }

    private void setupTabLayout() {

        try {
            tabLayout.getTabAt(0).setIcon(icon[0]);
            tabLayout.getTabAt(1).setIcon(icon[1]);
            tabLayout.getTabAt(2).setIcon(icon[2]);
            tabLayout.getTabAt(3).setIcon(icon[3]);

            tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
            tabLayout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
            tabLayout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
            tabLayout.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);

        } catch (Exception e) {
            Log.i("TAG", "setupTabLayout: " + e.getMessage());
        }


    }

    private void setupViewPager(ViewPager viewPager) {

        adapterViewPager = new AdapterViewPager(getSupportFragmentManager());

        adapterViewPager.addtoFragmentList(new FragPage1(), "Home");
        adapterViewPager.addtoFragmentList(new FragPage2(), "search");
        adapterViewPager.addtoFragmentList(new FragPage3(), "popular");
        adapterViewPager.addtoFragmentList(new FragPage4(), "friend");

        viewPager.setAdapter(adapterViewPager);


    }
}
