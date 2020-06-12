package com.jbnu.comall.base;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.jbnu.comall.R;
import com.jbnu.comall.util.Preference;


public abstract class BaseActivity extends AppCompatActivity {
    protected Handler handler = new Handler();

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }

    public void moveAndFinish(Class<? extends BaseActivity> activity) {
        this.move(activity);
        this.finish();
    }

    public void move(Class<? extends BaseActivity> activity) {
        this.startActivity(new Intent(this, activity));
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showProgress() {
        findViewById(R.id.progress)
                .setVisibility(View.VISIBLE);
    }

    public boolean hideAndToast(String msg) {
        toast(msg);
        findViewById(R.id.progress)
                .setVisibility(View.INVISIBLE);

        return false;
    }

    public Preference preference() {
        return Preference.getInstance(this);
    }

    public void replace(FragmentTransaction transaction, int resid, Fragment fragment) {
        transaction.replace(resid, fragment).commit();
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }
}
