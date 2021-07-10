package ta.project.wisata.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ta.project.wisata.DetailWisata;
import ta.project.wisata.R;
import ta.project.wisata.db.Wisata;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Wisata> wisatas;
    Context mContext;
    private static final String IMG_URL = "http://192.168.43.227/wisataex/android/gambar/";

    public Adapter(Context ctx, List<Wisata> wisatas){
        this.inflater = LayoutInflater.from(ctx);
        this.wisatas = wisatas;
        this.mContext = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.costum_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String[] pano = wisatas.get(position).getGambar().split(",");
        String gambarp = pano[0];
        holder.namaWisata.setText(wisatas.get(position).getNamaWisata());
        holder.kategori.setText(wisatas.get(position).getKategori());
        Picasso.get().load(IMG_URL+gambarp)
                .resize(400,250).into(holder.gambar);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailWisata.class);

                intent.putExtra("namaWisata",wisatas.get(position).getNamaWisata());
                intent.putExtra("gambar",wisatas.get(position).getGambar());
                intent.putExtra("deskripsi",wisatas.get(position).getDeskripsi());
                intent.putExtra("alamat",wisatas.get(position).getAlamat());
                intent.putExtra("fasilitas",wisatas.get(position).getFasilitas());
                intent.putExtra("kategori",wisatas.get(position).getKategori());
                intent.putExtra("koordinat",wisatas.get(position).getKoordinat());
                intent.putExtra("jamBuka",wisatas.get(position).getJamBuka());
                intent.putExtra("jamTutup",wisatas.get(position).getJamTutup());

                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return wisatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView namaWisata;
        TextView kategori;
        ImageView gambar;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            kategori = itemView.findViewById(R.id.kategori);
            namaWisata = itemView.findViewById(R.id.namaWisata);
            gambar = itemView.findViewById(R.id.coverWisata);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
