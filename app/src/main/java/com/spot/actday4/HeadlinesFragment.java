package com.spot.actday4;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeadlinesFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    OnHeadlineSelectedListener callback;

    public void setOnHeadlineSelectedListener(OnHeadlineSelectedListener callback) {
        this.callback = callback;
    }

    public HeadlinesFragment() {
        // Required empty public constructor
    }

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(CharSequence position);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_headlines, container, false);
        listView = view.findViewById(R.id.healines_listview);
        listView.setOnItemClickListener(this);
        return  view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getActivity(), (CharSequence) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        callback.onArticleSelected((CharSequence) adapterView.getItemAtPosition(position));

    }
}
