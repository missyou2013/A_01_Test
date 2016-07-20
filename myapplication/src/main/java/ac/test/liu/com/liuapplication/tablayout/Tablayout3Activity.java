package ac.test.liu.com.liuapplication.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import ac.test.liu.com.liuapplication.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class Tablayout3Activity extends FragmentActivity {

    @Bind(R.id.tabs3)
    TabLayout tabs;

    @Bind(R.id.tab_viewpager3)
    ViewPager viewpager;

    private Tablayout3FragmentPagerAdapter pagerAdapter;

    String POSITION = "KEY_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout3);

        ButterKnife.bind(this);

        pagerAdapter = new Tablayout3FragmentPagerAdapter(getSupportFragmentManager(), this, 3);
        viewpager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewpager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
//        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

        for (int i = 0; i < tabs.getTabCount(); i++) {
            TabLayout.Tab tab = tabs.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(POSITION, tabs.getSelectedTabPosition());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        viewpager.setCurrentItem(savedInstanceState.getInt(POSITION));
    }
}
