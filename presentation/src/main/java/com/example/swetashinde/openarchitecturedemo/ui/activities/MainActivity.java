package com.example.swetashinde.openarchitecturedemo.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.data.remote.repository.impl.UsersRepositoryImpl;
import com.example.domain.executor.Executor;
import com.example.domain.executor.MainThread;
import com.example.domain.model.users.User;
import com.example.domain.model.users.UsersResponse;
import com.example.swetashinde.openarchitecturedemo.R;
import com.example.swetashinde.openarchitecturedemo.application.MyApplication;
import com.example.swetashinde.openarchitecturedemo.presenters.impl.users.UsersPresenterImpl;
import com.example.swetashinde.openarchitecturedemo.presenters.users.UsersPresenter;
import com.example.swetashinde.openarchitecturedemo.ui.adapters.UsersAdapter;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements UsersPresenter.View {


  @Inject SharedPreferences sharedPreferences;
  @Inject MainThread mainThread;
  @Inject Executor threadExecutor;

  private UsersPresenter usersPresenter;
  private static final String LOG_TAG = "MainActivity";

  private List<User> mUsers;

  @Bind(R.id.user_list)RecyclerView usersRecyclerView;
  @Bind(R.id.next_button) Button nextButton;




  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // assign singleton instances to fields
    // We need to cast to `MyApp` in order to get the right method
    ((MyApplication)getApplication()).getAppComponent().inject(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    //setUpListeners();


    usersPresenter = new UsersPresenterImpl(threadExecutor,mainThread,this, new UsersRepositoryImpl(getApplication()));

    usersPresenter.getUsers();



  }

  private void setUpListeners(){
    nextButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this,NextActivity.class);
        startActivity(intent);


      }
    });
  }

  @Override public void showError(String message) {

  }

  @Override public void onGetUsersTaskComplete(UsersResponse usersResponse) {


    mUsers = usersResponse.getUsers();
    updateUI();
    // Toast.makeText(getApplicationContext(),"API success ",Toast.LENGTH_SHORT).show();

  }

  @Override public void onGetUsersTasksError() {

    Toast.makeText(getApplicationContext(),"API Error ",Toast.LENGTH_SHORT).show();


  }

  private void updateUI(){

    UsersAdapter adapter = new UsersAdapter(this,mUsers);
    // Attach the adapter to the recyclerview to populate items
    usersRecyclerView.setAdapter(adapter);
    // Set layout manager to position the items
    usersRecyclerView.setLayoutManager(new LinearLayoutManager(this));


  }



}
