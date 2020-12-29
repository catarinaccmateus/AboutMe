package pt.cccm.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import pt.cccm.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Using Data Binding: binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val button = binding.doneButton
        button.setOnClickListener{
            addNickname(it)
        }
    }
    fun addNickname(view: View) {
        // val input = binding.nicknameInput
        // val nicknameView = binding.nicknameText
        // nicknameView.text = input.text
        // input.visibility = View.GONE
        // view.visibility = View.GONE
        // nicknameView.visibility = View.VISIBLE
        //Same as above:
        binding.apply {
            nicknameText.text = nicknameInput.text
            //invalidAll()  -> With dataBinding:  In order to refresh the UI with new data
            nicknameInput.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}