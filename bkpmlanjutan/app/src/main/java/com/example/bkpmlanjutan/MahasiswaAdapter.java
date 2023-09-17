package com.example.bkpmlanjutan;
import android.view.*;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class MahasiswaAdapter  extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
private ArrayList<Mahasiswa> datalist;
public MahasiswaAdapter(ArrayList<Mahasiswa> datalist){
    this.datalist = datalist;
}
@Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View view = layoutInflater.inflate(R.layout.row_mahasiswa,parent,false);
    return new MahasiswaViewHolder(view);
}
@Override
    public void onBindViewHolder(MahasiswaViewHolder holder,int position){
    holder.txtNama.setText(datalist.get(position).getNama());
    holder.txtNpm.setText(datalist.get(position).getNpm());
    holder.txtNoHp.setText(datalist.get(position).getNohp());
}
@Override
    public int getItemCount(){
    return (datalist != null)? datalist.size() : 0;
}
public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
    private TextView txtNama,txtNpm,txtNoHp;
    public MahasiswaViewHolder(View itemView){
        super(itemView);
        txtNama = itemView.findViewById(R.id.txt_nama_mahasiswa);
        txtNpm = itemView.findViewById(R.id.txt_npm_mahasiswa);
        txtNoHp = itemView.findViewById(R.id.txt_nohp_mahasiswa);
     }
  }
}
