package com.bluewebspark.dbtestproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluewebspark.dbtestproject.R;
import com.bluewebspark.dbtestproject.listner.customButtonListener;
import com.bluewebspark.dbtestproject.model.AgentUserModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sohel Khan on 8/15/2017.
 */

public class AgentUsersAdapter extends RecyclerView.Adapter<AgentUsersAdapter.MyViewHolder> {
    List<AgentUserModel> orderNowList;
    Context context;
    String type;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvLiginId)
    TextView tvLiginId;
    @BindView(R.id.tvPoints)
    TextView tvPoints;
    private customButtonListener customListner = null;

    public AgentUsersAdapter(Context context, List<AgentUserModel> orderNowList) {
        this.context = context;
        this.orderNowList = orderNowList;
        this.type = type;
    }

    public void setCustomButtonListner(customButtonListener listener) {
        this.customListner = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View view) {
            super(view);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_agent_user, parent, false);
        ButterKnife.bind(this, itemView);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final AgentUserModel model = orderNowList.get(position);

        tvName.setText(model.getFullname());
        tvLiginId.setText(model.getLoginid());
        tvPoints.setText(model.getPoints());

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return orderNowList.size();
    }
}