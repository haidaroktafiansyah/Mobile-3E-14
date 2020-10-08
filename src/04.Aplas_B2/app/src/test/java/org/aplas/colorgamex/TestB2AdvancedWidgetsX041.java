package org.aplas.colorgamex;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestB2AdvancedWidgetsX041 extends ViewTest {
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
        testField(act,"clrText", -1, TextView.class,true);
        testField(act,"scoreText", -1, TextView.class,true);
        testField(act,"timer", -1, TextView.class,true);
        testField(act,"passwd", -1, EditText.class,true);
        testField(act,"submit", -1, Button.class,true);
        testField(act,"start", -1, Button.class,true);
        testField(act,"accessbox", -1, ViewGroup.class,true);
        testField(act,"colorbox", -1, ViewGroup.class,true);
        testField(act,"buttonbox1", -1, ViewGroup.class,true);
        testField(act,"buttonbox2", -1, ViewGroup.class,true);
        testField(act,"scorebox", -1, ViewGroup.class,true);
        testField(act,"progressbox", -1, ViewGroup.class,true);
        testField(act,"progress", -1, ProgressBar.class,true);
        testField(act,"isMinus", -1, Switch.class,true);
    }

    @Test
    public void check_02_Incorrect_Password() {
        String inputPwd = String.valueOf(getRandomInteger(10000,100000));
        ((EditText)activity.findViewById(R.id.appCode)).setText(inputPwd);
        ((Button)activity.findViewById(R.id.submitBtn)).performClick();
        testItem(null, ShadowToast.getLatestToast(),"No toast defined",6);
        testItem("Password is wrong", ShadowToast.getTextOfLatestToast().toString(),"Toast message is wrong",1);
        testItem(null, ShadowToast.showedToast("Password is wrong"),"Toast is not shown",3);

        View comp;
        comp = (View)activity.findViewById(R.id.appCode);
        testItem(View.VISIBLE,comp.getVisibility(),"appCode Visibility should be VISIBLE",1);
        comp = (View)activity.findViewById(R.id.submitBtn);
        testItem(View.VISIBLE,comp.getVisibility(),"submitBtn Visibility should be VISIBLE",1);
        comp = (View)activity.findViewById(R.id.accessBox);
        testItem(View.VISIBLE,comp.getVisibility(),"accessBox Visibility should be VISIBLE",1);
        comp = (View)activity.findViewById(R.id.colorBox);
        testItem(View.INVISIBLE,comp.getVisibility(),"colorCode Visibility should be INVISIBLE",1);
        comp = (View)activity.findViewById(R.id.buttonBox1);
        testItem(View.INVISIBLE,comp.getVisibility(),"buttonBox1 Visibility should be INVISIBLE",1);
        comp = (View)activity.findViewById(R.id.buttonBox2);
        testItem(View.INVISIBLE,comp.getVisibility(),"buttonBox2 Visibility should be INVISIBLE",1);
        comp = (View)activity.findViewById(R.id.scoreBox);
        testItem(View.INVISIBLE,comp.getVisibility(),"scoreBox Visibility should be INVISIBLE",1);
        comp = (View)activity.findViewById(R.id.progressBox);
        testItem(View.INVISIBLE,comp.getVisibility(),"progressBox Visibility should be INVISIBLE",1);

    }

    @Test
    public void check_03_Correct_Password() {
        String inputPwd = "quiz@123";
        ((EditText)activity.findViewById(R.id.appCode)).setText(inputPwd);
        ((Button)activity.findViewById(R.id.submitBtn)).performClick();
        testItem(null, ShadowToast.getLatestToast(),"No toast defined",6);
        testItem("Login Success", ShadowToast.getTextOfLatestToast().toString(),"Toast message is wrong",1);
        testItem(null, ShadowToast.showedToast("Login Success"),"Toast is not shown",3);

        View comp;
        comp = (View)activity.findViewById(R.id.appCode);
        testItem(View.INVISIBLE,comp.getVisibility(),"appCode Visibility should be INVISIBLE",1);
        comp = (View)activity.findViewById(R.id.submitBtn);
        testItem(View.INVISIBLE,comp.getVisibility(),"submitBtn Visibility should be INVISIBLE",1);
        comp = (View)activity.findViewById(R.id.accessBox);
        testItem(View.VISIBLE,comp.getVisibility(),"accessBox Visibility should be VISIBLE",1);
        comp = (View)activity.findViewById(R.id.colorBox);
        testItem(View.VISIBLE,comp.getVisibility(),"colorCode Visibility should be VISIBLE",1);
        comp = (View)activity.findViewById(R.id.buttonBox1);
        testItem(View.VISIBLE,comp.getVisibility(),"buttonBox1 Visibility should be VISIBLE",1);
        comp = (View)activity.findViewById(R.id.buttonBox2);
        testItem(View.VISIBLE,comp.getVisibility(),"buttonBox2 Visibility should be VISIBLE",1);
        comp = (View)activity.findViewById(R.id.scoreBox);
        testItem(View.VISIBLE,comp.getVisibility(),"scoreBox Visibility should be VISIBLE",1);
        comp = (View)activity.findViewById(R.id.progressBox);
        testItem(View.VISIBLE,comp.getVisibility(),"progressBox Visibility should be VISIBLE",1);

    }
}
