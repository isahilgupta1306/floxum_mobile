package adapter;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.artopher.floxum.R;
import com.artopher.floxum.topEventsAdapter;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<ModelClassRVpost> postList1;

    public PostAdapter(List<ModelClassRVpost> postList) {
        this.postList1 = postList;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_rv_template,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.profilePicture.setImageResource(postList1.get(position).getProfileImage());
        holder.postImage.setImageResource(postList1.get(position).getPostImage());
        holder.userId.setText(postList1.get(position).getUser_id());
        holder.userFullname.setText(postList1.get(position).getUsername());
        holder.postCaption.setText(postList1.get(position).getPost_caption());
        holder.postDate.setText(postList1.get(position).getPost_date_time());

    }

    @Override
    public int getItemCount() {
        return postList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,PopupMenu.OnMenuItemClickListener  {

        AppCompatImageView postImage ;
        CircleImageView profilePicture;
        MaterialTextView userFullname , userId , postDate , postCaption;
        ImageButton post_menu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            postImage = itemView.findViewById(R.id.postImage);
            userFullname = itemView.findViewById(R.id.user_fullName);
            userId = itemView.findViewById(R.id.user_id);
            postDate = itemView.findViewById(R.id.post_date);
            postCaption = itemView.findViewById(R.id.post_caption);
            profilePicture = itemView.findViewById(R.id.profilePicture);

            ImageButton post_menu=itemView.findViewById(R.id.post_menu);
            post_menu.setOnClickListener(this);



        }


        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }
        private void showPopupMenu(View v)
        {
            PopupMenu popupMenu=new PopupMenu(v.getContext(),v);
            popupMenu.inflate(R.menu.popup_menu);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch(item.getItemId()){
                case R.id.share:
                    Toast.makeText(itemView.getContext(),"share clicked",Toast.LENGTH_LONG);
                    return true;
                case R.id.report:
                    Toast.makeText(itemView.getContext(),"Reported",Toast.LENGTH_LONG);
                    return true;
                default:
                    return false;
            }

        }
    }
}
