package com.jbnu.comall.activity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

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
import com.jbnu.comall.util.Strings;

import java.util.Objects;


public class SignInActivity extends BaseActivity {

    private EditText emailField;
    private EditText passwordField;
    private TextView moveToSignUpButton;
    private TextView signInButton;
    private CheckBox staySignedIn;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);
        moveToSignUpButton = findViewById(R.id.moveToSignUp);
        signInButton = findViewById(R.id.signInButton);
        staySignedIn = findViewById(R.id.stay_signed_in);

        signInButton.setOnClickListener(v -> {
            User user = new User();
            user.setId(emailField.getText().toString());
            user.setPw(passwordField.getText().toString());

            if (check(user)) {
                showProgress();
                firebaseSignIn(user);
            }
        });

        moveToSignUpButton.setOnClickListener(v ->
                move(SignUpActivity.class));
    }

    public boolean check(User user) {
        if (Strings.empty(user.getId())) return hideAndToast("아이디를 입력해주세요.");
        else if (Strings.empty(user.getPw())) return hideAndToast("비밀번호를 입력해주세요.");
        else return true;
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
                                System.out.println(loadedUser);
                                Cache.copyUser(loadedUser);
                                staySignedIn(staySignedIn.isChecked(), user);
                                moveAndFinish(MainActivity.class);
                            }

                            @Override public void onCancelled(@NonNull DatabaseError databaseError) {
                                toast("로그인에 실패했습니다.");
                            }
                        }))
                .addOnFailureListener(c -> hideAndToast("로그인에 실패했습니다."));
    }

    public void staySignedIn(boolean stay, User user) {
        if (stay) {
            preference().setString("id", user.getId());
            preference().setString("pw", user.getPw());
        } else {
            preference().setString("id", null);
            preference().setString("pw", null);
        }
    }
}
