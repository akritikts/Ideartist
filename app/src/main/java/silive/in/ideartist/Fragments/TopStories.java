package silive.in.ideartist.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alexvasilkov.foldablelayout.FoldableListLayout;

import silive.in.ideartist.Activities.MainActivity;
import silive.in.ideartist.Adapters.ListAdapter;
import silive.in.ideartist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopStories extends Fragment {
    ListView list_top_stories;
    String[] arg_news = {"The news header", "The news header", "The news header", "The news header", "The news header"};
    String[] arg_news_content = {"This is the news content", "This is the news content", "This is the news content", "This is the news content", "This is the news content"};
    String[] arg_news_provider = {"news provider", "news provider", "news provider", "news provider", "news provider"};
    Integer[] arg_news_img = {R.drawable.news, R.drawable.news, R.drawable.news, R.drawable.news, R.drawable.news};
    Context c;
    FoldableListLayout foldableListLayout;
    SwipeRefreshLayout mSwipeRefreshLayout;

    public TopStories() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_stories, container, false);
        c = getContext();
        //list_top_stories = (ListView) view.findViewById(R.id.list_top_stories);
        //FlipView flipView = (FlipView) view.findViewById(R.id.flip_view);
        //list_top_stories.setAdapter(new ListAdapter(getContext(), arg_news, arg_news_content, arg_news_img, arg_news_provider));
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.top_stories_swipe_refresh_layout);
        foldableListLayout = (FoldableListLayout)view.findViewById(R.id.foldable_list_top_stories);
        foldableListLayout.setAdapter(new ListAdapter(getContext(),arg_news,arg_news_content,arg_news_img,arg_news_provider));
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
