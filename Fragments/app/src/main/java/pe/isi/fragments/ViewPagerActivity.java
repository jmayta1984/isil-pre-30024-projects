package pe.isi.fragments;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager2 vpTabs;
    private TabLayout tlTabs;

    private ViewPagerAdapter adapter;

    private void initViews() {
        vpTabs = findViewById(R.id.vpTabs);
        tlTabs = findViewById(R.id.tlTabs);
    }

    private void setupAdapter() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        adapter.add(new BlueFragment());
        adapter.add(new GreenFragment());
        adapter.add(new RedFragment());

    }

    private void setupViewPager() {
        vpTabs.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        vpTabs.setAdapter(adapter);
    }

    private void setupTabLayout() {
        tlTabs.addTab(tlTabs.newTab().setText("Blue"));
        tlTabs.addTab(tlTabs.newTab().setText("Green"));
        tlTabs.addTab(tlTabs.newTab().setText("Red"));
    }

    private void initViewListeners() {
        tlTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpTabs.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        vpTabs.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tlTabs.selectTab(tlTabs.getTabAt(position));
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (vpTabs.getCurrentItem() == 0) {
                    finish();
                } else {
                    vpTabs.setCurrentItem(0);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initViews();
        setupAdapter();
        setupViewPager();
        setupTabLayout();
        initViewListeners();
    }


}