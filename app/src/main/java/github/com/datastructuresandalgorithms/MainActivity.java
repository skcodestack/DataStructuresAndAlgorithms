package github.com.datastructuresandalgorithms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import github.com.datastructuresandalgorithms.map.hashmap.StoneHashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_hashmap(View view){

        StoneHashMap<String,String> map =new StoneHashMap<>();

        map.put("111","aaaa");
        map.put("222","aaaa");
        map.put("333","aaaa");
        map.put("444","aaaa");
        map.put("555","aaaa");
        map.put("666","aaaa");
        map.put("777","aaaa");
        map.put("888","aaaa");
        map.put("999","aaaa");
        map.put("000","aaaa");

        Log.e("MainActivity","=================>"+map.get("555")+"-----size："+map.size());
        //看存储结构
        map.showStorgeStructure();

    }
}
