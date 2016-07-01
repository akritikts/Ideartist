package silive.in.ideartist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import silive.in.ideartist.Activities.MainActivity;
import silive.in.ideartist.R;

/**
 * Created by akriti on 10/6/16.
 */
public class ListAdapter extends BaseAdapter {
    private static LayoutInflater inflater ;
    public Context context;
    String[] result = {};
    String[] news = {};
    Integer[] id = {};
    String [] content_by;
    MainActivity mainActivity;
    public class Holder {
        ImageView news_image;
        TextView news_heading;
        TextView news_content;
        TextView content_provoder;

    }

    public ListAdapter(Context c, String[] news_list, String[] news_content, Integer[] news_img,String [] credit) {
        result = news_list;
        context = c;
        news = news_content;
        id = news_img;
        content_by = credit;
        //mainActivity = m;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder = new Holder();
        View view = inflater.inflate(R.layout.adapter_news,null);
        holder.news_image= (ImageView)view.findViewById(R.id.news_image);
        holder.news_heading= (TextView)view.findViewById(R.id.news_heading);
        holder.news_content= (TextView)view.findViewById(R.id.news_content);
        holder.content_provoder= (TextView)view.findViewById(R.id.content_provider);
        holder.news_image.setImageResource(id[position]);
        holder.news_heading.setText(result[position]);
        holder.news_content.setText(news[position]);
        holder.content_provoder.setText(content_by[position]);
        return view;
    }


}
