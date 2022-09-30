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

public class MakeupListAdapter extends RecyclerView.Adapter<MakeupListAdapter.MakeupViewHolder>{
    private ArrayList<MakeupData> MakeupList;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnItemClickListener;

    public MakeupListAdapter(Context context, ArrayList<MakeupData> MakeupList){
        mInflater = LayoutInflater.from(context);
        this.MakeupList = MakeupList;
    }

    @NonNull
    @Override
    public MakeupListAdapter.MakeupViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.item_list, viewGroup, false);
        return new MakeupViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MakeupListAdapter.MakeupViewHolder MakeupViewHolder, int position) {
        MakeupViewHolder.name.setText((MakeupList.get(position)).getName());
        MakeupViewHolder.description.setText((MakeupList.get(position)).getDescription());
        Glide.with(MakeupViewHolder.itemView)
                .load(MakeupList.get(position).getImage())
                .override(100, 150)
                .into(MakeupViewHolder.image);
    }


    @Override
    public int getItemCount() {
        return MakeupList.size();
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    class MakeupViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView image;


        public MakeupViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.Makeup_name);
            description = itemView.findViewById(R.id.Makeup_description);
            image = itemView.findViewById(R.id.Makeup_image);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }
}
