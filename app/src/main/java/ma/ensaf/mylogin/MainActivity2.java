package ma.ensaf.mylogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        Menu menu = navigationView.getMenu();
        MenuItem logoutItem = menu.findItem(R.id.logout);

        logoutItem.setVisible(true);

        drawerToggle =new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                } else if (itemId == R.id.calculator) {
                    Toast.makeText(getApplicationContext(), "Calculator", Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(MainActivity2.this, CalculatorActivity.class);
                     startActivity(intent);

                    return true;
                }  else if (itemId == R.id.map) {
                    Toast.makeText(getApplicationContext(), "Google Maps", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity2.this, MapActivity.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.info) {
                    Toast.makeText(getApplicationContext(), "About Us", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.logout) {
                    Toast.makeText(getApplicationContext(), "Logged Out", Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance().signOut();
                    Intent i = new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(i);
                    finish();
                    return true;
                } else if (itemId == R.id.share) {
                    Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.rateUs) {
                    Toast.makeText(getApplicationContext(), "Rate Us", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.temperature){
                    Toast.makeText(getApplicationContext(), "Temperature Converter", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity2.this, TemperatureActivity.class);
                        startActivity(intent);
                } else if (itemId == R.id.currency){
                    Toast.makeText(getApplicationContext(), "Currency Exchange", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}