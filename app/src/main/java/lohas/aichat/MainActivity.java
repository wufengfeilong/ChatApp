package lohas.aichat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lohas.aichat.activity.HomeActivity;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @OnClick(R.id.login_btn)
    public void login() {
        String name = userName.getText().toString();
        String pwd = password.getText().toString();
        if (name == null || "".equals(name)) {
            userName.setError("请输入你的用户名。");
            return;
        } else {
            userName.setError(null);
        }
        if (pwd == null || "".equals(pwd)) {
            password.setError("请输入你的密码。");
            return;
        } else {
            password.setError(null);
        }
        if ("zfw".equals(name) && "123".equals(pwd)) {
            startActivity(new Intent(this, HomeActivity.class));
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "用户名密码不匹配。", Toast.LENGTH_SHORT).show();
        }
    }
}
