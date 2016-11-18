package com.sotatek.locnguyen.pokertexasholdem.customviews;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.sotatek.locnguyen.pokertexasholdem.R;

/**
 * Created by locnguyen on 18/11/2016.
 */
public class DialogCards extends Dialog {

    Context context;

    public DialogCards(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_main);
    }
}
