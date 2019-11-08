package com.example.macroviz.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //final int DIALOG_ID = 1;  沒這行沒差
    private Button btnmsg,btnchoice;
    String[] str_list = {"葡萄", "香蕉", "水蜜桃","蘋果","鳳梨"};
    private AlertDialog dialog = null;
    AlertDialog.Builder builder = null;

    @Override//沒差
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnchoice = findViewById(R.id.btnChoice);
        btnmsg = findViewById(R.id.btnMsg);
        btnmsg.setOnClickListener(new View.OnClickListener() {
            //@Override沒差
            public void onClick(View view) {

                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("訊息")
                        .setIcon(R.mipmap.question)
                        .setMessage("確定要離開?")
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            //設定確定按鈕
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            //設定取消按鈕
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                dialog = builder.create();
                dialog.show();
            }
        });
        btnchoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("請選擇您喜歡的水果")
                        .setIcon(R.mipmap.pineapple)

                        .setSingleChoiceItems(str_list, 0, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(MainActivity.this,"您選擇的是:"+str_list[i],Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
                dialog = builder.create();
                dialog.show();
            }
        });

    }
}
