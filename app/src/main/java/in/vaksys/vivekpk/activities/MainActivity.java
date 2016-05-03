package in.vaksys.vivekpk.activities;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import in.vaksys.vivekpk.R;
import in.vaksys.vivekpk.fragments.SigninFragment;
import in.vaksys.vivekpk.fragments.SignupFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout linearLayout1, linearLayout2, linearLayout3;
    private CheckBox checkBox;
   /* private TabLayout tabLayout;
    private ViewPager viewPager;
    final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }*/
        setContentView(R.layout.remind_me);

        linearLayout1 = (LinearLayout) findViewById(R.id.linerFiveDay);
        linearLayout2 = (LinearLayout) findViewById(R.id.linerOneFiveDay);
        linearLayout3 = (LinearLayout) findViewById(R.id.linerTwoFiveDay);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);


       /* viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           
        }
    }

   /* private void setupViewPager(ViewPager viewPager) {

        adapter.addFragment(new SigninFragment(), "Sign In");
        adapter.addFragment(new SignupFragment(), "Sign Up");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }*/
}
