package com.sotatek.locnguyen.pokertexasholdem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by locnguyen on 16/11/2016.
 */
public class InputQuantityPlayerActivity extends Activity {
    EditText edt_inputquantityplayer;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputquantityplayer);
        initView();
        initListener();
    }

    private void initListener() {
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InputQuantityPlayerActivity.this, MainActivity.class);
                intent.putExtra("quantity", edt_inputquantityplayer.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void initView() {
        edt_inputquantityplayer = (EditText) findViewById(R.id.edt_inputquantityplayer);
        btn_send = (Button) findViewById(R.id.btn_send);
    }


}
