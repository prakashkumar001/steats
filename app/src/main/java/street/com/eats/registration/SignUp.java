package street.com.eats.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import street.com.eats.R;
import street.com.eats.login.Login;

/**
 * Created by Creative IT Works on 09-Jul-18.
 */

public class SignUp extends AppCompatActivity {
    Button submit;
    EditText name,email,mobile,password,c_password;
    CheckBox accept_terms;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        intailiseView();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignUp.this, Login.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void intailiseView()
    {
        submit=(Button)findViewById(R.id.submit);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        mobile = (EditText) findViewById(R.id.mobile);
        password = (EditText) findViewById(R.id.password);
        c_password = (EditText) findViewById(R.id.c_password);
        accept_terms = (CheckBox) findViewById(R.id.accept);
    }
}
