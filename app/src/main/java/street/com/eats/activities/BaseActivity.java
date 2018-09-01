package street.com.eats.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import street.com.eats.interfaces.APIInterface;
import street.com.eats.interfaces.ApiResult;
import street.com.eats.interfaces.BaseView;
import street.com.eats.pojo.request.LoginRequest;
import street.com.eats.retrofit.APIClient;

public class BaseActivity extends AppCompatActivity implements BaseView {
    ProgressDialog progressDialog;


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void callApi(String key,Object object,final ApiResult result)
    {
        result.onPreExecute();
        Call call=null;

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        if(key.equalsIgnoreCase("Login"))
        {
            LoginRequest loginRequest=(LoginRequest)object;
             call=apiInterface.doLogin(loginRequest);
        }else if(key.equalsIgnoreCase("Test"))
        {
             call = apiInterface.doGetUserList("1");
        }


        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                Object object=new Object();
                object=(Object) response.body();
                result.onSucess(object,1);

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                call.cancel();
            }
        });


    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgessDialog(String title,String message) {
        progressDialog=new ProgressDialog(BaseActivity.this);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.show();

    }

    @Override
    public void hideProgressDialog() {
     progressDialog.dismiss();
    }

    @Override
    public void addFragment(int containerViewId, @NonNull Fragment fragment, @NonNull String fragmentTag) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerViewId, fragment, fragmentTag)
                .disallowAddToBackStack()
                .commit();
    }

    @Override
    public void startActivityIntent(Context a, Class b,Bundle bundle) {
        Intent i=new Intent(a,b);
        i.putExtra("data",bundle);
        startActivity(i);
    }


}
