package com.example.swetashinde.openarchitecturedemo.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.domain.model.users.User;
import com.example.swetashinde.openarchitecturedemo.R;
import java.util.List;

/**
 * Created by swetashinde on 10/23/17.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {


  private List<User> mUserList;
  private Context mContext;




  public UsersAdapter(Context context , List<User> userList){
    this.mContext = context;
    this.mUserList = userList;
  }

  // Easy access to the context object in the recyclerview
  private Context getContext() {
    return mContext;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);

    // Inflate the custom layout
    View userView = inflater.inflate(R.layout.item_user, parent, false);

    // Return a new holder instance
    ViewHolder viewHolder = new ViewHolder(userView);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {

    User user = mUserList.get(position);

    //set the values for views here

    TextView nameTextView = holder.name;
    nameTextView.setText(user.getName().toString());

    TextView   genderTextView = holder.gender;
    genderTextView.setText(user.getGender());

    TextView   phoneTextView = holder.phone;
    phoneTextView.setText(user.getPhoneNumber());


    TextView   emailTextView = holder.email;
    emailTextView.setText(user.getEmail());

    GlideUrl glideUrl = new GlideUrl(user.getPicture().getThumbnail(), new LazyHeaders.Builder()
        .build());

    ////Log.v("Documents adapter", "glide url is " + document.getThumbnail().getMedium()+" token is "+mToken);

    Glide.with(mContext)
        .load(glideUrl)
        .placeholder(R.drawable.user_avatar_placeholder)
        .error(R.drawable.user_avatar_placeholder)
        .thumbnail(0.5f)
        .crossFade()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(holder.thumbnail);


  }

  @Override
  public int getItemCount() {
    return mUserList.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.user_thumbnail) ImageView thumbnail;
    @Bind(R.id.user_name)TextView  name;
    @Bind(R.id.user_gender)TextView  gender;
    @Bind(R.id.user_phone)TextView  phone;
    @Bind(R.id.user_email)TextView  email;


    public ViewHolder(View itemView){

      super(itemView);
      ButterKnife.bind(this, itemView);

    }


  }
}