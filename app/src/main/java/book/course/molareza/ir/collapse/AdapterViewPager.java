package book.course.molareza.ir.collapse;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class AdapterViewPager extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mFragmentTitle = new ArrayList<>();


    public AdapterViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addtoFragmentList(Fragment fragment, String title) {

        mFragmentList.add(fragment);
        mFragmentTitle.add(title);

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mFragmentTitle.get(position);

    }
}
