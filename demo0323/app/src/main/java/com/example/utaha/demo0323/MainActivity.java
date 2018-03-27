package com.example.utaha.demo0323;

import android.os.Bundle;

import android.app.ListActivity;
//import android.widget.ArrayAdapter;
//import android.widget.ListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.View;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.SimpleAdapter;
import android.widget.BaseAdapter;
import android.widget.Toast;
import android.widget.TextView;
import android.view.ViewGroup;
import android.content.Intent;
import android.view.LayoutInflater;
import android.content.Context;


public class MainActivity extends ListActivity {

    ArrayList<HashMap<String,String>> data_list = new ArrayList<HashMap<String,String>>();

//    private SimpleAdapter adapter;
    YourAdapter adapter = null;
    ListView listview;

    private static final String[] mPlaces = new String[] {
            "彰化鹿港", "彰化", "台中", "台北", "高雄",

    };

    private static final String[] mFoods = new String[] {
            "蚵仔煎","肉圓","滷肉飯","大腸麵線","芒果冰",
    };

    private static final String[] mFoods_img = new String[] {
            String.valueOf(R.drawable.p1),
            String.valueOf(R.drawable.p2),
            String.valueOf(R.drawable.p3),
            String.valueOf(R.drawable.p4),
            String.valueOf(R.drawable.p5)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(android.R.id.list);

        for(int i=0; i<mPlaces.length; i++){
            HashMap<String,String> item = new HashMap<String,String>();
            item.put( "food", mFoods[i]);
            item.put( "place",mPlaces[i] );
            item.put("mFoods_img",mFoods_img[i]);
            data_list.add( item );
        }

//        adapter = new SimpleAdapter(
//                this,
//                list,
//                android.R.layout.simple_list_item_2,
//                new String[] { "food","place" },
//                new int[] { android.R.id.text1, android.R.id.text2 } );
//
//        setListAdapter(adapter);
        adapter = new YourAdapter(this, data_list);

        listview.setAdapter(adapter);
    }


    class YourAdapter extends BaseAdapter {

        Context context;
        ArrayList<HashMap<String,String>> data;
        private LayoutInflater inflater = null;

        public YourAdapter(Context context, ArrayList<HashMap<String,String>> data) {
            // TODO Auto-generated constructor stub
            this.context = context;
            this.data = data;
//                inflater = (LayoutInflater) context
//                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View vi = convertView;
            if (vi == null)
                vi = inflater.inflate(R.layout.item_view, null);
            TextView text = (TextView) vi.findViewById(R.id.item_textView);
            text.setText(data_list.get(position).get("place"));
            TextView text2 = (TextView) vi.findViewById(R.id.item_textView2);
            text2.setText(data_list.get(position).get("food"));
            ImageView img = (ImageView) vi.findViewById(R.id.item_img);
            img.setImageResource(Integer.parseInt(data_list.get(position).get("mFoods_img")));
            return vi;
        }
    }



    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        HashMap<String,String> o = (HashMap<String,String>)l.getItemAtPosition(position);
        String food = o.get("food").toString();
        String place = o.get("place").toString();
        String mFoods_img = o.get("mFoods_img").toString();

//        Toast.makeText(getApplicationContext(), "You have chosen: " + " " +
//                click_item, Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),  food + ":" + place, Toast.LENGTH_LONG).show();
        Intent intent1 = new Intent(v.getContext(), DetailedActivity.class);
        intent1.putExtra("food", food);
        intent1.putExtra("place", place);
        intent1.putExtra("mFoods_img",mFoods_img);
        startActivityForResult(intent1,0);



    };
}

