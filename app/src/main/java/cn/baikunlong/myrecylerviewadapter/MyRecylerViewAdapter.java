package cn.baikunlong.myrecylerviewadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Android Studio.
 * User: baikunlong
 * Date: 2019/1/17
 * Time: 16:32
 */
public class MyRecylerViewAdapter extends RecyclerView.Adapter<MyRecylerViewAdapter.MyViewHodler> {

    private Context context;
    private List<String> datas;

    public MyRecylerViewAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    /**
     * 相当于getView中创建View和ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView=View.inflate(context,R.layout.item_list,null);
//        return new MyViewHodler(itemView);
        return null;
    }

    /**
     * 相当于getView中数据和View绑定的代码
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {
        holder.tv_title.setText(datas.get(position)+"p:"+position);
//        if(position%3==0){
//            holder.iv_icon.setImageResource(R.mipmap.bg);
//        }else if(position%3==1){
//            holder.iv_icon.setImageResource(R.mipmap.bk);
//        }else {
//            holder.iv_icon.setImageResource(R.mipmap.ic_launcher_round);
//        }
    }

    /**
     * 返回总条数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(int position, String data) {
        datas.add(position,data);
        this.notifyItemInserted(position);
    }

    public void removeData(int position) {
        datas.remove(position);
        this.notifyItemRemoved(position);
    }

    class MyViewHodler extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private ImageView iv_icon;

        public MyViewHodler(@NonNull View itemView) {
            super(itemView);
//            tv_title=itemView.findViewById(R.id.tv_title);
//            iv_icon=itemView.findViewById(R.id.iv_icon);
            //设置item点击事件,getLayoutPosition()获取当前item的position
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(context, datas.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();
//                }
//            });
            //使用接口回调也行（但是发现如果要设置某图片或文字的点击事件，又写接口就显得反而麻烦了...）
            //相当于真正实现点击还是这里，但是执行逻辑是调用的接口方法
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener!=null){
                        onItemClickListener.onItemClick(v,datas.get(getLayoutPosition()));
                    }
                }
            });
            iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "这是图片"+datas.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view, String data);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

}
