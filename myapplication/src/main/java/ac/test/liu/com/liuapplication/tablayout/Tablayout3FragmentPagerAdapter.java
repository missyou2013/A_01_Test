package ac.test.liu.com.liuapplication.tablayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ac.test.liu.com.liuapplication.R;


public class Tablayout3FragmentPagerAdapter extends FragmentPagerAdapter {
    private int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"tab1", "tab2", "tab3", "tab4", "tab5", "tab6", "tab7", "tab8", "tab9", "tab10", "tab11", "tab12", "tab13", "tab14", "tab15"};
    private Context context;
    private int[] imageResId = {
            R.mipmap.umeng_socialize_qq_on,
            R.mipmap.umeng_socialize_qzone_on,
            R.mipmap.umeng_socialize_sina_on
    };

    public Tablayout3FragmentPagerAdapter(FragmentManager fm, Context context, int PAGE_COUNT) {
        super(fm);
        this.context = context;
        this.PAGE_COUNT = PAGE_COUNT;
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
//        return tabTitles[position];

//        Drawable image = context.getResources().getDrawable(imageResId[position]);
//        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//        SpannableString sb = new SpannableString("          " + tabTitles[position]);
//        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return sb;
        return null;
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_tablayout3_top_view, null);
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(tabTitles[position]);

        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        img.setImageResource(imageResId[position]);
        return view;
    }

}
