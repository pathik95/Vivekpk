package in.vaksys.vivekpk.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.vaksys.vivekpk.R;
import in.vaksys.vivekpk.adapter.ViewPagerAdapter;

/**
 * Created by Harsh on 03-05-2016.
 */
public class DemoFragment extends Fragment {

    //    @BindView(R.id.tabs1)
    TabLayout tabLayout;
    //    @BindView(R.id.viewpager1)
    ViewPager viewPager;


    /**
     * Create a new instance of the fragment
     */
    public static DemoFragment newInstance(int index) {
        DemoFragment fragment = new DemoFragment();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo_settings, container, false);
//        ButterKnife.bind(this, view);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs1);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager1);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        return view;
       /* if (getArguments().getInt("index", -1) == 0) {
            View view = inflater.inflate(R.layout.fragment_demo_settings, container, false);
            initDemoSettings(view);
            return view;
        } else {
            View view = inflater.inflate(R.layout.fragment_demo_list, container, false);
            initDemoList(view);
            return view;
        }*/
    }

    private void setupViewPager(ViewPager viewPager) {
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new CarFragment(), "Car");
        adapter.addFragment(new BikeFragment(), "Bike");
        viewPager.setAdapter(adapter);
    }

}