package com.example.utaha.demo0323;

import android.os.Bundle;

import android.app.ListActivity;
//import android.widget.ArrayAdapter;
//import android.widget.ListAdapter;
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
            "台北市", "新北市", "台南市", "高雄市", "苗粟縣",
            "台北市", "新北市", "台南市", "高雄市", "苗粟縣",
            "台北市", "新北市", "台南市", "高雄市", "苗粟縣",
            "台北市", "新北市", "台南市", "高雄市", "苗粟縣",
            "台北市", "新北市", "台南市", "高雄市", "苗粟縣"
    };

    private static final String[] mFoods = new String[] {
            "大餅包小餅", "蚵仔煎", "東山鴨頭", "臭豆腐", "潤餅",
            "豆花", "青蛙下蛋","豬血糕", "大腸包小腸", "鹹水雞",
            "烤香腸","車輪餅","珍珠奶茶","鹹酥雞","大熱狗",
            "炸雞排","山豬肉","花生冰","剉冰","水果冰",
            "包心粉圓","排骨酥","沙茶魷魚","章魚燒","度小月"
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
            TextView text = (TextView) vi.findViewById(R.id.detailed_textView);
            text.setText(data_list.get(position).get("place"));
            TextView text2 = (TextView) vi.findViewById(R.id.detailed_textView2);
            text2.setText(data_list.get(position).get("food"));
            return vi;
        }
    }



    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        HashMap<String,String> o = (HashMap<String,String>)l.getItemAtPosition(position);
        String food = o.get("food").toString();
        String place = o.get("place").toString();

//        Toast.makeText(getApplicationContext(), "You have chosen: " + " " +
//                click_item, Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),  food + ":" + place, Toast.LENGTH_LONG).show();
        Intent intent1 = new Intent(v.getContext(), DetailedActivity.class);
        intent1.putExtra("food", food);
        intent1.putExtra("place", place);
        startActivityForResult(intent1,0);



    };
}

