package com.rohan.customdialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    AppCompatButton dlg,btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);
        dlg = findViewById(R.id.dlg);
        btn = dialog.findViewById(R.id.btn);
        Toast toast = new Toast(MainActivity.this);
        View view=getLayoutInflater().inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.ll));
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.RIGHT,0,0);
        if (dialog.getWindow() != null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        dlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        toast.show();
                    }
                });
            }
        });


    }
}