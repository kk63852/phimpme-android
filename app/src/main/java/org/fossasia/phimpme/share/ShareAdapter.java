package org.fossasia.phimpme.share;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.fossasia.phimpme.R;
import org.fossasia.phimpme.data.local.AccountDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

import static org.fossasia.phimpme.utilities.ActivitySwitchHelper.context;
import static org.fossasia.phimpme.utilities.ActivitySwitchHelper.getContext;

/**
 * Created by pa1pal on 24/07/17.
 */

public class ShareAdapter extends RecyclerView.Adapter<ShareAdapter.ViewHolder> {

    @Override
    public ShareAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.share_item_view, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Integer id;
        String name = AccountDatabase.AccountName.values()[position].toString();
        holder.accountName.setText(name);

        id = getContext().getResources().getIdentifier(context.getString(R.string.ic_) +
                        (name.toLowerCase()) + "_black", context.getString(R.string.drawable)
                , getContext().getPackageName());

        holder.accountImage.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return AccountDatabase.AccountName.values().length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.account_image)
        ImageView accountImage;

        @BindView(R.id.account_name)
        TextView accountName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}