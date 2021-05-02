package ta.project.wisata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailWisata extends AppCompatActivity {

    private ImageView mGambar;
    private TextView mNamaWisata,mDeskripsi,mAlamat,mFasilitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        mGambar = findViewById(R.id.gambar);
        mNamaWisata = findViewById(R.id.namaWisata);
        mDeskripsi = findViewById(R.id.deskripsi);
        mAlamat = findViewById(R.id.alamat);
        mFasilitas = findViewById(R.id.fasilitas);

        mGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailWisata.this,MapsActivity.class));
            }
        });

        // Catching incoming intent11
        Intent intent = getIntent();
        String namaWisata = intent.getStringExtra("namaWisata");
        String gambar = intent.getStringExtra("gambar");
        String deskripsi = intent.getStringExtra("deskripsi");
        String alamat = intent.getStringExtra("alamat");
        String fasilitas = intent.getStringExtra("fasilitas");

        if (intent !=null){

            mNamaWisata.setText(namaWisata);
            mDeskripsi.setText(deskripsi);
            mAlamat.setText(alamat);
            mFasilitas.setText(fasilitas);
            Picasso.get().load(gambar).into(mGambar);
        }
    }
}