package com.example.hongyejin.small;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HONGGIBEOM on 2017. 9. 16..
 */

public class isDeliverAdapter extends RecyclerView.Adapter<isDeliverAdapter.ViewHolder>{

    private ArrayList<DeliverData> deliverList;
    private Context context;
    final static int REQUEST_CODE_TO_DETAIL = 12345;

    public static ArrayList<Integer> deliverIndex=new ArrayList<>();


    public isDeliverAdapter(Context context, ArrayList<DeliverData> deliverList) {
        this.deliverList = deliverList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.isdelivered_items, parent, false);
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
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final DeliverData deliverData= deliverList.get(position);

        holder.name.setText(deliverData.getUserName());
        holder.address.setText(deliverData.getUserAddress());
        holder.number.setText(deliverData.getPhoneNum());
        holder.number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });




    }

    private void removeItemView(int position) {
        deliverList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,deliverList.size());

    }

    @Override
    public int getItemCount() {
        return deliverList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, address, number;

        /**************************************************/
        /** TODO initialize view components in item view **/
        /**************************************************/
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.deliverName);
            address = (TextView)itemView.findViewById(R.id.deliverAddress);
            number = (TextView)itemView.findViewById(R.id.deliverNumber);

        }
    }
}
