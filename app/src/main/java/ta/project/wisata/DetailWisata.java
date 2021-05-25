package ta.project.wisata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DetailWisata extends AppCompatActivity implements OnMapReadyCallback {

    private ImageView mGambar, mWifi, mWarung;
    private TextView mNamaWisata,mDeskripsi,mAlamat,mFasilitas;
    GoogleMap googleMaps;
    String namaWisata, gambar, deskripsi, alamat, fasilitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        mGambar = findViewById(R.id.gambar);
        mNamaWisata = findViewById(R.id.namaWisata);
        mDeskripsi = findViewById(R.id.deskripsi);
        mAlamat = findViewById(R.id.alamat);
        mWifi = findViewById(R.id.wifi);
        mWarung = findViewById(R.id.resto);

 //       mFasilitas = findViewById(R.id.fasilitas);

        mGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailWisata.this,PanoActivity.class);
                intent.putExtra("gambar", gambar);
                startActivity(intent);
            }
        });

        //show maps
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // Catching incoming intent11
        Intent intent = getIntent();
        namaWisata = intent.getStringExtra("namaWisata");
        gambar = intent.getStringExtra("gambar");
        deskripsi = intent.getStringExtra("deskripsi");
        alamat = intent.getStringExtra("alamat");
        fasilitas = intent.getStringExtra("fasilitas");

        Log.e("CEK", fasilitas);

        if(fasilitas.toLowerCase().contains("toilet")){
            mWifi.setVisibility(View.VISIBLE);
        }if(fasilitas.toLowerCase().contains("warung")){
            mWarung.setVisibility(View.VISIBLE);
        }

        if (intent != null){

            mNamaWisata.setText(namaWisata);
            mDeskripsi.setText(deskripsi);
            mAlamat.setText(alamat);
//            mFasilitas.setText(fasilitas);
            Picasso.get().load(gambar).resize(400,250).into(mGambar);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //get LatLong
        Intent intent = getIntent();
        String koordinat = intent.getStringExtra("koordinat");
        String[] latlong =  koordinat.split(",");
        double latitude = Double.parseDouble(latlong[0]);
        double longitude = Double.parseDouble(latlong[1]);

        googleMaps = googleMap;
        LatLng latLng = new LatLng(latitude, longitude);
        googleMaps.addMarker(new MarkerOptions().position(latLng).title("Wisatanya"));
        googleMaps.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMaps.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        googleMaps.getUiSettings().setAllGesturesEnabled(true);
        googleMaps.getUiSettings().setZoomGesturesEnabled(true);
        googleMaps.setTrafficEnabled(true);

    }
}