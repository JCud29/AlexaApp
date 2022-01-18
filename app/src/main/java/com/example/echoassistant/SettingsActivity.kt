package com.example.echoassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class SettingsActivity : AppCompatActivity(), PreferenceFragmentCompat.OnPreferenceStartFragmentCallback{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.Settings_content,MainSettings()).commit()
        }
        else{
            title = savedInstanceState.getCharSequence(Title)
        }

        /*supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount==0)
            {
                setTitle(R.string.title_activity_settings)
            }
        }*/

        setupToolbar()
    }

    /*override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle){
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putCharSequence(Title, title)
    }

    override fun onSupportNavigateUp(): Boolean {
        if(supportFragmentManager.popBackStackImmediate()){
            return true
        }
        return super.onSupportNavigateUp()
    }*/

    private fun setupToolbar() {
        supportActionBar?.setTitle(R.string.title_activity_settings)
    }

    class MainSettings: PreferenceFragmentCompat(){
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }

    }

    override fun onPreferenceStartFragment(
        caller: PreferenceFragmentCompat?,
        pref: Preference?
    ): Boolean {
        val argument = pref?.extras
        val fragment = pref?.fragment?.let { supportFragmentManager.fragmentFactory.instantiate(classLoader, it)
            .apply {
                arguments = argument
                setTargetFragment(caller, 0)
            }
        }
        fragment?.let{
            supportFragmentManager.beginTransaction().replace(R.id.Settings_content, it).addToBackStack(null).commit()
        }
        title = pref?.title
        return true
    }

    companion object {
        private val Title = SettingsActivity::getTitle.toString()
    }
}