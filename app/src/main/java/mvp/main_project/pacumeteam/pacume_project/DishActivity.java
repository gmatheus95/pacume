package mvp.main_project.pacumeteam.pacume_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.icu.lang.UProperty.INT_START;

public class DishActivity extends AppCompatActivity {

    private ImageView imgDishes;
    private Button btnGoToEstablishment;
    private int [] imageArray;
    private int currentIndex;
    private int startIndex;
    private int endIndex;
    private TextView txtLeft;
    private TextView txtRight;
    private TextView txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);

        imgDishes = (ImageView)findViewById(R.id.imgDishes);
        imageArray = new int[8];
        imageArray[0] = R.mipmap.sandwich1;
        imageArray[1] = R.mipmap.sandwich2;
        imageArray[2] = R.mipmap.sandwich3;

        txtDescription = findViewById(R.id.txtDescription);

        String sourceString = "<b>Descrição:</b> Delicioso lanche com três hamburgueres e muito queijo<br><br><b>Categoria:</b> Lanches<br><br><b>Estabelecimento: </b>Burguer King";
        txtDescription.setText(Html.fromHtml(sourceString));

        startIndex = 0;
        endIndex = 2;

        txtLeft=findViewById(R.id.txtPrevious);
        txtLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousImage();
            }
        });

        txtRight = findViewById(R.id.txtNext);
        txtRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextImage();
            }
        });

        nextImage();

        btnGoToEstablishment = findViewById(R.id.btnGoToEstablishment);

        btnGoToEstablishment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), EstablishmentActivity.class);
                startActivity(intent);
            }
        });

    }

    public void nextImage(){
        currentIndex++;
        if(currentIndex > endIndex){
            currentIndex = startIndex;
        }
        imgDishes.setImageResource(imageArray[currentIndex]);

    }
    public void previousImage(){
        currentIndex--;
        if(currentIndex<startIndex){
            currentIndex = endIndex;
        }
        imgDishes.setImageResource(imageArray[currentIndex]);

    }
    
}
