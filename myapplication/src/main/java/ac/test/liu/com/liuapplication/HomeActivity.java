package ac.test.liu.com.liuapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.test.liu.application.BaseApplication;
import com.test.liu.fragment.HomeFragment;
import com.test.liu.fragment.MyFragment;
import com.test.liu.fragment.ServiceFragment;
import com.test.liu.fragment.ServiceFragment1;
import com.test.liu.fragment.ServiceFragment2;

/**
 * Created by Administrator on 2016/3/28.
 * 首页
 */
public class HomeActivity extends FragmentActivity implements View.OnClickListener {
    // private List<ImageView> imagelist;
    // private TextView tv;
    // private LinearLayout ll;
    // private int preEnablePositon = 0; // 前一个被选中的点的索引位置 默认情况下为0
    // private String[] imagemiaoshu = { "巩俐不低俗，我就不能低俗", "朴树又回来了，再唱经典老歌引万人大合唱",
    // "揭秘北京电影如何升级", "乐视网TV版大派送", "热血屌丝的反杀" };
    // private ViewPager viewPager;
    // private boolean isStop = false; // 是否停止子线程 不会停止
    // private ArrayList<String> mImageUrl = null;
    //
    // private String imageUrl1 =
    // "http://imgs.xiuna.com/xiezhen/2014-9-25/2/5562900520140919100645087.jpg";
    //
    // private String imageUrl2 =
    // "http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg";
    //
    // private String imageUrl3 =
    // "http://srimg1.meimei22.com/pic/suren/2014-9-24/1/8740_11329820378.jpg";
    //
    // private String imageUrl4 =
    // "http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg";

    // Fragment管理器
    public FragmentManager fm;
    private FragmentTransaction ft;
    private MyFragment myFragment;// 我的
    private HomeFragment homeFragment;
    private ServiceFragment serviceFragment;
    private ServiceFragment1 serviceFragment1;
    private ServiceFragment2 serviceFragment2;

    private LinearLayout layout_home, layout_my, layout_service,
            layout_service2, layout_service3;

    private TextView tv_home, tv_my, tv_service, tv_service2, tv_service3;// 底部图片首页，我的，客服

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_home);

        initView();


        fm = getSupportFragmentManager();
        // 开始事务（每次改变Fragment管理器之后都要提交）
        ft = fm.beginTransaction();
        home();
        ft.commit();

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    private void initView() {
        layout_home = (LinearLayout) findViewById(R.id.ac_home_ll_home);
        layout_my = (LinearLayout) findViewById(R.id.ac_home_ll_my);
        layout_service = (LinearLayout) findViewById(R.id.ac_home_ll_service);
        layout_service2 = (LinearLayout) findViewById(R.id.ac_home_ll_service2);
        layout_service3 = (LinearLayout) findViewById(R.id.ac_home_ll_service3);

        layout_home.setOnClickListener(this);
        layout_my.setOnClickListener(this);
        layout_service.setOnClickListener(this);
        layout_service2.setOnClickListener(this);
        layout_service3.setOnClickListener(this);

        tv_home = (TextView) findViewById(R.id.ac_home_tv_home);
        tv_my = (TextView) findViewById(R.id.ac_home_tv_my);
        tv_service = (TextView) findViewById(R.id.ac_home_tv_service);
        tv_service2 = (TextView) findViewById(R.id.ac_home_tv_service2);
        tv_service3 = (TextView) findViewById(R.id.ac_home_tv_service3);


    }

    private void initData() {
        // mImageUrl = new ArrayList<String>();
        // mImageUrl.add(imageUrl1);
        // mImageUrl.add(imageUrl2);
        // mImageUrl.add(imageUrl3);
        // mImageUrl.add(imageUrl4);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        // isStop = true;
        super.onDestroy();
    }


    private long exitTime = 0;

    // 双击返回退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {

                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                BaseApplication.getSelf().exit(this);
                this.finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    /**
     * 设置左边按钮文本
     */
    public void setLeftTxt(String str, View.OnClickListener click) {
        View v = findViewById(R.id.title_btn_left);
        if (v != null) {
            v.setVisibility(View.GONE);
        }
        View v2 = findViewById(R.id.title_btn_left_txt);
        if (v2 != null) {
            v2.setVisibility(View.VISIBLE);
            ((Button) v2).setText("" + str);
            v2.setOnClickListener(click);
        }
    }

    /**
     * 设置右边按钮文本
     */
    public void setRightTxt(String str, View.OnClickListener click) {
        View v = findViewById(R.id.title_btn_right);
        if (v != null) {
            v.setVisibility(View.GONE);
        }
        View v2 = findViewById(R.id.title_btn_right_txt);
        if (v2 != null) {
            v2.setVisibility(View.VISIBLE);
            ((Button) v2).setText("" + str);
            v2.setOnClickListener(click);
        }
    }

    /**
     * 添加右边按钮点击事件
     */
    public void setRightBtnClick(int resId, View.OnClickListener click) {
        View v = findViewById(R.id.title_btn_right);
        if (v == null)
            return;
        ((ImageButton) v).setImageResource(resId);
        ((ImageButton) v).setVisibility(View.VISIBLE);
        ((ImageButton) v).setOnClickListener(click);
    }

    private void home() {
        homeFragment = new HomeFragment();
        ft.replace(R.id.ac_home_fl_content, homeFragment);
    }

    private void my() {
        myFragment = new MyFragment();
        ft.replace(R.id.ac_home_fl_content, myFragment);
    }

    private void s() {
        serviceFragment = new ServiceFragment();
        ft.replace(R.id.ac_home_fl_content, serviceFragment);
    }

    private void s2() {
        serviceFragment1 = new ServiceFragment1();
        ft.replace(R.id.ac_home_fl_content, serviceFragment1);
    }

    private void s3() {
        serviceFragment2 = new ServiceFragment2();
        ft.replace(R.id.ac_home_fl_content, serviceFragment2);
    }

    @Override
    public void onClick(View v) {
        // 每次点击时都需要重新开始事务
        ft = fm.beginTransaction();
        // 把显示的Fragment隐藏
        // hideFragment();
        switch (v.getId()) {
            case R.id.ac_home_ll_home:
                // 首页
                tv_home.setBackgroundResource(R.mipmap.tab_home_pre_ico);
                tv_my.setBackgroundResource(R.mipmap.tab_personal_ico);
                tv_service.setBackgroundResource(R.mipmap.tab_service_ico);
                tv_service2.setBackgroundResource(R.mipmap.tab_service_ico);
                tv_service3.setBackgroundResource(R.mipmap.tab_service_ico);
                home();
                ft.commit();
                break;
            case R.id.ac_home_ll_my:
                // 我的
                tv_home.setBackgroundResource(R.mipmap.tab_home_ico);
                tv_my.setBackgroundResource(R.mipmap.tab_personal_ico_pre);
                tv_service.setBackgroundResource(R.mipmap.tab_service_ico);
                tv_service2.setBackgroundResource(R.mipmap.tab_service_ico);
                tv_service3.setBackgroundResource(R.mipmap.tab_service_ico);
                my();
                ft.commit();
                break;
            case R.id.ac_home_ll_service:
                // 客服
                tv_home.setBackgroundResource(R.mipmap.tab_home_ico);
                tv_my.setBackgroundResource(R.mipmap.tab_personal_ico);
                tv_service.setBackgroundResource(R.mipmap.tab_service_ico_pre);
                tv_service2.setBackgroundResource(R.mipmap.tab_service_ico);
                tv_service3.setBackgroundResource(R.mipmap.tab_service_ico);
                s();
                ft.commit();
                break;
            case R.id.ac_home_ll_service2:
                // 客服
                tv_home.setBackgroundResource(R.mipmap.tab_home_ico);
                tv_my.setBackgroundResource(R.mipmap.tab_personal_ico);
                tv_service.setBackgroundResource(R.mipmap.tab_service_ico);
                tv_service2.setBackgroundResource(R.mipmap.tab_service_ico_pre);
                tv_service3.setBackgroundResource(R.mipmap.tab_service_ico);
                s();
                ft.commit();
                break;
            case R.id.ac_home_ll_service3:
                // 客服
                tv_home.setBackgroundResource(R.mipmap.tab_home_ico);
                tv_my.setBackgroundResource(R.mipmap.tab_personal_ico);
                tv_service.setBackgroundResource(R.mipmap.tab_service_ico);
                tv_service2.setBackgroundResource(R.mipmap.tab_service_ico);
                tv_service3.setBackgroundResource(R.mipmap.tab_service_ico_pre);
                s();
                ft.commit();
                break;
            // case R.id.ac_home_rela_right_clock:
            // // 顶部闹钟图标父容器
            //
            // System.out.println("点击了右上闹钟图标");
            // // Intent intentmyait = new Intent(this, CitySwtichActivity.class);
            // // startActivity(intentmyait);
            //
            // break;
            // case R.id.ac_home_ib_right_search:
            // // 搜索
            // // Intent intent1 = new Intent(this, CitySwtichActivity.class);
            // // startActivity(intent1);
            //
            // break;
            // case R.id.ac_home_tv_left_city:
            // // 顶部城市
            // Intent intent2 = new Intent(this, CitySwtichActivity.class);
            // // Intent intent = new Intent(this, BaiduMapActivity.class);
            // startActivity(intent2);
            // break;
            default:
                break;
        }

    }
}
