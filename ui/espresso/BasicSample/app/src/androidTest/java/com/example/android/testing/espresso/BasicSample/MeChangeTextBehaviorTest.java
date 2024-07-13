package com.example.android.testing.espresso.BasicSample;

// Import necessary Espresso classes and methods for testing
import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

// Import necessary Espresso assertions and rules
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

// Specify that this test class should run with AndroidJUnit4 test runner
@RunWith(AndroidJUnit4.class)
public class MeChangeTextBehaviorTest {

    // Define a constant string to be typed into EditText
    public static final String STRING_TO_BE_TYPED = "Espresso";

    // ActivityScenarioRule provides functional testing of a single activity
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    // Test method to verify text change in the same activity
    @Test
    public void changeText_sameActivity() {
        // Perform action: type text into EditText
        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED));

        // Close the soft keyboard
        closeSoftKeyboard();

        // Perform action: click the button to change text
        onView(withId(R.id.changeTextBt)).perform(click());

        // Check assertion: verify if TextView displays the typed text
        onView(withId(R.id.textToBeChanged)).check(ViewAssertions.matches(withText(STRING_TO_BE_TYPED)));
    }

    @Test
    public void changeText_newActivity() {
        // Perform action: type text into EditText
        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED));

        // Close the soft keyboard
        closeSoftKeyboard();

        // Perform action: click the button to change activity and display text
        onView(withId(R.id.activityChangeTextBtn)).perform(click());

        // Check assertion: verify if TextView in the new activity displays the typed text
        onView(withId(R.id.show_text_view)).check(ViewAssertions.matches(withText(STRING_TO_BE_TYPED)));
    }
}
