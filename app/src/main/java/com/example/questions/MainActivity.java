package com.example.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Answer> questions = new ArrayList<Answer>();
    public static int questionNumber = 0;
    public static TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertQuestions();

        setQuestion();

        Button butTrue = findViewById(R.id.butTrue);
        butTrue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        Button butFalse = findViewById(R.id.butFalse);
        butFalse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        Button butPrevious = findViewById(R.id.butPrevious);
        butPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                questionNumber--;
                setQuestion();
            }
        });

        Button butNext = findViewById(R.id.butNext);
        butNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                questionNumber++;
                setQuestion();
            }
        });

    }

    public void checkAnswer(Boolean answer){
        if (answer == questions.get(questionNumber).getAnswer()){
            Toast.makeText(MainActivity.this, "Correcto!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_LONG).show();
        }
    }

    public void setQuestion(){
        question = findViewById(R.id.question);
        question.setText(questions.get(questionNumber).getQuestion());
        checkStatus();
    }

    public void insertQuestions(){
        questions.add(new Answer("Es esto una prueba?",true));
        questions.add(new Answer("Es esto un juego?",false));
    }

    public void checkStatus(){
        Button butPrevious = findViewById(R.id.butPrevious);
        Button butNext = findViewById(R.id.butNext);
        if(questionNumber == 0){
            butPrevious.setEnabled(false);
        }else{
            butPrevious.setEnabled(true);
        }
        if(questionNumber == questions.size()-1){
            butNext.setEnabled(false);
        }else{
            butNext.setEnabled(true);
        }
    }


}