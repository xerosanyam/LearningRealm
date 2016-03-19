package com.example.sanyam.learningrealm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sanyam.learningrealm.model.Person;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    RealmConfiguration realmConfiguration;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

        realmConfiguration=new RealmConfiguration.Builder(this).build();
        realm=Realm.getInstance(realmConfiguration);

        Person person=realm.where(Person.class).findFirst();
        if(person!=null){
            TextView textView=(TextView)findViewById(R.id.textView);
            textView.setText(person.getName());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    public void saveToDB(View view){
        EditText text=(EditText)findViewById(R.id.editText);
        Person person=new Person();
        person.setName(String.valueOf(text.getText()));
        person.setId(1);                                    //For saving only 1 row
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(person);
        realm.commitTransaction();
        person=realm.where(Person.class).findFirst();
        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setText(person.getName());
    }
}
