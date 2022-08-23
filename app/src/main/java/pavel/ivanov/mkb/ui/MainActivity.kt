package pavel.ivanov.mkb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pavel.ivanov.mkb.R
import pavel.ivanov.mkb.databinding.ActivityMainBinding
import pavel.ivanov.mkb.ui.fragments.BaseFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BaseFragment())
                .commit()
        }
    }
}