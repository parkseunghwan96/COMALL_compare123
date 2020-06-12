package com.jbnu.comall.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jbnu.comall.R;
import com.jbnu.comall.base.BaseActivity;
import com.jbnu.comall.model.User;
import com.jbnu.comall.util.Cache;

import java.util.Objects;


public class SplashActivity extends BaseActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (isRemembered()) {
            autonomousSignIn();
        } else {
            delayAndMove(3000);
        }
    }

    public boolean isRemembered() {
        String remembered = preference().getString("id");
        return remembered != null;
    }

    public void delayAndMove(int mills) {
        handler.postDelayed(() ->
                moveAndFinish(SignInActivity.class), mills);
    }

    public void autonomousSignIn() {
        User user = new User();
        user.setId(preference().getString("id"));
        user.setPw(preference().getString("pw"));

        firebaseSignIn(user);
    }

    private void firebaseSignIn(User user) {
        FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(user.getId(), user.getPw())
                .addOnSuccessListener(c -> FirebaseDatabase.getInstance()
                        .getReference("users")
                        .child(Objects.requireNonNull(FirebaseAuth.getInstance().getUid()))
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                User loadedUser = dataSnapshot.getValue(User.class);
                                Cache.copyUser(loadedUser);
                                moveAndFinish(MainActivity.class);
                            }

                            @Override public void onCancelled(@NonNull DatabaseError databaseError) {
                                toast("자동 로그인에 실패했습니다.");

                                handler.postDelayed(() ->
                                        moveAndFinish(SignInActivity.class), 3000);
                            }
                        }))
                .addOnFailureListener(c -> toast("자동 로그인에 실패했습니다."));
    }
}
