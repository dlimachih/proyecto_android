package com.example.david.probaresto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private CustomeAdapter customeAdapter;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.hilton, R.drawable.tetuan,
            R.drawable.tarwi,R.drawable.perugourmet
            ,R.drawable.laconda,R.drawable.harly,
            R.drawable.benz,R.drawable.silver};
    private String[] myImageNameList = new String[]{"Restaurante Hilton", "Restaurante Peru Gourmet",
            "Restaurante Tarwi","Restaurante Harly"
            ,"Restraurante Laconda","Harly",
            "Lamborghini","Silver"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listar);

        imageModelArrayList = populateList();
        Log.d("hjhjh",imageModelArrayList.size()+"");
        customeAdapter = new CustomeAdapter(this,imageModelArrayList);
        lv.setAdapter(customeAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent visordetalles=new Intent(view.getContext(),Restaurante_Hilton.class);
                        startActivity(visordetalles);
                        break;
                    case 1:
                        Intent visordetalles1=new Intent(view.getContext(),Restaurante_Perugourmet.class);
                        startActivity(visordetalles1);
                        break;

                    default:
                        Toast.makeText(getApplicationContext(),"No se pueden ver datos",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private ArrayList<ImageModel> populateList(){

        ArrayList<ImageModel> list = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            ImageModel imageModel = new ImageModel();
            imageModel.setName(myImageNameList[i]);
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;

    }
}
