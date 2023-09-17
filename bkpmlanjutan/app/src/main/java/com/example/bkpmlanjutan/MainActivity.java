package com.example.bkpmlanjutan;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import java.sql.Array;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new MahasiswaAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Fadillah wahyu", "E41220104", "0895342743004"));
        mahasiswaArrayList.add(new Mahasiswa("Tria yunita", "E41220345", "089534274533004"));
        mahasiswaArrayList.add(new Mahasiswa("Nira ayuhana", "E4134343", "0895342743404"));
        mahasiswaArrayList.add(new Mahasiswa("Septia rahma", "E41245454", "0895342744004"));
        mahasiswaArrayList.add(new Mahasiswa("Laila Dwi", "E412646464", "08953427430034"));
    }
}


