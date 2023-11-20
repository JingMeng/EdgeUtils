package cn.jailedbird.barutils_app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import cn.jailedbird.edgeutils.EdgeUtils.edgeStatusBarHeight
import cn.jailedbird.edgeutils.EdgeUtils.edgeToEdge
import com.blankj.utilcode.util.ToastUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ACTION bar 会影响的  导致没有办法沉浸，在  navigation-edge-sample 修改了这个主题
        //Sunflower 的也是 Theme.MaterialComponents.DayNight.NoActionBar 来处理的
        edgeToEdge()
        setContentView(R.layout.activity_main)
        val job = lifecycleScope.launch {
            ToastUtils.showShort("status bar height is ${edgeStatusBarHeight()}")
        }
        lifecycleScope.launch {
            val view = findViewById<TextView>(R.id.tv1)
            var count = 0
            while (true) {
                delay(1000)
                view.text = "${count++}"
                job.cancel()
            }
        }

    }
}