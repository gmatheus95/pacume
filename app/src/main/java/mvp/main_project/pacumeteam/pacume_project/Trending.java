package mvp.main_project.pacumeteam.pacume_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Trending extends FragmentActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);

        listView = (ListView) findViewById(R.id.lvTrending);

        List<DishNModel> dishNModels = new ArrayList<>();
        ImageView imageView = null;
        DishNModel dishNModel = new DishNModel("Stacker Triplo", "Burguer King", imageView);
        dishNModels.add(dishNModel);

        DishAdapter dishAdapter = new
                DishAdapter(dishNModels,this.getLayoutInflater());

        listView.setAdapter(dishAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplication(), DishActivity.class);
                startActivity(intent);
            }
        });
    }

}
