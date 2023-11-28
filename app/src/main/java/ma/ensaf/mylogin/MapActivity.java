package ma.ensaf.mylogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap myMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapActivity.this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap = googleMap;

        LatLng ensaFes = new LatLng(33.9965, -4.9919);
        myMap.addMarker(new MarkerOptions().position(ensaFes).title("ENSA Fès"));
        LatLng ensaAgadir = new LatLng(30.4059, -9.5298);
        myMap.addMarker(new MarkerOptions().position(ensaAgadir).title("ENSA Agadir"));
        LatLng ensaHoc = new LatLng(35.1727, -3.8620);
        myMap.addMarker(new MarkerOptions().position(ensaHoc).title("ENSA Al Hoceima"));
        LatLng ensaJdida = new LatLng(33.2510, -8.4341);
        myMap.addMarker(new MarkerOptions().position(ensaJdida).title("ENSA El Jadida"));
        LatLng ensaKenitre = new LatLng(34.2486, -6.5832);
        myMap.addMarker(new MarkerOptions().position(ensaKenitre).title("ENSA Kenitra"));
        LatLng ensaKhouribga = new LatLng(32.8972, -6.9138);
        myMap.addMarker(new MarkerOptions().position(ensaKhouribga).title("ENSA Khouribga"));
        LatLng ensaMarrakech = new LatLng(31.6469, -8.0204);
        myMap.addMarker(new MarkerOptions().position(ensaMarrakech).title("ENSA Marrakech"));
        LatLng ensaOujda = new LatLng(34.6504, -1.8963);
        myMap.addMarker(new MarkerOptions().position(ensaOujda).title("ENSA Oujda"));
        LatLng ensaSafi = new LatLng(32.3268, -9.2637);
        myMap.addMarker(new MarkerOptions().position(ensaSafi).title("ENSA Safi"));
        LatLng ensaTanger = new LatLng(35.7373, -5.8944);
        myMap.addMarker(new MarkerOptions().position(ensaTanger).title("ENSA Tanger"));
        LatLng ensaTetouan = new LatLng(35.5622, -5.3645);
        myMap.addMarker(new MarkerOptions().position(ensaTetouan).title("ENSA Tétouan"));




        myMap.moveCamera(CameraUpdateFactory.newLatLng(ensaFes));


    }
}