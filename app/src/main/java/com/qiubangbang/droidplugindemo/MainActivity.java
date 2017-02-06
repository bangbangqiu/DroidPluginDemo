package com.qiubangbang.droidplugindemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.morgoo.droidplugin.pm.PluginManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        file = new File(Environment.getExternalStorageDirectory(), "testPlugin.apk");
    }

    public void onOpenPlugin(View view) {
        //打开插件
        PackageManager pm = getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage("com.qiubangbang.singalchart");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onInstallPlugin(View view) {
        //安装插件
        try {
            PluginManager.getInstance().installPackage(file.getAbsolutePath(), 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
