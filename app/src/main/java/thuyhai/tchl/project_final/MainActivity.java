package thuyhai.tchl.project_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import thuyhai.tchl.project_final.Storage.SharedPrefManager;
import thuyhai.tchl.project_final.fragment.History;
import thuyhai.tchl.project_final.fragment.Home;
import thuyhai.tchl.project_final.fragment.Favorite;
import thuyhai.tchl.project_final.fragment.Login_Tab_Fragment;
import thuyhai.tchl.project_final.fragment.Profile;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawer;
    private static  final int FRAGMENT_HOME = 0;
    private static  final int FRAGMENT_HISTORY = 1;
    private static  final int FRAGMENT_FAVORITE = 2;
    private static  final int FRAGMENT_PROFILE = 3;
    private static final int FRAGMENT_LOGOUT = 4;

    private TextView tvUserName, tvEmail;
    private int mCurrentFragment =FRAGMENT_HOME;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = (NavigationView) findViewById(R.id.Navigation_view);
        View hView = navigationView.getHeaderView(0);
        tvUserName = (TextView)hView.findViewById(R.id.tvUserName);
       tvEmail =  (TextView)hView.findViewById(R.id.tvEmail);


        Intent intent1 = getIntent();

        Intent intent_back_home = getIntent();


        // fragment
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        mDrawer = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.nav_open, R.string.nav_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

       // NavigationView navigationView = findViewById(R.id.Navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new Home());
        navigationView.getMenu().findItem(R.id.navi_home).setChecked(true);



        sharedPrefManager = new SharedPrefManager(MainActivity.this);

        String username = sharedPrefManager.getUser().getName();
        tvUserName.setText(username);

        String email = sharedPrefManager.getUser().getEmail();
        tvEmail.setText(email);



    }

    @Override
    public void onBackPressed() {
        if(mDrawer.isDrawerOpen(GravityCompat.START)){
            mDrawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.navi_home){
            if(mCurrentFragment != FRAGMENT_HOME){
                replaceFragment(new Home());
                mCurrentFragment = FRAGMENT_HOME;
            }
        }else  if (id == R.id.navi_favorite){
            if(mCurrentFragment != FRAGMENT_FAVORITE){
                replaceFragment(new Favorite());
                mCurrentFragment = FRAGMENT_FAVORITE;
            }
        }
        else  if (id == R.id.navi_history){
            if(mCurrentFragment != FRAGMENT_HISTORY){
                replaceFragment(new History());
                mCurrentFragment = FRAGMENT_HISTORY;
            }
        }
        else  if (id == R.id.navi_profile){
            if(mCurrentFragment != FRAGMENT_PROFILE){
                replaceFragment(new Profile());
                mCurrentFragment = FRAGMENT_PROFILE;
            }
        }
        else  if (id == R.id.navi_logout){
                sharedPrefManager = new SharedPrefManager(getApplicationContext());
                sharedPrefManager.logout();
                Intent intent1 = new Intent(MainActivity.this, Login_Activity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
        }

        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.ContentFrame,fragment);
        transaction.commit();
    }


    //toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbar,menu);
        MenuItem menuItem = menu.findItem(R.id.action_serch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}