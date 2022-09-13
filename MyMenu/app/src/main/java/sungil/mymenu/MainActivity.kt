package sungil.mymenu

import android.app.Dialog
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import sungil.mymenu.databinding.ActivityDialogBinding
import sungil.mymenu.databinding.ActivityMainBinding
import sungil.mymenu.databinding.ActivityMenuBinding


open class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var binding2: ActivityDialogBinding
    private lateinit var binding3: ActivityMenuBinding
    private var totalPrice:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding2 = ActivityDialogBinding.inflate(layoutInflater)
        binding3 = ActivityMenuBinding.inflate(layoutInflater)

        setContentView(binding.root)


        var drink = arrayOf(
            "원조빽스치노(SOFT)",
            "딸기바나나빽스치노(SOFT)",
            "초코바나빽스치노(SOFT)",
            "피스치오빽스치(SOFT)",
            "퐁당치(바닐라)",
            "퐁당치(원조커피",
            "퐁당치노(미숫가루)",
            "쿠키크런빽스치(SOFT)"
        )
        var price = arrayOf(4000, 4000, 4000, 5000, 3500, 3500, 3500, 4300)


        var image1: String =
            "https://paikdabang.com/wp-content/uploads/2018/05/%EC%9B%90%EC%A1%B0%EB%B9%BD%EC%8A%A4%EC%B9%98%EB%85%B8-SOFT-450x588.png"
        var image2: String =
            "https://paikdabang.com/wp-content/uploads/2018/05/%EC%99%84%EC%A0%84%EB%94%B8%EA%B8%B0%EB%B0%94%EB%82%98%EB%82%98-SOFT-450x588.png"
        var image3: String =
            "https://paikdabang.com/wp-content/uploads/2018/05/%EC%99%84%EC%A0%84%EC%B4%88%EC%BD%94%EB%B0%94%EB%82%98%EB%82%98_%EB%B9%BD%EC%8A%A4%EC%B9%98%EB%85%B8-SOFT-450x588.png"
        var image4: String =
            "https://paikdabang.com/wp-content/uploads/2018/05/%ED%94%BC%EC%8A%A4%ED%83%80%EC%B9%98%EC%98%A4%EB%B9%BD%EC%8A%A4%EC%B9%98%EB%85%B8-SOFT-450x588.png"
        var image5: String =
            "https://paikdabang.com/wp-content/uploads/2018/05/%ED%90%81%EB%8B%B9%EC%B9%98%EB%85%B8_%EB%B0%94%EB%8B%90%EB%9D%BC-450x588.png"
        var image6: String =
            "https://paikdabang.com/wp-content/uploads/2018/05/%ED%90%81%EB%8B%B9%EC%B9%98%EB%85%B8_%EC%9B%90%EC%A1%B0-450x588.png"
        var image7: String =
            "https://paikdabang.com/wp-content/uploads/2018/05/%ED%90%81%EB%8B%B9%EC%B9%98%EB%85%B8_%EB%AF%B8%EC%88%AB%EA%B0%80%EB%A3%A8-450x588.png"
        var image8: String =
            "https://paikdabang.com/wp-content/uploads/2018/05/%EC%BF%A0%ED%82%A4%ED%81%AC%EB%9F%B0%EC%B9%98%EB%B9%BD%EC%8A%A4%EC%B9%98%EB%85%B8-SOFT-450x588.png"


        Glide.with(this)
            .load(
                "data:image/jpeg;base64,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b4tD92z0LPRAYHrPTfFofu2ehfcOGQRnMyCNp62saD5wFmIgCIiAIiIAiIgCIiAIiIAq5253YxVxdPS5YZzqRb+XJ3geS7tHirGRSjJxd0YaT3OUcawWooZOTqInRnoJHNPzTwK+6MU/qaXNbl83MzZxzbC2TLoXZr3zaWt2rqGuooqhhjljbI08Q4Aj8VA8Z3QUM5LoXyU56mkOZ9l2o8CFeq6ejKnTfIqKdtFyEGW/KZmcr5d7f3s1+ba/k5ejivpstB6rkcY3epw1/Jt1zOcPI9/09rh4KY1m5mqaf5VTE8fKDmn91rzukxL/AGvvP+lZnj1MWfQilKKY0kxdYVGccmOd5PNva2hPHiv3GWUwZD6ntfIOV8q+ewve+nG/BTWl3OVrvbJomDsLnfsFJMJ3M0rCHVFRJL8lto2+JHO/ELDqw6jIymaKjkqHiOKN0jzwa0En8OHerZ2K3T2InxCx6RANR/5T0/NCs3CMFp6JmSnhZGPkjU954lbFUyrN7aE407bnlFGGNDWgAAWAAsABwAA4L1RFSWBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAf/Z"
            )
            .into(binding.backdabang)
        Glide.with(this)
            .load(image1)
            .into(binding.ivMenu1)

        Glide.with(this)
            .load(image2)
            .into(binding.ivMenu2)
        Glide.with(this)
            .load(image3)
            .into(binding.ivMenu3)
        Glide.with(this)
            .load(image4)
            .into(binding.ivMenu4)
        Glide.with(this)
            .load(image5)
            .into(binding.ivMenu5)
        Glide.with(this)
            .load(image6)
            .into(binding.ivMenu6)
        Glide.with(this)
            .load(image7)
            .into(binding.ivMenu7)
        Glide.with(this)
            .load(image8)
            .into(binding.ivMenu8)


        var OneLayout: LinearLayout = binding.oneLayout
        var TwoLayout: LinearLayout = binding.twoLayout
        var ThreeLayout: LinearLayout = binding.threeLayout
        var FourLayout: LinearLayout = binding.fourLayout
        var FiveLayout: LinearLayout = binding.fiveLayout
        var SixLayout: LinearLayout = binding.sixLayout
        var SevenLayout: LinearLayout = binding.sevenLayout
        var EightLayout: LinearLayout = binding.eightLayout



        OneLayout.setOnClickListener {
            dialog(image1, drink[0], price[0])
        }

        TwoLayout.setOnClickListener {
            dialog(image2, drink[1], price[1])
        }

        ThreeLayout.setOnClickListener {
            dialog(image3, drink[2], price[2])
        }
        FourLayout.setOnClickListener {
            dialog(image4, drink[3], price[3])
        }
        FiveLayout.setOnClickListener {
            dialog(image5, drink[4], price[4])
        }
        SixLayout.setOnClickListener {
            dialog(image6, drink[5], price[5])
        }
        SevenLayout.setOnClickListener {
            dialog(image7, drink[6], price[6])
        }
        EightLayout.setOnClickListener {
            dialog(image8, drink[7], price[7])
        }


    }

    private fun dialog(image: String, drink: String, price: Int) {
        val dialog = Dialog(this)
        dialog.setCancelable(false)

        binding2.drink.setText(drink)
        binding2.price.setText(price.toString())

        Glide.with(this)
            .load(image)
            .into(binding2.dialogCommentImageview)

        if (binding2.root.getParent() != null)
            (binding2.root.getParent() as ViewGroup).removeView(binding2.root)
        dialog.setContentView(binding2.root)

        dialog.show()
        binding2.radio1.setOnClickListener {
            addOptions()
        }

        binding2.radio2.setOnClickListener {
            addOptions()
        }

        binding2.radio3.setOnClickListener {
            addOptions()
        }

        binding2.radio11.setOnClickListener {
//            binding2.option.setText("당도 : " +binding2.Ice3.text)
            addOptions()
        }

        binding2.radio12.setOnClickListener {
//            binding2.option.setText("당도 : " +binding2.suger2.text)
            addOptions()
        }

        binding2.radio13.setOnClickListener {
//            binding2.option.setText("당도 : " +binding2.suger3.text)
            addOptions()
        }

        binding2.radio14.setOnClickListener {
//            binding2.option.setText("당도 : " +binding2.suger4.text)
            addOptions()
        }

        binding2.radio15.setOnClickListener {
            addOptions()
        }


        binding2.cancelbutton.setOnClickListener {
            dialog.dismiss()

        }

        binding2.putmenu.setOnClickListener {

            dialog.dismiss()
            var total: Int = price + Integer.parseInt(binding.price.text.toString())
            totalPrice = total
            binding.price.setText(total.toString())
            binding.lastprice.setText(binding.price.text)

            createmenu(image, binding2.drink, binding2.price, total)
        }

    }

    private fun addOptions() {
        var msg = ""
        var isChecked1 = false
        if (binding2.radio1.isChecked) {
            msg = "얼음량 : " + binding2.Ice1.text
            isChecked1 = true
        } else if (binding2.radio2.isChecked) {
            msg = "얼음량 : " + binding2.Ice2.text
            isChecked1 = true
        } else if (binding2.radio3.isChecked) {
            msg = "얼음량 : " + binding2.Ice3.text
            isChecked1 = true
        }
        if (isChecked1) {
            msg += " / "
        }

        if (binding2.radio11.isChecked) {
            msg += "당도 : " + binding2.suger1.text
        } else if (binding2.radio12.isChecked) {
            msg += "당도 : " + binding2.suger2.text
        } else if (binding2.radio13.isChecked) {
            msg += "당도 : " + binding2.suger3.text
        } else if (binding2.radio14.isChecked) {
            msg += "당도 : " + binding2.suger4.text
        } else if (binding2.radio15.isChecked) {
            msg += "당도 : " + binding2.suger5.text
        }

        binding2.option.setText(msg)
    }

    private fun createmenu(image: String, drink1: TextView, price1: TextView, total1: Int) {

        val customLayout = layoutInflater.inflate(R.layout.activity_menu, null)
        val imageView: ImageView = customLayout.findViewById(R.id.drinkimage)
        Glide.with(this)
            .load(image)
            .into(imageView)
        val drink: TextView = customLayout.findViewById(R.id.drink)
        drink.setText(drink1.text)
        val option: TextView = customLayout.findViewById(R.id.option)
        option.setText(binding2.option.text)
        val price: TextView = customLayout.findViewById(R.id.price)
        price.setText(price1.text)
        binding.fulllayout.addView(customLayout)
        val minusbutton: ImageButton = customLayout.findViewById(R.id.minusbutton)
        val plusbutton: ImageButton = customLayout.findViewById(R.id.plusbutton)
        val cancelbutton : ImageButton = customLayout.findViewById(R.id.cancelbutton)
        val number: TextView = customLayout.findViewById(R.id.number)
        minusbutton.setOnClickListener {
            if (Integer.parseInt(number.text.toString()) == 1) {

            } else {
                val decrease: Int = Integer.parseInt(number.text.toString()) - 1
                number.setText(decrease.toString())
                val total: Int =
                    Integer.parseInt(price.text.toString()) - Integer.parseInt(price1.text.toString())
                price.setText(total.toString())

                val myPrice = price1.text.toString().toInt()
                totalPrice -= myPrice
                binding.price.text = totalPrice.toString()
                binding.lastprice.text = totalPrice.toString()
            }
        }
        plusbutton.setOnClickListener {
            val increase: Int = Integer.parseInt(number.text.toString()) + 1

            number.setText(increase.toString())
            val total: Int =
                Integer.parseInt(price1.text.toString()) * Integer.parseInt(number.text.toString())
            price.setText(total.toString())

            var temp: Int = total1 + Integer.parseInt(price1.text.toString())

            binding.price.setText(temp.toString())
            binding.lastprice.setText(temp.toString())

            val myPrice = price1.text.toString().toInt()
            totalPrice += myPrice
            binding.price.text = totalPrice.toString()
            binding.lastprice.text = totalPrice.toString()
        }
        cancelbutton.setOnClickListener{
            (customLayout.getParent() as ViewGroup).removeView(customLayout)


        }

    }
}

