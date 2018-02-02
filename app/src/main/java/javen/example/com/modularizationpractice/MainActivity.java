package javen.example.com.modularizationpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mzule.activityrouter.annotation.Module;
import com.github.mzule.activityrouter.annotation.Modules;
import com.github.mzule.activityrouter.router.Routers;
@Module("app")
@Modules({"app","library","modulea","moduleb"})
public class MainActivity extends AppCompatActivity {
    private Button jumpToModuleAMainActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_module_b);
        initClickListener();
    }

    private void initClickListener() {

        jumpToModuleAMainActivityButton = findViewById(R.id.jumpButton_1);
        jumpToModuleAMainActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到ModuleA主页面
                Routers.open(MainActivity.this, "jump://moduleAMainActivity");
            }
        });
    }
}
