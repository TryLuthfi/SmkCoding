package malang.paradise.com.smkcoding.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_homepage.*
import malang.paradise.com.smkcoding.R

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        setDataSpinner();
        simpan.setOnClickListener { funIntent() }

    }

    private fun setDataSpinner() {
        val adapter = ArrayAdapter.createFromResource(this,
        R.array.jenis_kelamin, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        jenisKelamin.adapter = adapter
    }

    private fun funIntent() {
        when {
            nama.text.toString().isEmpty() -> nama.error = "Nama tidak boleh kosong"
            jenisKelamin.selectedItem.equals("Pilih Jenis Kelamin") -> Toast.makeText(this, "Harap pilih jenis kelamin", Toast.LENGTH_SHORT).show()
            umur.text.toString().isEmpty() -> umur.error = "Umur tidak boleh kosong"
            email.text.toString().isEmpty() -> email.error = "Email tidak boleh kosong"
            telp.text.toString().isEmpty() -> telp.error = "Telp tidak boleh kosong"
            alamat.text.toString().isEmpty() -> alamat.error = "Alamat tidak boleh kosong"
            else -> {
                Toast.makeText(this, "Navigasi ke halaman profile", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ProfilActivity::class.java)
                intent.putExtra("nama", nama.text.toString())
                intent.putExtra("jenis_kelamin", jenisKelamin.selectedItem.toString())
                intent.putExtra("umur", umur.text.toString())
                intent.putExtra("email", email.text.toString())
                intent.putExtra("telp", telp.text.toString())
                intent.putExtra("alamat", alamat.text.toString())
                startActivity(intent)
            }
        }

    }
}
