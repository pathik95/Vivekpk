package in.vaksys.vivekpk.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.vaksys.vivekpk.R;
import in.vaksys.vivekpk.adapter.ViewPagerAdapter;
import in.vaksys.vivekpk.extras.MyApplication;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReminderTabFragment extends Fragment {
    private int[] tabIcons = {
            R.drawable.insurance_select,
            R.drawable.emission_nav,
            R.drawable.services_nav
    };
    //    @BindView(R.id.tabs1)
    TabLayout tabLayout;
    //    @BindView(R.id.viewpager1)
    ViewPager viewPager;


    public static ReminderTabFragment newInstance(int index) {
        ReminderTabFragment fragment = new ReminderTabFragment();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reminder_tab, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs2);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager2);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new InsuranceFragment(), "Insurance");
        adapter.addFragment(new EmissionFragment(), "Emission");
        adapter.addFragment(new ServiceFragment(), "Services");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(MyApplication.getInstance()).inflate(R.layout.custom_tab, null);
        tabOne.setText("Insurance");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.insurance, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(MyApplication.getInstance()).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Emission");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.emission, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(MyApplication.getInstance()).inflate(R.layout.custom_tab, null);
        tabThree.setText("Services");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.service, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }



}
