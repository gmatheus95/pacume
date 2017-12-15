package mvp.main_project.pacumeteam.pacume_project;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderDish {

    TextView nameDish;
    TextView estabilishmentName;
    ImageView photoDish;

    public ViewHolderDish(TextView nameDish, TextView estabilishmentName, ImageView photoDish) {
        this.nameDish = nameDish;
        this.estabilishmentName = estabilishmentName;
        this.photoDish = photoDish;
    }


    public TextView getNameDish() {
        return nameDish;
    }

    public void setNameDish(TextView nameDish) {
        this.nameDish = nameDish;
    }

    public TextView getEstabilishmentName() {
        return estabilishmentName;
    }

    public void setEstabilishmentName(TextView estabilishmentName) {
        this.estabilishmentName = estabilishmentName;
    }

    public ImageView getPhotoDish() {
        return photoDish;
    }

    public void setPhotoDish(ImageView photoDish) {
        this.photoDish = photoDish;
    }
}
