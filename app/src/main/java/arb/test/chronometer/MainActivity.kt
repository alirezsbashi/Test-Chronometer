package arb.test.chronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var pauseOffset = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tog_main_on.setOnClickListener {
            if (tog_main_on.isChecked) {
                chr_main_timer.base = SystemClock.elapsedRealtime() - pauseOffset
                chr_main_timer.start()
            }
            else {
                pauseOffset = SystemClock.elapsedRealtime() - chr_main_timer.base
                chr_main_timer.stop()
            }
        }

//        on click btn
        btn_main_rest.setOnClickListener {
            pauseOffset = 0L
            chr_main_timer.base = SystemClock.elapsedRealtime()
        }
    }
}
