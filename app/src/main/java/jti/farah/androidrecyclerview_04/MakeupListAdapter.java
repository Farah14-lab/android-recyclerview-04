package jti.farah.androidrecyclerview_04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MakeupListAdapter extends RecyclerView.Adapter<MakeupListAdapter.RecipeViewHolder>{
    private ArrayList<MakeupData> recipeList;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnItemClickListener;

    public MakeupListAdapter(Context context, ArrayList<MakeupData> recipeList){
        mInflater = LayoutInflater.from(context);
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public MakeupListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.item_list, viewGroup, false);
        return new RecipeViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MakeupListAdapter.RecipeViewHolder recipeViewHolder, int position) {
        recipeViewHolder.name.setText((recipeList.get(position)).getName());
        recipeViewHolder.description.setText((recipeList.get(position)).getDescription());
        Glide.with(recipeViewHolder.itemView)
                .load(recipeList.get(position).getImage())
                .override(100, 150)
                .into(recipeViewHolder.image);
    }


    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView image;


        public RecipeViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.recipe_name);
            description = itemView.findViewById(R.id.recipe_description);
            image = itemView.findViewById(R.id.recipe_image);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }
}