package org.aplas.colorgamex;

import android.os.CountDownTimer;
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

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestB2AdvancedWidgetsX051 extends ViewTest {
    private MyActivity activity;
    //private LinearLayout mainLayout;

    @Before
    public void initTest() {
        startActivity();
    }

    private void startActivity() throws NullPointerException, ClassCastException {
        /****** initiation of Test ******/
        //Robolectric Pack
        activity = Robolectric.buildActivity(MyActivity.class).create().get();

        //Load main layout
        //String layoutName = "mainLayout";
        //int compId = activity.getResources().getIdentifier(layoutName, "id", activity.getPackageName());
        //mainLayout = (LinearLayout) activity.findViewById(compId);
    }

    @Test
    public void check_01_Fields_Availability() { //Check Layout Specification
        MyActivity act = new MyActivity();
        testField(act,"countDown", -1, CountDownTimer.class,true);
        testField(act,"FORMAT", -1, String.class,false);
        testFieldValue(act,"FORMAT","%d:%d");

        testMethod(act,"initTimer", -1,new Class[0],void.class);
    }

    @Test
    public void check_02_Countdowntimer() {
        CountDownTimer x = (CountDownTimer)getFieldValue(activity,"countDown");
        testItem(null, x,"Countdowntimer should be declared and initiated first",6);

        ShadowCountDownTimer y = Shadows.shadowOf(x);

        //Setting of Countdowntimer
        long maxTimer = 5000;
        long interval = 1;
        testItem(maxTimer, y.getMillisInFuture(),"Max timer (Millis in future) value should be "+maxTimer,1);
        testItem(interval, y.getCountDownInterval(),"Countdown interval value should be "+interval,1);

        //Setting of time format
        TextView timer = ((TextView)activity.findViewById(R.id.timerText));
        testItem("timer", timer.getText().toString(),"Initial text of timer is wrong",1);
        y.invokeTick(1234);
        testItem("1:234", timer.getText().toString(),"Count down interval is wrong",1);
        y.invokeTick(5000);
        testItem("5:0", timer.getText().toString(),"Finish time value is wrong",1);

        //Countdown timer start
        testItem(null, y.hasStarted(),"When on create, Countdowntimer should not be started",4);
        y.invokeTick(1234);
        CountDownTimer z = x.start();
        testItem(null, y.hasStarted(),"Countdowntimer should be startable",3);
        testItem("timer", timer.getText().toString(),"Timer text should be changed",2);

        //testItem(";",c,x.toString(),1);
    }
}
