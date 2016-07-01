package silive.in.ideartist.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.alexvasilkov.foldablelayout.FoldableListLayout;

import silive.in.ideartist.Adapters.ListAdapter;
import silive.in.ideartist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Unread extends Fragment {
    ListView list_unread;
    String [] arg_news = {"The news header","The news header","The news header","The news header","The news header"};
    String [] arg_news_content = {"This is the news content\n The content here. This area is meant to hold the content of the story.","This is the news content\n The content here. This area is meant to hold the content of the story.","This is the news content \n The content here. This area is meant to hold the content of the story.","This is the news content \n The content here. This area is meant to hold the content of the story.","This is the news content \n The content here. This area is meant to hold the content of the story."};
    String [] arg_news_provider = {"news provider","news provider","news provider","news provider","news provider"};
    Integer [] arg_news_img = {R.drawable.news1,R.drawable.news1,R.drawable.news1,R.drawable.news1,R.drawable.news1};
    FoldableListLayout foldableListLayout;
    SwipeRefreshLayout mSwipeRefreshLayout;

    public Unread() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_unread, container, false);
        //list_unread = (ListView)view.findViewById(R.id.list_unread);
        //FlipView flipView = (FlipView) view.findViewById(R.id.flip_view);
        //list_unread.setAdapter( new ListAdapter(getContext(),arg_news,arg_news_content,arg_news_img,arg_news_provider));
        //void setAdapter(ListAdapter listAdapter);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.unread_swipe_refresh_layout);
        foldableListLayout = (FoldableListLayout)view.findViewById(R.id.foldable_list_unread);
        foldableListLayout.setAdapter(new ListAdapter(getContext(),arg_news,arg_news_content,arg_news_img,arg_news_provider));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });


        //listAdapter.setAdapter(listAdapter);
        //listAdapter.flipBy(1);
        //ListAdapter listAdapter1 = getAdapter();
        return  view;
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
