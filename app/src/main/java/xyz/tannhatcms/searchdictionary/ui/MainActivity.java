package xyz.tannhatcms.searchdictionary.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.util.ArrayList;
import xyz.tannhatcms.searchdictionary.utils.DataBase;
import xyz.tannhatcms.searchdictionary.R;
import xyz.tannhatcms.searchdictionary.adapter.ListView;

public class MainActivity extends AppCompatActivity {
    android.widget.ListView lv;
    DataBase db = new DataBase(this);
    ArrayList<String> ar = null;
    String[] item = {"Tra Từ Điển Anh-Việt", "Ngữ Pháp","Luyện Tập",  "Lịch sử Luyện Tập", "Cài Đặt"};
    Integer[] icon = {R.drawable.timkiem,  R.drawable.book2,R.drawable.tets, R.drawable.ghi_chu, R.drawable.icon1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            db.CopyDB2SDCard();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ar = new ArrayList<>();
        for (String a : item) {
            ar.add(a);
        }
        ActionBar ab = getSupportActionBar();
        //set mầu cho actionBar
        ab.setTitle("Tra Từ Điển");
        ListView adapter = new ListView(this, ar, icon);
        lv = findViewById(R.id.Listitem);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((parent, view, position, id) -> {
            // TODO Auto-generated method stubin
            Intent in;
            switch (position) {
                case 0:
                    in = new Intent(getApplication(), SearchDictionaryAtivity.class);
                    startActivity(in);
                    break;
                    case 2:
                        in = new Intent(getApplication(), QuestionActivity.class);
                        startActivity(in);
                        break;
                        case 1:
                            in = new Intent(getApplication(), GrammarListActivity.class);
                            startActivity(in);
                            break;
                            case 3:
                                in = new Intent(getApplication(), HistoryTestActivity.class);
                                startActivity(in);
                                break;
                                case 4:
                                    in = new Intent(getApplication(), SettingActivity.class);
                                    startActivity(in);
                                    break;
            }
        });
    }
}

