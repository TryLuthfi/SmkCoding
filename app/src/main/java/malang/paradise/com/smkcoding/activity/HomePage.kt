package malang.paradise.com.smkcoding.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import kotlinx.android.synthetic.main.activity_homepage.*
import malang.paradise.com.smkcoding.R

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        simpan.setOnClickListener { funIntent() }

    }

    private fun funIntent() {
        val intent = Intent(this, HasilData ::class.java)
        intent.putExtra("nama", nama.text.toString())
        intent.putExtra("umur", umur.text.toString())
        startActivity(intent)
    }
}
