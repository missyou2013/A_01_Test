package ac.test.liu.com.liuapplication.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import ac.test.liu.com.liuapplication.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class Tablayout2Activity extends FragmentActivity {

    @Bind(R.id.tabs2)
    TabLayout tabs;

    @Bind(R.id.tab_viewpager2)
    ViewPager viewpager;

    private TablayoutFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout2);

        ButterKnife.bind(this);

        pagerAdapter = new TablayoutFragmentPagerAdapter(getSupportFragmentManager(), this,15);
        viewpager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewpager);
//        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
