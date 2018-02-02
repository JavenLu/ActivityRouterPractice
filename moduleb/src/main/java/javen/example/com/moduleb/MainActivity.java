package javen.example.com.moduleb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mzule.activityrouter.annotation.Module;
import com.github.mzule.activityrouter.annotation.Modules;
import com.github.mzule.activityrouter.router.Routers;

@Module("moduleb")
public class MainActivity extends AppCompatActivity {
    private Button jumpToModuleAMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_module_b);
        initClickListener();
    }

    private void initClickListener() {
        jumpToModuleAMainActivity = findViewById(R.id.jump_1);
        jumpToModuleAMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Routers.open(MainActivity.this, "jump://moduleAMainActivity2");
                //Routers.open(MainActivity.this, "jump://moduleAMainActivity2?name=Javen");
                //Routers.open(MainActivity.this, "jump://moduleAMainActivity2/0xFF4081");
                //Routers.open(MainActivity.this, "jump://moduleAMainActivity2/1/Javen/打不死的小强");
                //Routers.open(MainActivity.this, "jump://moduleAMainActivity2/255");
                //Routers.open(MainActivity.this, "http://javen.com/moduleAMainActivity2");
                Routers.open(MainActivity.this, "jump://showSomeMessage");
            }
        });
    }
}
