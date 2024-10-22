package com.example.movie_app.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.movie_app.models.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPreference {
    private const val NAME="catch_file_name"
    private const val MODE= Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences=context.getSharedPreferences(NAME, MODE)
    }
    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor)-> Unit){
        val editor=edit()
        operation(editor)
        editor.apply()
    }
    var list:ArrayList<User>
        get() = gsonToList(preferences.getString("KeyList","[]")!!)
        set(value) = preferences.edit{
            it.putString("KeyList", listToGson(value))
        }

    private fun gsonToList(gsontString:String):ArrayList<User>{
        val list=ArrayList<User>()
        val type=object : TypeToken<ArrayList<User>>(){}.type
        list.addAll(Gson().fromJson(gsontString,type))
        return list
    }
    private fun listToGson(list:ArrayList<User>):String{
        return Gson().toJson(list)
    }

}