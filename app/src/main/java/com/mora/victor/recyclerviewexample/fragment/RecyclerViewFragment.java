package com.mora.victor.recyclerviewexample.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mora.victor.recyclerviewexample.R;

/**
 * Created by Victor on 19-May-17.
 */

public class RecyclerViewFragment extends android.support.v4.app.Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        return  v;
    }
}
