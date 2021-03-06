package cn.teng520.scenery;

import android.content.Intent;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.Activity;

public class MainActivity extends Activity    {
    private ListView photoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        photoListView=(ListView)findViewById(R.id.photo_list);
        PlacesAdapter adapter=new PlacesAdapter(this);
        photoListView.setAdapter(adapter);
        photoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showPhoto(i);
            }
        });

    }

    private void showPhoto(int i) {
        Intent intent=new Intent(this,PlacesActivity.class);
        intent.putExtra("photoIndex",i);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            /*case R.id.intro_item:
                //showIntroduction();
                return true;*/
            case R.id.about_item:
                showAbout();
                return true;
        }
        return false;
    }

    private void showAbout() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.about)
                .setMessage(R.string.about_message)
                .setPositiveButton(android.R.string.ok,null)
                .create()
                .show();
    }

    /*private void showIntroduction() {
    }*/
}
