package javen.example.com.modulea;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mzule.activityrouter.annotation.Module;
import com.github.mzule.activityrouter.annotation.Modules;
import com.github.mzule.activityrouter.annotation.Router;

/**
 * 同一个类可以命名多个地址，其他module根据任意一个都可以跳转到这个类
 */
@Module("modulea")
//@Router({"http://javen.com/moduleAMainActivity2", "moduleAMainActivity", "moduleAMainActivity2/:color"})
//@Router({"moduleAMainActivity", "moduleAMainActivity2/:userId/:userName/:nickName"})
//@Router(value = "moduleAMainActivity2/:color", intParams = "color")
//此方式只支持单个地址 int,long,short,byte,char,float,double,boolean，默认不指定则为String类型。
//@Router(value = "item", longParams = "id", transfer = "id=>itemId") //这里通过transfer = "id=>itemId"的方式，设定了 url 中名称为id的参数会被改名成itemId放到参数Bundle中，类型为long. 值得注意的是，这里，通过longParams = "id"或者longParams = "itemId"都可以设置参数类型为long.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_module_a);
        Toast.makeText(MainActivity.this, "moduleAMainActivity", Toast.LENGTH_SHORT).show();
        //getStringByQuestionMark();
        //getColorByParams();
        //getMultiParams();
        //getColorBySpecifiedType();
        //getStringByInterceptor();
    }

    private void getStringByInterceptor() {
        String bird = getIntent().getStringExtra("fly");
        Toast.makeText(MainActivity.this, bird, Toast.LENGTH_SHORT).show();
    }

    private void getColorBySpecifiedType() {
        int color = getIntent().getIntExtra("color", 0);
        Toast.makeText(MainActivity.this, color + "", Toast.LENGTH_SHORT).show();
    }

    private void getMultiParams() {
        String userId = getIntent().getStringExtra("userId");
        String userName = getIntent().getStringExtra("userName");
        String nickName = getIntent().getStringExtra("nickName");
        Toast.makeText(MainActivity.this, "userId=" + userId + " UserName=" + userName + " NickName=" + nickName, Toast.LENGTH_SHORT).show();
    }

    private void getColorByParams() {
        String color = getIntent().getStringExtra("color");
        Toast.makeText(MainActivity.this, "color=" + color, Toast.LENGTH_SHORT).show();
    }

    private void getStringByQuestionMark() {
        String name = getIntent().getStringExtra("name");
        Toast.makeText(MainActivity.this, "name=" + name, Toast.LENGTH_SHORT).show();
    }

    @Router("showSomeMessage")
    public static void showSomeMessage(Context context, Bundle bundle) {
        Toast.makeText(context, "url启动方法", Toast.LENGTH_SHORT).show();
    }
}
