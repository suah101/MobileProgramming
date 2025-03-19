package com.example.mobileprogramming;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 버튼 1: 네이트 홈페이지 열기
        button1 = (Button) findViewById(R.id.button1);
        button1.setText("네이트");
        button1.setBackgroundColor(Color.GREEN);  // 버튼 배경색 변경
        button1.setTextColor(Color.BLACK);        // 버튼 글씨색 변경
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "네이트로 이동", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"));
                startActivity(intent);
            }
        });

        // 버튼 2: 전화 걸기 (911)
        button2 = (Button) findViewById(R.id.button2);
        button2.setText("긴급전화 (911)");
        button2.setBackgroundColor(Color.RED);
        button2.setTextColor(Color.BLACK);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "911로 전화 겁니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"));
                startActivity(intent);
            }
        });

        // 버튼 3: 갤러리 열기
        button3 = (Button) findViewById(R.id.button3);
        button3.setText("갤러리 열기");
        button3.setBackgroundColor(Color.YELLOW);
        button3.setTextColor(Color.BLACK);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "갤러리를 엽니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(intent);
            }
        });

        // 버튼 4: 앱 종료
        button4 = (Button) findViewById(R.id.button4);
        button4.setText("앱 종료");
        button4.setBackgroundColor(Color.BLUE);
        button4.setTextColor(Color.BLACK);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "앱을 종료합니다", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}