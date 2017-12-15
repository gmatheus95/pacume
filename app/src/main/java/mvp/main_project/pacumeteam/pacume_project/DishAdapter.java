package mvp.main_project.pacumeteam.pacume_project;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishAdapter extends BaseAdapter{
    private List<DishNModel> dishNModels;
    private LayoutInflater mLayoutInflater;


    public DishAdapter(List<DishNModel> dishNModels,LayoutInflater context) {
        this.dishNModels = dishNModels;
        this.mLayoutInflater = context;
    }


    @Override
    public int getCount() {
        return dishNModels.size();
    }

    @Override
    public Object getItem(int i) {
        return dishNModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolderDish viewHolderDish;
        DishNModel dishNModel = dishNModels.get(i);

        View view = convertView;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.dish_cell, viewGroup, false);

            TextView tvDishNome = (TextView) view.findViewById(R.id.tvPratoNome);
            TextView tvDishEstabelecimento = (TextView) view.findViewById(R.id.tvEstabelecimentoNome);
            ImageView tvDishImagem = (ImageView) view.findViewById(R.id.DishImagem);

            viewHolderDish = new ViewHolderDish(tvDishNome, tvDishEstabelecimento, tvDishImagem);
            view.setTag(viewHolderDish);
        } else {
            viewHolderDish = (ViewHolderDish) view.getTag();
        }

        viewHolderDish.getNameDish().setText(dishNModel.getNameDish());
        viewHolderDish.getEstabilishmentName().setText(dishNModel.getEstabilishmentName());

        return view;
    }

}
