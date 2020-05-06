package malang.paradise.com.smkcoding.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*
import malang.paradise.com.smkcoding.R

class SplashScreen : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val animation = AnimationUtils.loadAnimation(this, R.anim.mytransition)
        val slidetoleft = AnimationUtils.loadAnimation(this, R.anim.slidetoleft)
        val slidetoright = AnimationUtils.loadAnimation(this, R.anim.slidetoright)
        image.startAnimation(animation)
        image1.startAnimation(animation)
        satu.startAnimation(slidetoright)
        dua.startAnimation(slidetoright)
        tiga.startAnimation(slidetoleft)
        empat.startAnimation(slidetoleft)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}
