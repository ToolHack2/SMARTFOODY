package com.example.user.smartfoody.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.smartfoody.Adapter.ProducesAdapter;
import com.example.user.smartfoody.Model.Produces;
import com.example.user.smartfoody.R;
import com.example.user.smartfoody.View.AnimationTab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11/27/2017.
 */

public class Shop extends Fragment {

    private  RecyclerView produceview;
    private  RecyclerView list3;
    private  ProducesAdapter adapter, adapter2;
    private  List<Produces> list, list2;
    private TextView bag_count;
    int count ;
    TabHost tabHost;

    Integer[] Image = {R.drawable.xao,R.drawable.monrau,R.drawable.xao,R.drawable.monrau,
            R.drawable.xao,R.drawable.monrau,R.drawable.xao,R.drawable.monrau,
            R.drawable.xao,R.drawable.monrau,R.drawable.xao,R.drawable.monrau,
            R.drawable.fsalas};
    Integer[] Image2 = {R.drawable.fsalas,R.drawable.fsalas,R.drawable.fsalas,R.drawable.fsalas,
            R.drawable.fsalas,R.drawable.fsalas,R.drawable.fsalas,R.drawable.fsalas,
            R.drawable.fsalas,R.drawable.fsalas,R.drawable.fsalas,R.drawable.fsalas,
            R.drawable.fsalas};
    String[] Name = {"Rau muong xao toi","Salas","Salas","Salas","Salas","Salas","Salas","Salas","Salas",
            "Salas","Salas","Salas","Salas","Salas","Salas"};
    String[] Price = {"45.000d","45.000d","50.000d",
            "45.000d","45.000d","45.000d",
            "45.000d","45.000d","45.000d",
            "45.000d","45.000d","45.000d",
            "45.000d","45.000d","45.000d"};

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.shop, null);
        tabHost = (TabHost)view.findViewById(R.id.tabhost);
        tabHost.setup();
        //
        bag_count = (TextView)view.findViewById(R.id.cart_badge);
        count = Integer.parseInt(bag_count.getText().toString());
        // list produces tab 1
        produceview = (RecyclerView) view.findViewById(R.id.listitem);
        produceview.setHasFixedSize(false);
        produceview.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        // list produce tab3
        list3 = (RecyclerView) view.findViewById(R.id.listitem3);
        list3.setHasFixedSize(false);
        list3.setLayoutManager(new GridLayoutManager(this.getContext(), 3));


    // add all item for list
        list = new ArrayList<>();
        for (int i=0; i<Image.length; i++)
        {
            Produces produces = new Produces();
            produces.setName(Name[i]);
            produces.setPrice(Price[i]);
            produces.setImage(Image[i]);
            list.add(produces);
        }
        // add all item for list
        list2 = new ArrayList<>();
        for (int i=0; i<Image.length; i++)
        {
            Produces produces = new Produces();
            produces.setName(Name[i]);
            produces.setPrice(Price[i]);
            produces.setImage(Image2[i]);
            list2.add(produces);
        }


        // add adapter for list
        adapter = new ProducesAdapter(this.getContext(),list);
        adapter2 = new ProducesAdapter(this.getContext(),list2);
        produceview.setAdapter(adapter);
        list3.setAdapter(adapter2);

        //tab1
        TabHost.TabSpec spec = tabHost.newTabSpec(getResources().getString(R.string.tab1));
        spec.setContent(R.id.tab1);
        spec.setIndicator(getResources().getString(R.string.tab1));
        tabHost.addTab(spec);
        //tab2
        spec = tabHost.newTabSpec(getResources().getString(R.string.tab2));
        spec.setContent(R.id.tab2);
        spec.setIndicator(getResources().getString(R.string.tab2));
        tabHost.addTab(spec);
        //tab3
        spec = tabHost.newTabSpec(getResources().getString(R.string.tab3));
        spec.setContent(R.id.tab3);
        spec.setIndicator(getResources().getString(R.string.tab3));
        tabHost.addTab(spec);
        //tab4
        spec = tabHost.newTabSpec(getResources().getString(R.string.tab4));
        spec.setContent(R.id.tab4);
        spec.setIndicator(getResources().getString(R.string.tab4));
        tabHost.addTab(spec);
        //call animation when tab change
        tabHost.setOnTabChangedListener(new AnimationTab(this.getContext(), tabHost));
        // set adapter item click
        adapter.setOnItemClickListener(new ProducesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                count++;
                bag_count.setText(String.valueOf(count));
                bag_count.setVisibility(View.VISIBLE);
            }
        });
        return view;
        // work for next day: create layout for bag produce, add all item that user choose and sum money for all item in bag
        // event remove item in bag when user clicked that item and reset money sum
    }

}
