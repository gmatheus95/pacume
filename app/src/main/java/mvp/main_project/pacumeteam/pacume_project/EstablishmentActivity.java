package mvp.main_project.pacumeteam.pacume_project;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class EstablishmentActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ImageView imgEstablishment;
    private int [] imageArray;
    private int currentIndex;
    private int startIndex;
    private int endIndex;
    private TextView txtLeft;
    private TextView txtRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment);
        requestFineLocation();
        requestLocationPermission();
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        imgEstablishment = (ImageView)findViewById(R.id.imgEstablishment);
        imageArray = new int[8];
        imageArray[0] = R.mipmap.bkfront1;
        imageArray[1] = R.mipmap.bkfront2;
        imageArray[2] = R.mipmap.sandwich1;
        imageArray[3] = R.mipmap.sandwich2;

        startIndex = 0;
        endIndex = 3;

        txtLeft=findViewById(R.id.txtPrevious);
        txtLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousImage();
            }
        });

        txtRight = findViewById(R.id.txtNext);
        txtRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextImage();
            }
        });

        nextImage();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-22.0057905,-47.9042845))
                .title("Marker"));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-22.0057905,-47.9042845),15));
    }

    //region Permissions
    private void requestLocationPermission()
    {
        if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                // Explain to the user why we need to read the contacts
            }

            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    819);

            // MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
            // app-defined int constant that should be quite unique

            return;
        }
    }

    private void requestFineLocation()
    {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Explain to the user why we need to read the contacts
            }

            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    819);

            // MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
            // app-defined int constant that should be quite unique

            return;
        }
    }

    //endregion
    
    //region imageView change
    public void nextImage(){
        currentIndex++;
        if(currentIndex > endIndex){
            currentIndex = startIndex;
        }
        imgEstablishment.setImageResource(imageArray[currentIndex]);

    }
    public void previousImage(){
        currentIndex--;
        if(currentIndex<startIndex){
            currentIndex = endIndex;
        }
        imgEstablishment.setImageResource(imageArray[currentIndex]);

    }
    //endregion
}
