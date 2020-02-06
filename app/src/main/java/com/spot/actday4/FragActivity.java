package com.spot.actday4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class FragActivity extends AppCompatActivity implements HeadlinesFragment.OnHeadlineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof HeadlinesFragment) {
            HeadlinesFragment headlinesFragment = (HeadlinesFragment) fragment;
            headlinesFragment.setOnHeadlineSelectedListener(this);
        }
    }

    @Override
    public void onArticleSelected(CharSequence position) {
        NewsFragment articleFrag = (NewsFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_newsdetails);

        if (articleFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            articleFrag.updateArticleView(position);
        }

    }
}
