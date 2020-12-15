package com.haidar.mulchoqu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.haidar.mulchoqu.R;
import com.haidar.mulchoqu.model.soal.SoalModel;
import com.haidar.mulchoqu.model.soal.SoalResult;
import com.haidar.mulchoqu.retrofit.ApiService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView question, qCount, timer;
    private Button option1, option2, option3, option4;
    private int quesNumber=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        String id_kategori = getIntent().getStringExtra("id_kategori");
        getDataFromApi("https://opentdb.com/api.php?amount=20&category="+id_kategori+"&difficulty=medium&type=multiple");

        question = findViewById(R.id.qustion);
        qCount = findViewById(R.id.question_number);
        timer = findViewById(R.id.countdown);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String selectedoption = null;
        switch(view.getId()){
            case R.id.option1:
                selectedoption = option1.getText().toString();
                break;
            case R.id.option2:
                selectedoption = option2.getText().toString();
                break;
            case R.id.option3:
                selectedoption = option3.getText().toString();
                break;
            case R.id.option4:
                selectedoption = option4.getText().toString();
                break;
            default:
        }

        CountDown.cancel();
        checkAnswer(selectedoption,quesNumber,view);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private final String Tag = "Data_Pertanyaan";
    private List<SoalResult> daftar_soal;

    private void getDataFromApi(String url) {

        ApiService.endpoint().getSoal(url).enqueue(new Callback<SoalModel>() {
            @Override
            public void onResponse(Call<SoalModel> call, Response<SoalModel> response) {
                daftar_soal  = response.body().getResults();
                setQuestion();
            }

            @Override
            public void onFailure(Call<SoalModel> call, Throwable t) {
                Log.d(Tag, t.getMessage());
            }
        });
    }

    private void setQuestion(){
        timer.setText(String.valueOf(10));
        if(daftar_soal!=null){
            question.setText(daftar_soal.get(quesNumber).getQuestion());

            shuffle_jawaban(quesNumber);

            option1.setText(jawaban.get(0));
            option2.setText(jawaban.get(1));
            option3.setText(jawaban.get(2));
            option4.setText(jawaban.get(3));

            qCount.setText(1 + " / " + daftar_soal.size());

            startTimer();
        }else{
            Log.d("check_data", "data_null");
        }

    }

    private CountDownTimer CountDown;
    private void startTimer(){
        CountDown = new CountDownTimer(12000,1000) {
            @Override
            public void onTick(long l) {
                if(l<10000){
                    timer.setText(String.valueOf(l/1000));
                }
            }

            @Override
            public void onFinish() {
                changeQuestion();
            }
        };
        CountDown.start();
    }

    ArrayList<String> jawaban = new ArrayList<String>();
    private void shuffle_jawaban(int index){
        jawaban.add(daftar_soal.get(index).getCorrectAnswer());
        jawaban.add(daftar_soal.get(index).getIncorrectAnswers().get(0));
        jawaban.add(daftar_soal.get(index).getIncorrectAnswers().get(1));
        jawaban.add(daftar_soal.get(index).getIncorrectAnswers().get(2));
        Collections.shuffle(jawaban);
    }

    private void checkAnswer(String userAnswer, int index,View v){
        if(userAnswer.equals(daftar_soal.get(quesNumber).getCorrectAnswer())){
            ((Button)v).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        }else{
            ((Button)v).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            String compare = daftar_soal.get(index).getCorrectAnswer();
            int indexjawaban = 0;
            for(int i=0; i<4; i++){
                if(compare.equals(jawaban.get(i))){
                    indexjawaban = i;
                    break;
                }
            }
            switch (indexjawaban){
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2 :
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3 :
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4 :
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
            }
        }

        //delay ganti soal
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                changeQuestion();
            }
        },2000);

    }

    private void changeQuestion(){
        if(quesNumber < daftar_soal.size()-1){
            quesNumber++;

            playanim(question, 0,0);
            playanim(option1, 0,1);
            playanim(option2, 0,2);
            playanim(option3, 0,3);
            playanim(option4, 0,4);

            qCount.setText(String.valueOf(quesNumber+1)+" / "+daftar_soal.size());

            timer.setText(String.valueOf(10));
            startTimer();

        }else{
            Intent intent = new Intent(QuestionActivity.this,ScoreActivity.class);
            startActivity(intent);
            QuestionActivity.this.finish();
        }
    }

    private void playanim(View view, final int value, int viewNum){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
        .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
        .setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onAnimationEnd(Animator animator) {
                shuffle_jawaban(quesNumber);
                if(value==0){
                    switch (viewNum){
                        case 0 :
                            ((TextView)view).setText(daftar_soal.get(quesNumber).getQuestion());
                            break;
                        case 1 :
                            ((Button)view).setText(jawaban.get(0));
                            break;
                        case 2 :
                            ((Button)view).setText(jawaban.get(1));
                            break;
                        case 3 :
                            ((Button)view).setText(jawaban.get(2));
                            break;
                        case 4 :
                            ((Button)view).setText(jawaban.get(3));
                            break;
                    }

                    if(viewNum!=0){
                        ((Button)view).setBackgroundTintList(ColorStateList.valueOf(R.color.hijau_basic_app));
                    }

                    playanim(view,1,viewNum);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        })
        ;
    }
}