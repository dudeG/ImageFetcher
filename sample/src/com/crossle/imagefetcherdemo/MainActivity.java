
package com.crossle.imagefetcherdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.crossle.imagefetcher.ImageFetcher;
import com.crossle.imagefetcher.UIUtils;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the list fragment and add it as our sole content.
        if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
            ArrayListFragment list = ArrayListFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, list).commit();
        }

    }

    public static class ArrayListFragment extends ListFragment {

        ImageFetcher mImageFetcher;

        public ArrayListFragment() {

        }

        public final static ArrayListFragment newInstance()
        {
            ArrayListFragment f = new ArrayListFragment();
            return f;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mImageFetcher = UIUtils.getImageFetcher(getActivity());
            mImageFetcher.setImageFadeIn(false);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setListAdapter(new PhotoAdapter(getActivity(), mImageFetcher));

        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i("FragmentList", "Item clicked: " + id);
        }

        @Override
        public void onPause() {
            super.onPause();
            mImageFetcher.flushCache();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            mImageFetcher.closeCache();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}

class PhotoAdapter extends BaseAdapter {

    private Context mContext;

    private ImageFetcher mImageFetcher;

    public PhotoAdapter(Context c, ImageFetcher imageFetcher) {
        mContext = c;
        mImageFetcher = imageFetcher;
    }

    public int getCount() {
        return 100;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.two_line_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.imageView1);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text1);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String speakerImageUrl = "https://vplayer.net/uploads/video/poster/500f7b80760c7fa271000001/thumb_p480747492.jpg";

        mImageFetcher.loadImage(speakerImageUrl, viewHolder.icon,
                R.drawable.ic_launcher);

        return convertView;
    }

    static class ViewHolder {
        TextView text;
        ImageView icon;
    }
}