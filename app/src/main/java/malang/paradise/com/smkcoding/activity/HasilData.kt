package malang.paradise.com.smkcoding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hasil_data.*
import malang.paradise.com.smkcoding.R

class HasilData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_data)

        nama.setText(intent.getStringExtra("nama"))
        umur.setText(intent.getStringExtra("umur"))
    }
}
