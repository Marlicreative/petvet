package com.margot.petvet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Margot on 30/05/17.
 */

public class Register extends AppCompatActivity {

    @BindView(R.id.btn_registerdos)
    Button btn_registerdos;

    private EditText mNameField;
    private EditText mEmailField;
    private EditText mPasswordField;

    private Button mRegisterButton;

    private FirebaseAuth mAuth;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        ButterKnife.bind(this);

       /** btn_registerdos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Perfil.class);
                startActivity(intent);
            }

        });*/

        mAuth = FirebaseAuth.getInstance();
        mNameField = (EditText) findViewById(R.id.et_name);
        mEmailField = (EditText) findViewById(R.id.et_email);
        mPasswordField = (EditText) findViewById(R.id.et_password);
        mRegisterButton = (Button) findViewById(R.id.btn_registerdos);

        mProgress = new ProgressDialog(this);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRegister();
            }
        });
    }

    private void startRegister(){
        final String name = mNameField.getText().toString().trim();
        String email = mEmailField.getText().toString().trim();
        String password = mPasswordField.getText().toString().trim();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            mProgress.setMessage("Espere un momento");
            mProgress.show();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            mProgress.dismiss();
                            if (task.isSuccessful()){
                                Intent intent = new Intent(Register.this, Perfil.class);
                                startActivity(intent);
                                /**String user_id = mAuth.getCurrentUser().getUid();
                                Toast.makeText(Register.this, user_id, Toast.LENGTH_SHORT).show();
                                btn_registerdos.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(Register.this, Perfil.class);
                                        startActivity(intent);
                                    }

                                });*/
                            }else {
                                Toast.makeText(getApplicationContext(),"Revisa tus datos",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }
}
