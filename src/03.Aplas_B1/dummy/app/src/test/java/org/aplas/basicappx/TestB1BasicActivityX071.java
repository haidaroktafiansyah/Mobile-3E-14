package org.aplas.basicappx;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestB1BasicActivityX071 extends ViewTest {
    private MainActivity activity;

    private RadioGroup unitType;
    private Spinner ori;
    private Spinner conv;
    private EditText inText;
    private EditText outText;

    private int inputVal;

    @Before
    public void initTest() {
        startActivity();
    }

    private void startActivity() throws NullPointerException, ClassCastException {
        /****** initiation of Test ******/
        //Robolectric Pack
        activity = Robolectric.buildActivity(MainActivity.class).create().get();

        unitType = (RadioGroup) activity.findViewById(R.id.radioGroup);
        ori = (Spinner)activity.findViewById(R.id.oriList);
        conv = (Spinner)activity.findViewById(R.id.convList);
        inText = (EditText) activity.findViewById(R.id.inputText);
        outText = (EditText) activity.findViewById(R.id.outputText);

        inputVal =getRandomInteger(0,1000);
        //inText.setText(String.valueOf(inputVal));
    }

    @Test
    public void check_01_DistanceCase() { //Check Layout Specification
        //Convert distance
        ((RadioButton)unitType.getChildAt(1)).setChecked(true);
        inText.setText(String.valueOf(inputVal));
        ori.setSelection(1);
        conv.setSelection(3);

        activity.doConvert();

        double res = activity.convertUnit("Distance",ori.getSelectedItem().toString(),conv.getSelectedItem().toString(),inputVal);
        testItem(activity.strResult(res,true),outText.getText().toString(),"doConvert in Distance is wrong",1);
    }

    @Test
    public void check_02_WeightCase() { //Check Layout Specification
        //Convert distance
        ((RadioButton)unitType.getChildAt(2)).setChecked(true);
        inText.setText(String.valueOf(inputVal));
        ori.setSelection(1);
        conv.setSelection(2);

        activity.doConvert();

        double res = activity.convertUnit("Weight",ori.getSelectedItem().toString(),conv.getSelectedItem().toString(),inputVal);
        testItem(activity.strResult(res,true),outText.getText().toString(),"doConvert in Weight is wrong",1);
    }

    @Test
    public void check_03_TemperatureCase() { //Check Layout Specification
        //Convert distance
        ((RadioButton)unitType.getChildAt(0)).setChecked(true);
        inText.setText(String.valueOf(inputVal));
        ori.setSelection(0);
        conv.setSelection(2);

        activity.doConvert();

        double res = activity.convertUnit("Temperature",ori.getSelectedItem().toString(),conv.getSelectedItem().toString(),inputVal);
        testItem(activity.strResult(res,true),outText.getText().toString(),"doConvert in Temperature is wrong",1);
    }

}
