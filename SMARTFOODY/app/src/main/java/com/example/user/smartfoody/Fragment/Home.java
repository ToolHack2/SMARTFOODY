package com.example.user.smartfoody.Fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.smartfoody.AcitvityHome.CANH;
import com.example.user.smartfoody.R;

/**
 * Created by User on 11/27/2017.
 */

public class Home extends Fragment {

    private ImageView canh, kho, xao, rau;
    private TextView mcanh, mkho, mxao, mrau;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);
        //image
        canh = (ImageView)view.findViewById(R.id.imgcanh);
        kho = (ImageView)view.findViewById(R.id.imgkho);
        xao = (ImageView)view.findViewById(R.id.imgxao);
        rau = (ImageView)view.findViewById(R.id.imgrau);
        //text
        mcanh = (TextView)view.findViewById(R.id.txtcanh);
        mkho = (TextView)view.findViewById(R.id.txtkho);
        mxao = (TextView)view.findViewById(R.id.txtxao);
        mrau = (TextView)view.findViewById(R.id.txtrau);
        //event image click
        canh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tocanh = new Intent(getActivity(), CANH.class);
                startActivity(tocanh);
            }
        });
        kho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        xao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        rau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // event text click
        mcanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mkho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mxao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mrau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
}
