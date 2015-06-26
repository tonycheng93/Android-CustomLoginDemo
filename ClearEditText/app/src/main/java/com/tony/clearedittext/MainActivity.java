package com.tony.clearedittext;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Toast mToast;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ClearEditText username = (ClearEditText) findViewById(R.id.username);
        final ClearEditText password = (ClearEditText) findViewById(R.id.password);
        mButton = (Button) findViewById(R.id.login);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(username.getText())){
                    //设置晃动
                    username.setShakeAnimation();
                    //设置提示
                    showToast("用户名不能为空！");
                    return;
                }
                if (TextUtils.isEmpty(password.getText())){
                    password.setShakeAnimation();
                    showToast("密码不能为空！");
                    return;
                }
            }
        });
    }
    /**
     * 显示Toast消息
     * @param msg
     */
    private void showToast(String msg) {
        if (mToast == null){
            mToast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        }else{
            mToast.setText(msg);
        }
        mToast.show();
    }
}
