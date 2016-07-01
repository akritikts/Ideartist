package silive.in.ideartist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro2;

import silive.in.ideartist.Fragments.SlideOne;
import silive.in.ideartist.Fragments.SlideThree;
import silive.in.ideartist.Fragments.SlideTwo;

public class SlideIntro extends AppIntro2 {
    Fragment slides;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_slide_intro);
        //View view = View.inflate(getApplicationContext(),R.layout.activity_slide_intro,null);
        //slides = (Fragment)view.findViewById(R.id.slides);
        addSlide(new SlideOne());
        addSlide(new SlideTwo());
        addSlide(new SlideThree());
        //showSkipButton(true);
        setProgressButtonEnabled(true);
        setVibrate(true);
        setVibrateIntensity(20);


    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        // Do something when users tap on Done button.
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

}
