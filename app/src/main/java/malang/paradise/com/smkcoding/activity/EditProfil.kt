package malang.paradise.com.smkcoding.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import malang.paradise.com.smkcoding.R
import kotlinx.android.synthetic.main.activity_edit_profil.*

class EditProfil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.)

        editNama.setText(intent.getStringExtra("namaUser"))

        simpan.setOnClickListener { simpanEdit() }
    }

    private fun simpanEdit() {
        val namaEdit = editNama.text.toString()
        if (!namaEdit.isEmpty()) {

            val result = Intent()
            result.putExtra("namaUser", namaEdit)
            setResult(Activity.RESULT_OK, result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}
