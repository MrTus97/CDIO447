package com.tuphanthanh.phongtro.login.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tuphanthanh.phongtro.R;
import com.tuphanthanh.phongtro.login.presenter.ILoginPresenter;
import com.tuphanthanh.phongtro.login.presenter.LoginPresenter;
import com.tuphanthanh.phongtro.ultils.Validate;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginActivity {
    private final String TAG = LoginActivity.class.getSimpleName();
    private LoginPresenter loginPresenter;

    private EditText edtUsername,edtPassword;
    private Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mapMVP();
        init();
    }

    private void mapMVP() {
        loginPresenter = new LoginPresenter(this);
    }

    private void init() {
        edtUsername = findViewById(R.id.edtLoginAct_Username);
        edtPassword = findViewById(R.id.edtLoginAct_Password);
        btnSignIn = findViewById(R.id.btnLoginAct_SignIn);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLoginAct_SignIn:
                login();

                break;
            default:break;
        }
    }

    private void login() {
        View view = catchValidate();
        if (view !=null){
            view.requestFocus();
        }else{
            loginPresenter.login(edtUsername.getText().toString(),edtPassword.getText().toString());
        }
    }

    private View catchValidate() {
        edtUsername.setError(null);
        edtPassword.setError(null);
        if (TextUtils.isEmpty(edtUsername.getText().toString())){
            edtUsername.setError(getString(R.string.login_error_thisFiledIsNotNull));
            return edtUsername;
        }
        if (TextUtils.isEmpty(edtPassword.getText().toString())){
            edtPassword.setError(getString(R.string.login_error_thisFiledIsNotNull));
            return edtPassword;
        }
//        if (!Patterns.EMAIL_ADDRESS.matcher(edtUsername.getText().toString()).matches()){
//            edtUsername.setError(getString(R.string.login_error_wrongFormat));
//            return edtUsername;
//        }
        if (!Validate.isPatternPasswordLength(edtPassword.getText().toString())){
            edtPassword.setError(getString(R.string.login_error_lengthPassword));
            return edtPassword;
        }
        return null;
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"login success");

    }

    @Override
    public void loginFailure() {
        Toast.makeText(this,"failure",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"Login failure");
    }
}
