package cn.baikunlong.library;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Android Studio.
 * User: baikunlong
 * Date: 2019/1/18
 * Time: 19:16
 */
public class ToastUtil02 {

    public static void say(Context context,String data){
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
    }

}
