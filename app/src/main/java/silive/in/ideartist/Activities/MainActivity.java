package silive.in.ideartist.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cocosw.bottomsheet.BottomSheet;
import com.pnikosis.materialishprogress.ProgressWheel;

import silive.in.ideartist.Fragments.Bookmarked;
import silive.in.ideartist.Fragments.DrawerFragment;
import silive.in.ideartist.Fragments.TopStories;
import silive.in.ideartist.Fragments.Unread;
import silive.in.ideartist.R;

public class MainActivity extends AppCompatActivity implements DrawerFragment.FragmentDrawerListener {
    DrawerFragment drawerFragment;
    Toolbar mToolbar;
    ProgressWheel progressBar;

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setActionBarViewForAnimation(mToolbar)
                .build();*/


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

                //  If the activity has never started before...
                if (isFirstStart) {

                    //  Launch app intro
                    Intent i = new Intent(MainActivity.this, SlideIntro.class);
                    startActivity(i);
                    //finish();

                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();

                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("firstStart", false);

                    //  Apply changes
                    e.apply();
                }
            }
        });
        // Start the thread
        t.start();
        //finish();


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        progressBar = (ProgressWheel)findViewById(R.id.progress_wheel);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (DrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        drawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        displayView(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,Settings.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_search) {
            return true;
        }
        if (id == R.id.action_logout) {
            /*progressBar.spin();
            progressBar.setProgress(2);*/
            return true;
        }
        if (id == R.id.action_bookmrk) {
            Toast.makeText(this,"Page added to Bookmarks",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayView(int position) {
        Fragment fragment = new TopStories();
        String title = "Ideartist";
        switch (position) {
            case 0:
                new BottomSheet.Builder(this).title("Top Stories").sheet(R.menu.list).listener(new DialogInterface.OnClickListener() {
                    String title1 = "Ideartist";

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which) {
                            case R.id.help:
                                Toast.makeText(getApplicationContext(), "Help me!", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.science:
                                Toast.makeText(getApplicationContext(), "Science and Technology", Toast.LENGTH_SHORT).show();
                                title1 = "Top Stories : Science";
                                break;
                            case R.id.philosphy:
                                Toast.makeText(getApplicationContext(), "Philosophy", Toast.LENGTH_SHORT).show();
                                title1 = "Top Stories : Philosphy";
                                break;
                            case R.id.books:
                                Toast.makeText(getApplicationContext(), "Books", Toast.LENGTH_SHORT).show();
                                title1 = "Top Stories : Books";
                                break;

                        }
                        //getSupportActionBar().setTitle(title1);

                    }

                }).show();
                fragment = new TopStories();
                title = "Top Stories";
                break;
            case 1:
                fragment = new Bookmarked();
                title = "Bookmarked";
                getSupportActionBar().setTitle(title);
                break;
            case 2:
                new BottomSheet.Builder(this).title("Unread").sheet(R.menu.list).listener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title1;
                        switch (which) {
                            case R.id.help:
                                Toast.makeText(getApplicationContext(), "Help me!", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.science:
                                Toast.makeText(getApplicationContext(), "Science and Technology", Toast.LENGTH_SHORT).show();
                                title1 = "Unread : Science";
                                break;
                            case R.id.philosphy:
                                Toast.makeText(getApplicationContext(), "Philosophy", Toast.LENGTH_SHORT).show();
                                title1 = "Unread : Philosphy";
                                break;
                            case R.id.books:
                                Toast.makeText(getApplicationContext(), "Books", Toast.LENGTH_SHORT).show();
                                title1 = "Unread : Books";
                                break;

                        }
                        //getSupportActionBar().setTitle(title1);


                    }


                }).show();
                fragment = new Unread();
                title = "Unread";
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            /*FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();*/
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).replace(R.id.container_body, fragment).commit();
            getSupportActionBar().setTitle(title);
            // set the toolbar title

        }
    }
}
