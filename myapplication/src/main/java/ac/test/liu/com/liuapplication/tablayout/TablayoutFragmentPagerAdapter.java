package ac.test.liu.com.liuapplication.tablayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TablayoutFragmentPagerAdapter extends FragmentPagerAdapter {
    private int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"tab1", "tab2", "tab3", "tab4", "tab5", "tab6", "tab7", "tab8", "tab9", "tab10", "tab11", "tab12", "tab13", "tab14", "tab15"};
    private Context context;

    public TablayoutFragmentPagerAdapter(FragmentManager fm, Context context, int PAGE_COUNT) {
        super(fm);
        this.context = context;
        this.PAGE_COUNT=PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return TablayoutFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
