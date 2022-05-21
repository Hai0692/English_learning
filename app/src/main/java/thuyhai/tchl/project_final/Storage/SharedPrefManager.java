package thuyhai.tchl.project_final.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import thuyhai.tchl.project_final.models.User_info;

public class SharedPrefManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static String SHARED_PREF_NAME = "session";
    Context context;


    public SharedPrefManager(Context context){
        this.context = context;
    }

    public void SaveUser( User_info user){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt("id",user.getID());
        editor.putString("name", user.getName());
        editor.putString("email", user.getEmail());
        editor.putString("phone", user.getPhone());
        editor.putBoolean("logged", true);
        editor.apply();

    }
    public boolean isLoggedIn(){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("logged",false);
    }
    public User_info getUser(){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User_info(sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("name", null),
                sharedPreferences.getString("email", null),
                sharedPreferences.getString("phone", null));
    }
    public void logout(){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
