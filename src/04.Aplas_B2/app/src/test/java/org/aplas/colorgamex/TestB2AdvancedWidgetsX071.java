package org.aplas.colorgamex;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
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
import java.util.List;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestB2AdvancedWidgetsX071 extends ViewTest {
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
    public void check_01_Fields_Availability() { //Check Layout Specification
        MyActivity act = new MyActivity();
        testField(act,"isStarted", -1, boolean.class,false);
        testItem(false,(boolean)getFieldValue(activity,"isStarted"),"isStarted should be false",1);
    }

    @Test
    public void check_02_Start_Game() {
        ((Button)activity.findViewById(R.id.startBtn)).performClick();
        testItem(0,((ProgressBar)activity.findViewById(R.id.progressScore)).getProgress(),"Progress on progressScore should be 0",1);
        testItem("0",((TextView)activity.findViewById(R.id.scoreText)).getText().toString(),"Text on scoreText should be \"0\"",1);
        testItem(View.INVISIBLE,((Button)activity.findViewById(R.id.startBtn)).getVisibility(),"startBtn should be INVISIBLE",1);
        testItem(true,(boolean)getFieldValue(activity,"isStarted"),"isStarted should be true",1);

        //Test displayed text
        //int resId = activity.getResources().getIdentifier("colorList", "array", activity.getPackageName());
        String[] temp = activity.getResources().getStringArray(R.array.colorList);
        List<String> clrList = Arrays.asList(temp);
        String disp = ((TextView)activity.findViewById(R.id.clrText)).getText().toString();
        testItem(null,clrList.contains(disp),"clrText text should be one of "+ Arrays.toString(temp),3);

        //Test Countdowntimer
        CountDownTimer x = (CountDownTimer)getFieldValue(activity,"countDown");
        ShadowCountDownTimer y = Shadows.shadowOf(x);
        testItem(null, y.hasStarted(),"Countdowntimer should be started",3);

    }
}
