package mvp.main_project.pacumeteam.pacume_project;

import android.widget.ImageView;

/**
 * Created by felip on 15/12/2017.
 */

public class DishNModel {

    String nameDish;
    String estabilishmentName;
    ImageView photoDish;

    public DishNModel(String nameDish, String estabilishmentName, ImageView photoDish) {
        this.nameDish = nameDish;
        this.estabilishmentName = estabilishmentName;
        this.photoDish = photoDish;
    }

    public String getNameDish() {
        return nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public String getEstabilishmentName() {
        return estabilishmentName;
    }

    public void setEstabilishmentName(String estabilishmentName) {
        this.estabilishmentName = estabilishmentName;
    }

    public ImageView getPhotoDish() {
        return photoDish;
    }

    public void setPhotoDish(ImageView photoDish) {
        this.photoDish = photoDish;
    }
}
