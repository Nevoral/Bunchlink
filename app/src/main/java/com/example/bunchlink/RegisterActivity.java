package com.example.bunchlink;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    EditText username, email, password, password_confirm;
    Button reg_button;
    FirebaseAuth auth;
    DatabaseReference reference;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        password_confirm = findViewById(R.id.password_confirm);
        reg_button = findViewById(R.id.reg_button);
        auth = FirebaseAuth.getInstance();
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, StartActivity.class));
            }
        });

        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String txt_username = username.getText().toString();
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                String txt_com_pass = password_confirm.getText().toString();
                if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_com_pass)) {
                    Toast.makeText(RegisterActivity.this, "Všechny pole musí být plná!!!", Toast.LENGTH_SHORT).show();
                } else if (txt_password.length() < 8) {
                    Toast.makeText(RegisterActivity.this, "Heslo je příliš krátké!!!", Toast.LENGTH_SHORT).show();
                } else if (!txt_password.equals(txt_com_pass)) {
                    Toast.makeText(RegisterActivity.this, "Hesla se musí shodovat!!!", Toast.LENGTH_SHORT).show();
                }else {
                    register(txt_username, txt_email, txt_password);

                    }
            }
        });
    }
    private void register(final String txt_username, final String txt_email, String txt_password) {
        auth.createUserWithEmailAndPassword(txt_email, txt_password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = auth.getCurrentUser();
                    assert firebaseUser != null;
                    String userid = firebaseUser.getUid();
                    reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("id", userid);
                    hashMap.put("username", txt_username);
                    hashMap.put("imageURL", "default");

                    hashMap.put("email", txt_email);
                    hashMap.put("phone", "Phone number");
                    hashMap.put("first_name", "First name");
                    hashMap.put("last_name", "Last name");
                    hashMap.put("birtdate", "01. 01. 1990");
                    hashMap.put("facebookURL", "facebookURL");
                    hashMap.put("instagramURL", "instagramURL");
                    hashMap.put("linkinURL", "linkURL");
                    hashMap.put("status", "offline");
                    hashMap.put("search", txt_username.toLowerCase());

                    reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(RegisterActivity.this, ProfileActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                } else {
                    Toast.makeText(RegisterActivity.this, "Nemůžeš se registrovat s tímto emailem/heslem!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
