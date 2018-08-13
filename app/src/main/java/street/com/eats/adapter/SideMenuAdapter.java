package street.com.eats.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import street.com.eats.R;
import street.com.eats.activities.MainActivity;
import street.com.eats.fragment.FirstMenuFragment;
import street.com.eats.fragment.SignOut;
import street.com.eats.login.Login;
import street.com.eats.model.Menu;

public class SideMenuAdapter extends RecyclerView.Adapter<SideMenuAdapter.MyViewHolder> {

    List<Menu> details;
    Activity ctx;

    GoogleSignInClient  mGoogleSignInClient;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView productname;
        public ImageView image;



        public MyViewHolder(View view) {
            super(view);
            productname = (TextView) view.findViewById(R.id.title);
            image = (ImageView) view.findViewById(R.id.image);


        }
    }


    public SideMenuAdapter(Activity context, List<Menu> details) {

        this.details = details;
        ctx = context;

    }

    @Override
    public SideMenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nav_list_item, parent, false);


        return new SideMenuAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SideMenuAdapter.MyViewHolder holder, final int position) {
        holder.productname.setText(details.get(position).name);
        holder.image.setImageResource(details.get(position).logo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(details.get(position).name.equalsIgnoreCase("Sign Out"))
                {
                    showLogoutDialog();
                }else
                {
                    Fragment comedy = details.get(position).fragment;

                    FragmentManager fragmentManager = ((MainActivity) ctx).getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.contentPage, comedy)
                            .commit();

                    MainActivity.viewPager.setCurrentItem(1);
                }



            }
        });

    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public void showLogoutDialog() {

        // custom dialog
        final Dialog dialog = new Dialog(ctx, R.style.ThemeDialogCustom);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ctx.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int widthLcl = (int) (displayMetrics.widthPixels*0.9f);
        int heightLcl = (int) (displayMetrics.heightPixels*0.9f);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.logout);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();

        ImageView iv_close=(ImageView)dialog.findViewById(R.id.iv_close);
        Button cancel=(Button)dialog.findViewById(R.id.cancel);
        Button logout=(Button)dialog.findViewById(R.id.logout);

        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setLayout((9 * widthLcl) / 10, (5 * heightLcl) / 10);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Then we need a GoogleSignInOptions object
                //And we need to build it as below
                dialog.dismiss();
                FirebaseAuth.getInstance().signOut();
                Intent intent= new Intent(ctx, Login.class);
                ctx.startActivity(intent);
                ctx.finish();
            }
        });
        dialog.show();



    }


}
