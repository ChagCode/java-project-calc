package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editTextAnswer = findViewById(R.id.editTextAnswer);
        Button buttonAnswer = findViewById(R.id.buttonAnswer);
        TextView textViewIncorrect = findViewById(R.id.textViewIncorrct);
        TextView textViewCorrect = findViewById(R.id.textViewCorrct);
        TextView textViewRandomNumb1 = findViewById(R.id.textViewRandomNumb1);
        TextView textViewRandomNumb2 = findViewById(R.id.textViewRandomNumb2);

        Random random = new Random();
        int randomNumber1 = random.nextInt(51);  // вернёт случайное число от 0 до 50
        int randomNumber2 = random.nextInt(51);  // вернёт случайное число от 0 до 50
        int sumNumbers = randomNumber1 + randomNumber2;
        // Вывод на экран случайных чисел
        textViewRandomNumb1.setText("" + randomNumber1);
        textViewRandomNumb2.setText("" + randomNumber2);

         // добавляем слушатель клика
        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAnswer = editTextAnswer.getText().toString();
                int numbAnswer = Integer.parseInt(textAnswer);
                if (numbAnswer == sumNumbers) {
                    textViewIncorrect.setVisibility(View.GONE);
                    textViewCorrect.setVisibility(View.VISIBLE);
                } else {
                    textViewIncorrect.setVisibility(View.VISIBLE);
                    textViewCorrect.setVisibility(View.GONE);
                }
            }
        });









    }
}