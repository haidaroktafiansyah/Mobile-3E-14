package org.aplas.basicappx;

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

public class TestA1BasicUIX021 extends ViewTest {
    private MainActivity activity;
    private String packName;
    ResourceTest rsc;

    @Before
    public void initTest() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        packName = activity.getPackageName();
        rsc = new ResourceTest(activity.getResources());
    }

    @Test
    public void check_01_String_Resources() {
        rsc.testStringResource("app_name","Unit Converter");
        rsc.testStringResource("tv1Text","Unit Converter");
        rsc.testStringResource("tv2Text","->");
        rsc.testStringResource("btnText","Convert");
        rsc.testStringResource("inputText","0");
        rsc.testStringResource("inputPrompt","Choose");
        rsc.testStringResource("hint","Enter any value");
        rsc.testStringResource("chkRound","Rounded");
        rsc.testStringResource("chkForm","Show Formula");
        rsc.testStringResource("rbDist","Distance");
        rsc.testStringResource("rbTemp","Temperature");
        rsc.testStringResource("rbWeight","Weight");
    }

    @Test
    public void check_02_Color_Resources() {
        rsc.testColorResource("colorPrimary", -16743049);
        rsc.testColorResource("colorPrimaryDark", -16754869);
        rsc.testColorResource("colorAccent", -2614432);
        rsc.testColorResource("viewBgColor", -16728065);
        rsc.testColorResource("textColor", -16777216);
        rsc.testColorResource("etBgColor", -3355444);
        rsc.testColorResource("btnColor", -23296);
        rsc.testColorResource("spBgColor", -1);
    }

    /* @Test
    public void check_02_StringArray_Resources() {
        String[] expected = "°C,°F,K".split("\\,");
        rsc.testStringArrayResource("tempList",expected);
    }*/

    @Test
    public void check_03_Font_Resources() {
        rsc.testFontResource("cambria","cambria");
        rsc.testFontResource("lucida","lucida");
    }
}

