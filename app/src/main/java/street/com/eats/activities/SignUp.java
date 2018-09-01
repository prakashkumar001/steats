package street.com.eats.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import street.com.eats.R;
import street.com.eats.interfaces.ApiResult;
import street.com.eats.pojo.request.SignUpRequest;

/**
 * Created by Creative IT Works on 09-Jul-18.
 */

public class SignUp extends BaseActivity {
    Button submit;
    EditText name, email, mobile, password, c_password;
    CheckBox accept_terms;
    TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        intailiseView();
        title.setText("Create New Account");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp.this, Login.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void intailiseView() {
        title = (TextView) findViewById(R.id.title);
        submit = (Button) findViewById(R.id.submit);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        mobile = (EditText) findViewById(R.id.mobile);
        password = (EditText) findViewById(R.id.password);
        c_password = (EditText) findViewById(R.id.c_password);
        accept_terms = (CheckBox) findViewById(R.id.accept);
    }

    public void register() {
        SignUpRequest signUpRequest=new SignUpRequest(name.getText().toString(),email.getText().toString(),mobile.getText().toString(),password.getText().toString());

        callApi("Signup", (Object)signUpRequest, new ApiResult() {
            @Override
            public void onPreExecute() {
                showProgessDialog("", "Loading...");
            }

            @Override
            public void onSucess(Object object, int resultCode) {

                hideProgressDialog();
            }

            @Override
            public void onFailure(Object object, int resultCode) {
                hideProgressDialog();
            }
        });
    }
}
