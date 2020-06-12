package com.jbnu.comall.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.jbnu.comall.R;
import com.jbnu.comall.base.BaseActivity;
import com.jbnu.comall.model.User;
import com.jbnu.comall.util.Strings;

import java.util.Objects;


public class SignUpActivity extends BaseActivity {

    private EditText emailField;
    private EditText passwordField;
    private EditText nameField;
    private TextView signUpButton;
    private final int MAX_PASSWORD = 6;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);
        nameField = findViewById(R.id.name_field);
        signUpButton = findViewById(R.id.sign_up_button);

        signUpButton.setOnClickListener(v -> {
            User user = new User();
            user.setId(emailField.getText().toString());
            user.setPw(passwordField.getText().toString());
            user.setName(nameField.getText().toString());

            if (check(user)) {
                showProgress();
                firebaseSignUp(user);
            }
        });
    }

    public boolean check(User user) {
        if (Strings.empty(user.getId())) return hideAndToast("아이디를 입력해주세요.");
        else if (Strings.empty(user.getPw())) return hideAndToast("비밀번호를 입력해주세요.");
        else if (user.getPw().length() < MAX_PASSWORD)
            return hideAndToast("비밀번호는 " + MAX_PASSWORD + "자 이상이여야 합니다.");
        else if (Strings.empty(user.getName())) return hideAndToast("이름을 입력해주세요.");
        else return true;
    }

    private void firebaseSignUp(User user) {
        FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(user.getId(), user.getPw())
                .addOnSuccessListener(c -> {
                    FirebaseDatabase.getInstance()
                            .getReference("users")
                            .child(Objects.requireNonNull(FirebaseAuth.getInstance().getUid()))
                            .setValue(user);

                    hideAndToast("회원가입에 성공하였습니다.");
                    moveAndFinish(SignInActivity.class);
                })
                .addOnFailureListener(c -> hideAndToast("회원가입에 실패했습니다."));
    }
}
