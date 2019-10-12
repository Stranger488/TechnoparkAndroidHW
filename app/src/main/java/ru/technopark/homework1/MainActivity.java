package ru.technopark.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements MainFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MainFragment()).commit();
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof MainFragment) {
            MainFragment headlinesFragment = (MainFragment) fragment;
            headlinesFragment.setOnItemSelectedListener(this);
        }
    }

    public void onItemSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article

        MainFragment mainFrag = (MainFragment)
                getSupportFragmentManager().findFragmentById(R.id.main_fragment);


        ExtraFragment newFragment = new ExtraFragment();
        Bundle args = new Bundle();
        args.putInt(CommonConstants.ARG_POSITION, position);
        newFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}



