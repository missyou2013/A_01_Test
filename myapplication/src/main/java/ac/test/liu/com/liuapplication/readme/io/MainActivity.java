package ac.test.liu.com.liuapplication.readme.io;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ac.test.liu.com.liuapplication.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_owl);
    }

    public void login(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
