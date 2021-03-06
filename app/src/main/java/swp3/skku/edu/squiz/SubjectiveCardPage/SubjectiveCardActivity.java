package swp3.skku.edu.squiz.SubjectiveCardPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import swp3.skku.edu.squiz.R;
import swp3.skku.edu.squiz.model.CardItem;
import swp3.skku.edu.squiz.model.UserAnswerItem;

/**
 * Created by LG on 2018-05-15.
 */

public class SubjectiveCardActivity extends AppCompatActivity {

    private RecyclerView subjectiveRV;
    private ArrayList<CardItem> subjectiveItemList = new ArrayList<>();
    private ArrayList<UserAnswerItem> userAnswerList = new ArrayList<>();
    Adapter_subjective adapter_subjective;
    TextView subjective_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subjectivepage);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        findViews();
        subjective_title.setText(title);
        subjectiveItemList = (ArrayList<CardItem>) intent.getSerializableExtra("list");

        for(int i=0; i<subjectiveItemList.size(); i++){
            UserAnswerItem userAnswerItem = new UserAnswerItem(null, false);
            userAnswerList.add(userAnswerItem);
        }

        adapter_subjective = new Adapter_subjective(title, R.layout.subjectivepage_content, this, subjectiveItemList, userAnswerList, SubjectiveCardActivity.this);
        subjectiveRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        subjectiveRV.setAdapter(adapter_subjective);
    }


    private void findViews() {
        subjective_title = findViewById(R.id.subjective_title);
        subjectiveRV = findViewById(R.id.subjectiveRV);
    }
}
