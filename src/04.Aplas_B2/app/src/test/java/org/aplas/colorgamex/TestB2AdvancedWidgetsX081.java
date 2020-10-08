package org.aplas.colorgamex;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowCountDownTimer;

import java.util.Arrays;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestB2AdvancedWidgetsX081 extends ViewTest {
    private MyActivity activity;

    @Before
    public void initTest() {
        startActivity();
    }

    private void startActivity() throws NullPointerException, ClassCastException {
        /****** initiation of Test ******/
        //Robolectric Pack
        activity = Robolectric.buildActivity(MyActivity.class).create().get();
    }

    @Test
    public void check_01_Before_Game() { //Check Layout Specification
        TextView disp = (TextView)activity.findViewById(R.id.clrText);

        ((Button)activity.findViewById(R.id.color1)).performClick();
        testItem("",disp.getText().toString(),"clrText text should be \"\"",1);
        ((Button)activity.findViewById(R.id.color2)).performClick();
        testItem("",disp.getText().toString(),"clrText text should be \"\"",1);
        ((Button)activity.findViewById(R.id.color3)).performClick();
        testItem("",disp.getText().toString(),"clrText text should be \"\"",1);
        ((Button)activity.findViewById(R.id.color4)).performClick();
        testItem("",disp.getText().toString(),"clrText text should be \"\"",1);
        ((Button)activity.findViewById(R.id.color5)).performClick();
        testItem("",disp.getText().toString(),"clrText text should be \"\"",1);
        ((Button)activity.findViewById(R.id.color6)).performClick();
        testItem("",disp.getText().toString(),"clrText text should be \"\"",1);
    }

    @Test
    public void check_02_Right_Answer() {
        ((Button)activity.findViewById(R.id.startBtn)).performClick();
        CountDownTimer x = (CountDownTimer)getFieldValue(activity,"countDown");
        ShadowCountDownTimer y = Shadows.shadowOf(x);
        y.invokeTick(3000);

        TextView clrText = (TextView)activity.findViewById(R.id.clrText);
        ProgressBar progress = (ProgressBar)activity.findViewById(R.id.progressScore);
        TextView score = (TextView) activity.findViewById(R.id.scoreText);
        int counter = activity.getResources().getInteger(R.integer.counter);
        String exTxt;

        for (int i=1; i<=9; i++) {
            exTxt = clrText.getText().toString();
            clickCorrectButton(exTxt);
            testItem(i*counter,progress.getProgress(),"Progress value should be " + (i*counter),1);
            testItem(String.valueOf(i*counter),score.getText().toString(),"scoreText value should be " + (i*counter),1);
            testItem(exTxt,clrText.getText().toString(),"clrText value should has new color after clicking color button",2);
        }

        clickCorrectButton(clrText.getText().toString());
        testItem(100,progress.getProgress(),"Progress value should be " + (10*counter),1);
        testItem("100",score.getText().toString(),"scoreText value should be " + (10*counter),1);
        testItem("COMPLETE",((TextView)activity.findViewById(R.id.timerText)).getText().toString(),"When finished, timer value should be \"COMPLETE\"",1);
        testItem(null, y.hasStarted(),"Countdowntimer should be stopped",4);

        testItem(false,(boolean)getFieldValue(activity,"isStarted"),"isStarted should be false",1);
        testItem(View.VISIBLE,((Button)activity.findViewById(R.id.startBtn)).getVisibility(),"startBtn should be VISIBLE",1);

    }

    @Test
    public void check_03_Wrong_Answer() {
        ((Button)activity.findViewById(R.id.startBtn)).performClick();
        CountDownTimer x = (CountDownTimer)getFieldValue(activity,"countDown");
        ShadowCountDownTimer y = Shadows.shadowOf(x);
        y.invokeTick(3000);

        TextView clrText = (TextView)activity.findViewById(R.id.clrText);
        ProgressBar progress = (ProgressBar)activity.findViewById(R.id.progressScore);
        TextView score = (TextView) activity.findViewById(R.id.scoreText);
        Switch minus = (Switch)activity.findViewById(R.id.isMinus);
        int counter = activity.getResources().getInteger(R.integer.counter);
        String exTxt;

        exTxt = clrText.getText().toString();
        clickInCorrectButton(exTxt);
        testItem(0,progress.getProgress(),"Progress value should not be changed when push incorrect color and score still 0" + 0,1);
        testItem("0",score.getText().toString(),"scoreText value should not be changed when push incorrect color and score still 0" + 0,1);
        testItem(exTxt,clrText.getText().toString(),"clrText value should has new color after clicking color button",2);

        minus.setChecked(true);
        exTxt = clrText.getText().toString();
        clickInCorrectButton(exTxt);
        testItem(0,progress.getProgress(),"Progress value should not be changed when push incorrect color, score still 0, and switch isMinus is on" + 0,1);
        testItem("0",score.getText().toString(),"scoreText value should not be changed when push incorrect color, score still 0, and switch isMinus is on" + 0,1);
        testItem(exTxt,clrText.getText().toString(),"clrText value should has new color after clicking color button",2);

        for (int i=1; i<=4; i++) {
            clickCorrectButton(clrText.getText().toString());
        }

        minus.setChecked(false);
        int exProgress = progress.getProgress();
        //String exScore = score.getText().toString();
        exTxt = clrText.getText().toString();
        clickInCorrectButton(exTxt);
        testItem(exProgress,progress.getProgress(),"Progress value should not be changed when push incorrect color and switch isMinus is off",1);
        testItem(String.valueOf(exProgress),score.getText().toString(),"scoreText value should not be changed when push incorrect color and switch isMinus is off" + 0,1);
        testItem(exTxt,clrText.getText().toString(),"clrText value should has new color after clicking color button",2);

        minus.setChecked(true);
        exTxt = clrText.getText().toString();
        clickInCorrectButton(exTxt);
        testItem(exProgress-counter,progress.getProgress(),"Progress value should reduce with 10 when push incorrect color and switch isMinus is on",1);
        testItem(String.valueOf(exProgress-counter),score.getText().toString(),"scoreText value should reduce with 10 when push incorrect color and switch isMinus is on" + 0,1);
        testItem(exTxt,clrText.getText().toString(),"clrText value should has new color after clicking color button",2);
    }

    @Test
    public void check_04_No_Answer() {
        ((Button)activity.findViewById(R.id.startBtn)).performClick();
        CountDownTimer x = (CountDownTimer)getFieldValue(activity,"countDown");
        ShadowCountDownTimer y = Shadows.shadowOf(x);
        //y.invokeTick(3000);

        TextView clrText = (TextView)activity.findViewById(R.id.clrText);
        ProgressBar progress = (ProgressBar)activity.findViewById(R.id.progressScore);
        TextView score = (TextView) activity.findViewById(R.id.scoreText);
        Switch minus = (Switch)activity.findViewById(R.id.isMinus);
        int counter = activity.getResources().getInteger(R.integer.counter);
        String exTxt;

        exTxt = clrText.getText().toString();
        x.onFinish();
        testItem(0,progress.getProgress(),"Progress value should not be changed when time is over  and score still 0" + 0,1);
        testItem("0",score.getText().toString(),"scoreText value should not be changed when time is over and score still 0" + 0,1);
        testItem(exTxt,clrText.getText().toString(),"clrText value should has new color after clicking color button",2);

        minus.setChecked(true);
        exTxt = clrText.getText().toString();
        x.onFinish();
        testItem(0,progress.getProgress(),"Progress value should not be changed when time is over, score still 0, and switch isMinus is on" + 0,1);
        testItem("0",score.getText().toString(),"scoreText value should not be changed time is over, score still 0, and switch isMinus is on" + 0,1);
        testItem(exTxt,clrText.getText().toString(),"clrText value should has new color after clicking color button",2);

        for (int i=1; i<=4; i++) {
            clickCorrectButton(clrText.getText().toString());
        }

        minus.setChecked(false);
        exTxt = clrText.getText().toString();
        x.onFinish();
        //y.invokeTick(5001);
        testItem(null, y.hasStarted(),"Countdowntimer should be still running",3);
        int exProgress = progress.getProgress();
        testItem(exProgress,progress.getProgress(),"Progress value should not be changed when time is over and switch isMinus is off",1);
        testItem(String.valueOf(exProgress),score.getText().toString(),"scoreText value should not be changed when time is over and switch isMinus is off" + 0,1);
        testItem(exTxt,clrText.getText().toString(),"clrText value should has new color after time is over",2);

        minus.setChecked(true);
        exTxt = clrText.getText().toString();
        x.onFinish();
        testItem(exProgress-counter,progress.getProgress(),"Progress value should reduce with 10 when time is over and switch isMinus is on",1);
        testItem(String.valueOf(exProgress-counter),score.getText().toString(),"scoreText value should reduce with 10 when time is over and switch isMinus is on" + 0,1);
        testItem(exTxt,clrText.getText().toString(),"clrText value should has new color after time is over",2);
    }

    private void clickCorrectButton(String clr) {
        //String[] list = (String[])getFieldValue(activity,"clrList");
        String[] list = activity.getResources().getStringArray(R.array.colorList);
        int idx = Arrays.asList(list).indexOf(clr)+1;
        int compId = activity.getResources().getIdentifier("color"+idx, "id", activity.getPackageName());
        ((Button)activity.findViewById(compId)).performClick();
    }

    private void clickInCorrectButton(String clr) {
        //String[] list = (String[])getFieldValue(activity,"clrList");
        String[] list = activity.getResources().getStringArray(R.array.colorList);
        int idx = Arrays.asList(list).indexOf(clr)+1;
        int compId = activity.getResources().getIdentifier("color"+((idx==6)?1:idx+1), "id", activity.getPackageName());
        ((Button)activity.findViewById(compId)).performClick();
    }
}
