package com.margot.petvet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Margot on 26/05/17.
 */

public class Perfil extends AppCompatActivity {

    @BindView(R.id.btn_edit_perfil)
    Button btn_edit_perfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pefil);
        ButterKnife.bind(this);

        btn_edit_perfil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, FormPerfil.class);
                startActivity(intent);
            }

        });
    }
}
