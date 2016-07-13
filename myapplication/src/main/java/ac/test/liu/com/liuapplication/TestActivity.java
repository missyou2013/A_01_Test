package ac.test.liu.com.liuapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.liu.application.BaseActivity;
import com.test.liu.model.UserModle;
import com.test.liu.utils.CommonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.RequestParams;

/**
 * @author liu
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: $desc(用一句话描述该文件做什么)
 * @date ${date} ${time}
 */
public class TestActivity extends BaseActivity {
    @Bind(R.id.editText_name)
    EditText editTextName;
    @Bind(R.id.editText_pwd)
    EditText editTextPwd;
    @Bind(R.id.editText_sex)
    EditText editTextSex;
    @Bind(R.id.editText_age)
    EditText editTextAge;
    @Bind(R.id.editText_address)
    EditText editTextAddress;
    @Bind(R.id.button_add)
    Button buttonAdd;
    @Bind(R.id.button_select_all)
    Button buttonSelectAll;
    @Bind(R.id.tv_output)
    TextView tvOutput;
    @Bind(R.id.scrollView)
    ScrollView scrollView;
    String find_all_data_url = "http://192.168.1.104/PHP_test_01/com.liu_php_test/findAllData.php";
    String add_data_url = "http://192.168.1.104/PHP_test_01/com.liu_php_test/add.php";

    String test_url="http://222.173.68.166:7777/SmartCommunity_API/forum/note/add";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        setBackBtn();
        setTopTitle("测试");


    }

    //查询所有数据
    private void getAlldata() {
        HttpRequest.get(find_all_data_url, new BaseHttpRequestCallback() {
            //请求网络前
            @Override
            public void onStart() {
                super.onStart();

            }

            //请求网络结束
            @Override
            public void onFinish() {
                super.onFinish();
            }

            //网络请求成功
            @Override
            protected void onSuccess(Object o) {
                final String res = o.toString();
                Log.d("OKHttp", "res==" + res);
                tvOutput.setText(res);
            }

            //请求失败（服务返回非法JSON、服务器异常、网络异常）
            @Override
            public void onFailure(int errorCode, String msg) {


                super.onFailure(errorCode, msg);
            }
        });
    }

    //添加数据
    private void addData(UserModle userModle) {

        RequestParams params = new RequestParams();
//        params.addFormDataPart("username", userModle.getName());
//        params.addFormDataPart("password", userModle.getPassword());
//        params.addFormDataPart("sex", userModle.getSex());
//        params.addFormDataPart("age", userModle.getAge());
//        params.addFormDataPart("address", userModle.getAddress());

//        {content=555555, themeId=1, userId=4007, communityId=1}

        params.addFormDataPart("content", "下雨了下雨了下雨了下雨了");
        params.addFormDataPart("themeId", "1");
        params.addFormDataPart("userId", "4007");
        params.addFormDataPart("communityId", "1");
        params.addFormDataPart("files", "/mnt/shared/Image/user1.jpg");




//        add_data_url=add_data_url+"?username="+userModle.getName()+"password="+userModle.getPassword()
//                +"sex="+userModle.getSex()+"age="+userModle.getAge()+"address="+userModle.getAddress();
        HttpRequest.get(test_url, params, new BaseHttpRequestCallback() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onFinish() {
                super.onFinish();
            }

            @Override
            protected void onSuccess(Object o) {
                String result = o.toString().trim();
                Log.d("OKHttp", "result==" + result);
                if (!TextUtils.isEmpty(result)) {
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        if (jsonObject.has("result")) {
                            boolean res = jsonObject.optBoolean("result");
                            if (res) {
                                Toast.makeText(getApplicationContext(), "数据添加成功", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "数据添加失败", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Log.d("OKHttp", "不存在---result==");
                        }
                    } catch (JSONException e) {
                        Log.d("OKHttp", "JSONException==" + e.getMessage() + "==" + e.getLocalizedMessage());
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                Log.d("OKHttp", "result=onFailure-errorCode=" + errorCode);
                Log.d("OKHttp", "result=onFailure-msg=" + msg);

            }
        });
    }

    @OnClick({R.id.button_add, R.id.button_select_all})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add:
                String name = editTextName.getText().toString().trim();
                String pwd = editTextPwd.getText().toString().trim();
                String age = editTextAge.getText().toString().trim();
                int age_2 = 0;
                if (!TextUtils.isEmpty(age)) {
                    age_2 = Integer.parseInt(age);
                } else {
                    age_2 = 0;
                }
                String sex = editTextSex.getText().toString().trim();
                String address = editTextAddress.getText().toString().trim();
                UserModle userModle = new UserModle(name, pwd, sex, age_2, address);
                if (CommonUtils.isOnline(this)) {
                    addData(userModle);
                } else {
                    Toast.makeText(this, "网络异常", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.button_select_all:
                if (CommonUtils.isOnline(this)) {
                    getAlldata();
                } else {
                    Toast.makeText(this, "网络异常", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
