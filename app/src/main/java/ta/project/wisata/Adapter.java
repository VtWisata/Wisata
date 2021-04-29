package ta.project.wisata;

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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Wisata> wisatas;
    Context mContext;

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
        holder.namaWisata.setText(wisatas.get(position).getNamaWisata());
        Picasso.get().load(wisatas.get(position).getGambar()).into(holder.gambar);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,DetailWisata.class);

                intent.putExtra("namaWisata",wisatas.get(position).getNamaWisata());
                intent.putExtra("gambar",wisatas.get(position).getGambar());
                intent.putExtra("deskripsi",wisatas.get(position).getDeskripsi());
                intent.putExtra("alamat",wisatas.get(position).getAlamat());
                intent.putExtra("fasilitas",wisatas.get(position).getFasilitas());

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
        ImageView gambar;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaWisata = itemView.findViewById(R.id.namaWsiata);
            gambar = itemView.findViewById(R.id.coverWisata);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
