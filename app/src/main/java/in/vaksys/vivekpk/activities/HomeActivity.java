package in.vaksys.vivekpk.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.util.ArrayList;

import in.vaksys.vivekpk.R;
import in.vaksys.vivekpk.extras.AdapterCallback;
import in.vaksys.vivekpk.extras.MyApplication;
import in.vaksys.vivekpk.extras.SpinnerCallback;
import in.vaksys.vivekpk.fragments.BikeFragment;
import in.vaksys.vivekpk.fragments.CarFragment;
import in.vaksys.vivekpk.fragments.EmergencyFragment;
import in.vaksys.vivekpk.fragments.MainTabFragment;
import in.vaksys.vivekpk.fragments.ReminderTabFragment;
import in.vaksys.vivekpk.fragments.DocumentFragment;


public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "in activity";
    private MainTabFragment currentFragment;
    private DocumentFragment documentFragment;
    private ReminderTabFragment reminderTabFragment;
    private EmergencyFragment emergencyFragment;
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private FragmentManager fragmentManager;
    private AHBottomNavigation bottomNavigation;
    private Toolbar toolbar;
    ImageView img, notification;
    private Spinner spinner_select_value;
    private CarFragment carFragment;
    private BikeFragment bikeFragment;
    private SpinnerCallback spinnerCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragmentManager = getSupportFragmentManager();
        if (MyApplication.getInstance().getCurrentFragment()== null)
        {
            currentFragment = MainTabFragment.newInstance(0);
            MyApplication.getInstance().setCurrentFragment(currentFragment);
        }
        else {
            currentFragment=MyApplication.getInstance().getCurrentFragment();
        }

      /*  try {
            this.spinnerCallback = ((SpinnerCallback) HomeActivity.this);
        } catch (ClassCastException e) {
            throw new ClassCastException(e.getMessage());
        }*/

        ArrayList<String> list = new ArrayList<String>();
        list.add("Car");
        list.add("Bike");

        spinner_select_value = (Spinner) findViewById(R.id.spinner_select_value);


        final ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_select_value.setAdapter(spinAdapter);
//        spinner_select_value.setSelection(0);
        spinner_select_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String item = adapter.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(getApplicationContext(), "Selected  : " + item,
                        Toast.LENGTH_LONG).show();
                SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences("harsh", Context.MODE_PRIVATE);

                SharedPreferences.Editor edit = sharedPreferences.edit();

                if (position == 0) {
                  /*  edit.putInt("type", 0);
                    edit.apply();
                    spinnerCallback.onSpinnerCallBack();*/
//                    MyApplication.getInstance().setValue(0);
                    //Fragment fm =fragmentManager.findFragmentByTag("harsh");

                    currentFragment.onRefresh();
                    Log.e(TAG, "onItemSelected: called");
                }
                if (position == 1) {
/*
                    edit.putInt("type", 1);
                    edit.apply();
                    spinnerCallback.onSpinnerCallBack();
*/
//                    MyApplication.getInstance().setValue(1);
                    currentFragment.onRefresh1();
                //    MainTabFragment.newInstance(0).onRefresh1();
                    Log.e(TAG, "onItemSelected: called");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


       /* notification = (ImageView) findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, NotificationActivity.class));
            }
        });

        img = (ImageView) findViewById(R.id.img_search);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SearchActivity.class));
            }
        });*/

        initUI();
    }

    private void initUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
//        floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_action_button);
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#F6B332"));
        AHBottomNavigationItem item = new AHBottomNavigationItem(R.string.home, R.drawable.ic_action_home, R.color.color_tab_1);
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.reminder, R.drawable.reminder_can_we_help, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.documents, R.drawable.settings_documents, R.color.color_tab_1);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.emergency_contact, R.drawable.emergency_contac_activet_tab, R.color.color_tab_1);

        bottomNavigationItems.add(item);
        bottomNavigationItems.add(item1);
        bottomNavigationItems.add(item2);
        bottomNavigationItems.add(item3);
        bottomNavigation.setForceTitlesDisplay(true);
//        bottomNavigation.setColored(true);

        bottomNavigation.addItems(bottomNavigationItems);
        bottomNavigation.setAccentColor(Color.parseColor("#FF000000"));
        bottomNavigation.setInactiveColor(Color.parseColor("#FFFFFF"));
        bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

//        bottomNavigation.setCurrentItem(3);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, boolean wasSelected) {
                Toast.makeText(HomeActivity.this, " " + position + " " + wasSelected, Toast.LENGTH_SHORT).show();
                if (position == 0) {

                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, currentFragment,"harsh")
                            .commit();
                }
                if (position == 1) {
//                    bottomNavigation.setNotification(0, 1);
                    reminderTabFragment = ReminderTabFragment.newInstance(0);
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, reminderTabFragment)
                            .commit();
                }
                if (position == 2) {
                    documentFragment = documentFragment.newInstance(0);
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, documentFragment)
                            .commit();
                }
                if (position == 3) {
                    emergencyFragment = EmergencyFragment.newInstance(0);
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, emergencyFragment)
                            .commit();
                }

               /* if (!wasSelected) {
                    currentFragment = MainTabFragment.newInstance(position);
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, currentFragment)
                            .commit();
                } else if (position > 0) {
//                    currentFragment.refresh();
                }*/
            }
        });



       /* final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                bottomNavigation.setNotification(16, 1);
                Snackbar.make(bottomNavigation, "Snackbar with bottom navigation",
                        Snackbar.LENGTH_SHORT).show();
            }
        }, 3000);*/

    }

    /**
     * Update the bottom navigation colored param
     */
    public void updateBottomNavigationColor(boolean isColored) {
        bottomNavigation.setColored(isColored);
    }

    /**
     * Return if the bottom navigation is colored
     */
    public boolean isBottomNavigationColored() {
        return bottomNavigation.isColored();
    }

    public int getBottomNavigationNbItems() {
        return bottomNavigation.getItemsCount();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navToolbar:
                // Single menu item is selected do something
                // Ex: launching new activity/screen or show alert message
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setGravity(Gravity.TOP | Gravity.END);
                dialog.setContentView(R.layout.menu_list);

                LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.linear_help_toolbar);
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        startActivity(new Intent(HomeActivity.this, WebViewActivity.class));
                    }
                });


                dialog.show();
                return true;

            case R.id.searchToolbar:
                startActivity(new Intent(HomeActivity.this, SearchActivity.class));
                return true;

            case R.id.notificationToolbar:
                startActivity(new Intent(HomeActivity.this, NotificationActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
