package id.fame.smartcity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import id.fame.smartcity.Fragment.BerandaFragment;
import id.fame.smartcity.Fragment.CuacaFragment;
import id.fame.smartcity.Fragment.InboxFragment;
import id.fame.smartcity.Fragment.ProfilFragment;
import id.fame.smartcity.Fragment.RiwayatFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new BerandaFragment());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_beranda:
                fragment = new BerandaFragment();
                break;

            case R.id.navigation_cuaca:
                fragment = new CuacaFragment();
                break;

            case R.id.navigation_riwayat:
                fragment = new RiwayatFragment();
                break;

            case R.id.navigation_inbox:
                fragment = new InboxFragment();
                break;

            case R.id.navigation_profil:
                fragment = new ProfilFragment();
                break;
        }

        return loadFragment(fragment);
    }
}