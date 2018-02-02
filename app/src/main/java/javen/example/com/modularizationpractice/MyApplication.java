package javen.example.com.modularizationpractice;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.github.mzule.activityrouter.router.RouterCallback;
import com.github.mzule.activityrouter.router.RouterCallbackProvider;
import com.github.mzule.activityrouter.router.SimpleRouterCallback;

/**
 * Created by Javen on 02/02/2018.
 */

public class MyApplication extends Application implements RouterCallbackProvider {
    @Override
    public RouterCallback provideRouterCallback() {
        return new SimpleRouterCallback() {
            @Override
            public boolean beforeOpen(Context context, Uri uri) {
//                Intent intent = new Intent(context, javen.example.com.modulea.MainActivity.class);
//                intent.putExtra("fly", "bird");
//                context.startActivity(intent);
                //是否拦截，true 可以通过这里拦截调原始的请求，并附加一些参数进去。
                return false;
            }

            @Override
            public void afterOpen(Context context, Uri uri) {
                super.afterOpen(context, uri);
            }

            @Override
            public void notFound(Context context, Uri uri) {
                super.notFound(context, uri);
            }

            @Override
            public void error(Context context, Uri uri, Throwable e) {
                super.error(context, uri, e);
            }
        };

    }
}
