package com.example.bback

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.bback.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    private val sliderImageHandler: Handler = Handler()
    private val sliderImageRunnable = Runnable { binding.imageViewpager.currentItem = binding.imageViewpager.currentItem + 1 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, MainActivity::class.java)  // 인텐트를 생성해줌,
        binding.odBtn1.setOnClickListener{
            startActivity(intent)
        }
        binding.odBtn2.setOnClickListener{
            startActivity(intent)
        }
        val imageList = arrayListOf<Int>().apply {
            for (i in 0..2) {
                add(R.drawable.bback1)
                add(R.drawable.bback2)
                add(R.drawable.bback3)
                add(R.drawable.bback4)
                add(R.drawable.bback5)
            }
        }

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth)
        val screenWidth = resources.displayMetrics.widthPixels
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        binding.imageViewpager.apply {
            adapter = ViewPagerAdapter(imageList, binding.imageViewpager)
            offscreenPageLimit = 1
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    sliderImageHandler.removeCallbacks(sliderImageRunnable)
                    sliderImageHandler.postDelayed(sliderImageRunnable, 2000)
                }
            })
            setPageTransformer { page, position ->
                page.translationX = position * -offsetPx
            }
        }
    }

    override fun onResume() {
        super.onResume()
        sliderImageHandler.postDelayed(sliderImageRunnable, 2000)
    }

    override fun onPause() {
        super.onPause()
        sliderImageHandler.removeCallbacks(sliderImageRunnable)
    }

}