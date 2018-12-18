package com.denisque.mmpr.ui.main_activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.denisque.mmpr.R;
import com.denisque.mmpr.ui.OnFragmentInteractionListener;
import com.denisque.mmpr.ui.labas.MenuFragment;

public class MainActivity extends MvpAppCompatActivity implements OnFragmentInteractionListener {
    private boolean isMenu;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMenuFragment();
    }

    private void showMenuFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_container, MenuFragment.newInstance(), MenuFragment.TAG)
                .commit();
        isMenu = true;
    }

    @Override
    public void onFragmentChose(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_container, fragment, tag)
                .commit();
        isMenu = false;
    }

    @Override
    public void onBackPressed() {
        if (isMenu) {
            super.onBackPressed();
            Log.d(TAG, "onBackPressed: is menu");
        } else {
            Log.d(TAG, "onBackPressed: is not menu");
            showMenuFragment();
        }
        isMenu = false;
    }
}
