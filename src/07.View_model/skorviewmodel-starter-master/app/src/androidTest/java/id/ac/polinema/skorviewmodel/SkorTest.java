package id.ac.polinema.skorviewmodel;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class SkorTest {

	@Rule
	public ActivityScenarioRule<MainActivity> activityScenarioRule
		= new ActivityScenarioRule<>(MainActivity.class);

	@Before
	public void before() {
		activityScenarioRule.getScenario()
			.onActivity(new ActivityScenario.ActivityAction<MainActivity>() {
				@Override
				public void perform(MainActivity activity) {
					activity.getSupportFragmentManager()
						.beginTransaction();
				}
			});
	}

	@Test
	public void addScoreHomeTest() {
		onView(withId(R.id.button_add_home))
			.perform(click());
		onView(withId(R.id.input_name))
			.perform(typeText("Andi"));
		onView(withId(R.id.input_minute))
			.perform(typeText("40"))
			.perform(closeSoftKeyboard());
		onView(withId(R.id.button_save))
			.perform(click());
		onView(withId(R.id.text_home_score))
			.check(matches(withText("1")));
	}

	@Test
	public void addScoreAwayTest() {
		onView(withId(R.id.button_add_away))
			.perform(click());
		onView(withId(R.id.input_name))
			.perform(typeText("Budi"));
		onView(withId(R.id.input_minute))
			.perform(typeText("45"))
			.perform(closeSoftKeyboard());
		onView(withId(R.id.button_save))
			.perform(click());
		onView(withId(R.id.text_away_score))
			.check(matches(withText("1")));
	}

	@Test
	public void addScoreHomeScorerTest() {
		onView(withId(R.id.button_add_home))
			.perform(click());
		onView(withId(R.id.input_name))
			.perform(typeText("Candra"));
		onView(withId(R.id.input_minute))
			.perform(typeText("50"))
			.perform(closeSoftKeyboard());
		onView(withId(R.id.button_save))
			.perform(click());
		onView(withId(R.id.button_add_home))
			.perform(click());
		onView(withId(R.id.input_name))
			.perform(typeText("Beni"));
		onView(withId(R.id.input_minute))
			.perform(typeText("60"))
			.perform(closeSoftKeyboard());
		onView(withId(R.id.button_save))
			.perform(click());
		onView(withId(R.id.text_home_scorer))
			.check(matches(withText("Candra 50\" Beni 60\" ")));
	}

	@Test
	public void addScoreAwayScorerTest() {
		onView(withId(R.id.button_add_away))
			.perform(click());
		onView(withId(R.id.input_name))
			.perform(typeText("Deni"));
		onView(withId(R.id.input_minute))
			.perform(typeText("60"))
			.perform(closeSoftKeyboard());
		onView(withId(R.id.button_save))
			.perform(click());
		onView(withId(R.id.button_add_away))
			.perform(click());
		onView(withId(R.id.input_name))
			.perform(typeText("Joni"));
		onView(withId(R.id.input_minute))
			.perform(typeText("70"))
			.perform(closeSoftKeyboard());
		onView(withId(R.id.button_save))
			.perform(click());
		onView(withId(R.id.text_away_scorer))
			.check(matches(withText("Deni 60\" Joni 70\" ")));
	}
}
