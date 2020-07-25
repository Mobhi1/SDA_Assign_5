package com.example.OnlineReport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//import android.R;
import com.google.android.material.tabs.TabLayout;


public class ReportActivity extends AppCompatActivity {
    private static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "starting Reports", Toast.LENGTH_LONG).show();
        /**
         * This is the entry point to reports
          */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        //set the toolbar we have overridden
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.pager);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void Store(View view) {
        Toast.makeText(this, "button clicked", Toast.LENGTH_LONG).show();
    }

    public void getData(View view) {
    }
}

