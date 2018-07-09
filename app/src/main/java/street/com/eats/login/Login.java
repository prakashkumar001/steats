package street.com.eats.login;

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
import street.com.eats.activities.MainActivity;
import street.com.eats.forgotpassword.ForgotPassword;

/**
 * Created by Creative IT Works on 09-Jul-18.
 */

public class Login extends AppCompatActivity {
    EditText email,password;
    Button login;
    TextView forgetpassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        intailiseView();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Login.this, MainActivity.class);
                startActivity(i);
            }
        });

        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Login.this, ForgotPassword.class);
                startActivity(i);
            }
        });
    }

    private void intailiseView()
    {
        login=(Button)findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        forgetpassword= (TextView) findViewById(R.id.forgotpassword);

    }
}
