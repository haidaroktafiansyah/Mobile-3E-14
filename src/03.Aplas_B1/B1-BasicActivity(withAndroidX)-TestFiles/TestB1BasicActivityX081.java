package org.aplas.basicappx;

import android.widget.Button;
import android.widget.CheckBox;
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

public class TestB1BasicActivityX081 extends ViewTest {
    private MainActivity activity;
    private int inputVal;

    @Before
    public void initTest() {
        startActivity();
    }

    private void startActivity() throws NullPointerException, ClassCastException {
        /****** initiation of Test ******/
        //Robolectric Pack
        activity = Robolectric.buildActivity(MainActivity.class).create().get();

        inputVal =getRandomInteger(0,1000);
    }

    @Test
    public void check_01_Events() {

        //Test temperature
        ((EditText)activity.findViewById(R.id.inputText)).setText(String.valueOf(inputVal));
        ((Spinner)activity.findViewById(R.id.convList)).setSelection(2);
        //Convert
        double res = activity.convertUnit("Temperature","°C","K",inputVal);
        testItem(activity.strResult(res,true),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event convList spinner change is wrong in temperature convert", 1);

        ((Spinner)activity.findViewById(R.id.oriList)).setSelection(1);
        //Convert
        res = activity.convertUnit("Temperature","°F","K",inputVal);
        testItem(activity.strResult(res,true),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event oriList spinner change is wrong in temperature convert", 1);

        ((EditText)activity.findViewById(R.id.inputText)).setText(String.valueOf(inputVal+123));
        ((Button)activity.findViewById(R.id.convertButton)).performClick();
        //Convert
        res = activity.convertUnit("Temperature","°F","K",inputVal+123);
        testItem(activity.strResult(res,true),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event button click is wrong in temperature convert", 1);

        ((EditText)activity.findViewById(R.id.inputText)).setText(String.valueOf(inputVal));
        ((CheckBox)activity.findViewById(R.id.chkRounded)).setChecked(false);
        //Convert
        res = activity.convertUnit("Temperature","°F","K",inputVal);
        testItem(activity.strResult(res,false),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event rounded checkbox change is wrong in temperature convert", 1);

        //Test distance
        ((RadioButton)((RadioGroup)activity.findViewById(R.id.radioGroup)).getChildAt(1)).setChecked(true);
        ((EditText)activity.findViewById(R.id.inputText)).setText(String.valueOf(inputVal));

        ((Spinner)activity.findViewById(R.id.convList)).setSelection(1);
        //Convert
        res = activity.convertUnit("Distance","Mtr","Inc",inputVal);
        testItem(activity.strResult(res,false),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event convList spinner change is wrong in distance convert", 1);

        ((Spinner)activity.findViewById(R.id.oriList)).setSelection(3);
        //Convert
        res = activity.convertUnit("Distance","Ft","Inc",inputVal);
        testItem(activity.strResult(res,false),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event oriList spinner change is wrong in distance convert", 1);

        ((EditText)activity.findViewById(R.id.inputText)).setText(String.valueOf(inputVal+123));
        ((Button)activity.findViewById(R.id.convertButton)).performClick();
        //Convert
        res = activity.convertUnit("Distance","Ft","Inc",inputVal+123);
        testItem(activity.strResult(res,false),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event button click is wrong in distance convert", 1);

        ((EditText)activity.findViewById(R.id.inputText)).setText(String.valueOf(inputVal));
        ((CheckBox)activity.findViewById(R.id.chkRounded)).setChecked(true);
        //Convert celcius to kelvin with convList
        res = activity.convertUnit("Distance","Ft","Inc",inputVal);
        testItem(activity.strResult(res,true),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event rounded checkbox change is wrong in distance convert", 1);

        //Test weight
        ((RadioButton)((RadioGroup)activity.findViewById(R.id.radioGroup)).getChildAt(2)).setChecked(true);
        ((EditText)activity.findViewById(R.id.inputText)).setText(String.valueOf(inputVal));

        ((Spinner)activity.findViewById(R.id.convList)).setSelection(2);
        //Convert
        res = activity.convertUnit("Weight","Grm","Pnd",inputVal);
        testItem(activity.strResult(res,true),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event convList spinner change is wrong in weight convert", 1);

        ((Spinner)activity.findViewById(R.id.oriList)).setSelection(1);
        //Convert
        res = activity.convertUnit("Weight","Onc","Pnd",inputVal);
        testItem(activity.strResult(res,true),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event oriList spinner change is wrong in weight convert", 1);

        ((EditText)activity.findViewById(R.id.inputText)).setText(String.valueOf(inputVal+123));
        ((Button)activity.findViewById(R.id.convertButton)).performClick();
        //Convert
        res = activity.convertUnit("Weight","Onc","Pnd",inputVal+123);
        testItem(activity.strResult(res,true),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event button click is wrong in weight convert", 1);

        ((EditText)activity.findViewById(R.id.inputText)).setText(String.valueOf(inputVal));
        ((CheckBox)activity.findViewById(R.id.chkRounded)).setChecked(false);
        //Convert
        res = activity.convertUnit("Weight","Onc","Pnd",inputVal);
        testItem(activity.strResult(res,false),((EditText)activity.findViewById(R.id.outputText)).getText().toString(),"Event rounded checkbox change is wrong in weight convert", 1);
    }

}
