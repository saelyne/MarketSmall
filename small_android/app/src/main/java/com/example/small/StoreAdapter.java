package com.example.small;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

/**
 * Created by HONGGIBEOM on 2017. 9. 16..
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    private List<StoreData> storeList;
    private Context context;




    public StoreAdapter(Context context, List<StoreData> storeList) {
        this.storeList = storeList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marketlist_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /** 아이템으로 구현될 xml 파일을 inflate하여 view라는 변수에 넣고,
     * view는 다시 ViewHolder의 생성자로 들어가서 ViewHolder객체를 생성합니다.
     * 그리고 해당 객체인 viewHolder를 리턴합니다.
     * 리턴된 객체는 onBindViewHolder() 메소드로 들어가게 됩니다
     * */



    /** 아이템뷰들을 Bind합니다(묶습니다).
     * 다시 말하면 각각의 아이템뷰를 리스트처럼 만들어주고, 각 아이템뷰마다 리스트에서의 포지션이 알아서 제공됩니다. (첫번째 :0)
     * */

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final StoreData storeData= storeList.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ItemList.class);
                intent.putExtra("ids",""+(storeData.getId()+1));
                context.startActivity(intent);
            }
        });
        holder.storeName.setText(storeData.getName());
        holder.storeDist.setText(storeData.getDist().toString());
        if(storeData.isShort==true) {
            holder.isShort.setVisibility(View.VISIBLE);
        }else{
            holder.isShort.setVisibility(View.GONE);
        }



    }

    private void removeItemView(int position) {
        storeList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,storeList.size());

    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView storeName, storeDist;
        ImageView isShort;
        /**************************************************/
        /** TODO initialize view components in item view **/
        /**************************************************/
        public ViewHolder(View itemView) {
            super(itemView);
            storeName = (TextView)itemView.findViewById(R.id.storeName);
            storeDist = (TextView)itemView.findViewById(R.id.storeDist);
            isShort = (ImageView)itemView.findViewById(R.id.isShort);

        }
    }

}

