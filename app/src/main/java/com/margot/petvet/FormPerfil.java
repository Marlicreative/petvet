package com.margot.petvet;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Margot on 01/06/17.
 */

public class FormPerfil extends AppCompatActivity {

    @BindView(R.id.btn_edit_perfil)
    Button btn_save_perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formperfil);
        ButterKnife.bind(this);

        btn_save_perfil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormPerfil.this, Perfil.class);
                startActivity(intent);
            }

        });
    }
}
