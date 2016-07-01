package silive.in.ideartist.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexvasilkov.foldablelayout.FoldableListLayout;

import silive.in.ideartist.Adapters.ListAdapter;
import silive.in.ideartist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bookmarked extends Fragment {
    //ListView list_bookmarked;
    FoldableListLayout foldableListLayout;
    SwipeRefreshLayout mSwipeRefreshLayout;
    String[] arg_news = {"The news header", "The news header", "The news header", "The news header", "The news header"};
    String[] arg_news_content = {"This is the news content\n The content here. This area is meant to hold the content of the story.", "This is the news content\n The content here. This area is meant to hold the content of the story.", "This is the news content \n The content here. This area is meant to hold the content of the story.", "This is the news content \n The content here. This area is meant to hold the content of the story.", "This is the news content \n The content here. This area is meant to hold the content of the story."};
    String[] arg_news_provider = {"news provider", "news provider", "news provider", "news provider", "news provider"};
    Integer[] arg_news_img = {R.drawable.news1, R.drawable.news1, R.drawable.news1, R.drawable.news1, R.drawable.news1};


    public Bookmarked() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bookmarked, container, false);
        //list_bookmarked = (ListView) view.findViewById(R.id.list_bookmarked);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.bookmarked_swipe_refresh_layout);

        foldableListLayout = (FoldableListLayout) view.findViewById(R.id.foldable_list_bookmark);
        foldableListLayout.setAdapter(new ListAdapter(getContext(), arg_news, arg_news_content, arg_news_img, arg_news_provider));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
        return view;
    }

    private void refreshContent() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        },2000);
    }

}
