package malang.paradise.com.smkcoding.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profileactivity.*
import malang.paradise.com.smkcoding.R

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profileactivity)

        getHasil();
        edit.setOnClickListener { intentEdit() }
        dial.setOnClickListener { dialPressed(telp.text.toString()) }
        about.setOnClickListener { aboutIntent() }
    }

    private fun aboutIntent() {
        val intent = Intent(this, About::class.java)
        startActivity(intent)
    }

    private fun dialPressed(phoneNumber : String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel: $phoneNumber")
        }

        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    private fun intentEdit() {
        val intent = Intent(this, EditProfil::class.java)
        intent.putExtra("namaUser", nama.text.toString())
        startActivityForResult(intent, REQUEST_CODE)
    }

    private fun getHasil() {
        nama.setText(intent.getStringExtra("nama"))
        jenisKelamin.setText(intent.getStringExtra("jenis_kelamin"))
        umur.setText(intent.getStringExtra("umur"))
        email.setText(intent.getStringExtra("email"))
        telp.setText(intent.getStringExtra("telp"))
        alamat.setText(intent.getStringExtra("alamat"))
    }

    companion object{
        val REQUEST_CODE = 100
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val result = data?.getStringExtra("namaUser")
                nama.text = result
            } else {
                Toast.makeText(this, "Edit Nama Gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
