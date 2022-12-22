package com.djustice.tarot.spread

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.djustice.tarot.R
import com.djustice.tarot.card.Card
import com.djustice.tarot.card.CardUtil
import com.djustice.tarot.databinding.ActivityNewYearBinding
import kotlin.random.Random
import kotlin.random.nextInt

class NewYear : Activity() {

    private lateinit var cards: Array<Card>
    private lateinit var cardAnimsFront: Array<AnimatorSet>
    private lateinit var cardAnimsBack: Array<AnimatorSet>
    private lateinit var nums: Array<Int?>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = ActivityNewYearBinding.inflate(layoutInflater)

        val scale = resources.displayMetrics.scaledDensity
        v.ivNY1.cameraDistance = 8000 * scale
        v.ivNY1b.cameraDistance = 8000 * scale
        v.ivNY2.cameraDistance = 8000 * scale
        v.ivNY2b.cameraDistance = 8000 * scale
        v.ivNY3.cameraDistance = 8000 * scale
        v.ivNY3b.cameraDistance = 8000 * scale
        v.ivNY4.cameraDistance = 8000 * scale
        v.ivNY4b.cameraDistance = 8000 * scale
        v.ivNY5.cameraDistance = 8000 * scale
        v.ivNY5b.cameraDistance = 8000 * scale
        v.ivNY6.cameraDistance = 8000 * scale
        v.ivNY6b.cameraDistance = 8000 * scale
        v.ivNY7.cameraDistance = 8000 * scale
        v.ivNY7b.cameraDistance = 8000 * scale
        v.ivNY8.cameraDistance = 8000 * scale
        v.ivNY8b.cameraDistance = 8000 * scale
        v.ivNY9.cameraDistance = 8000 * scale
        v.ivNY9b.cameraDistance = 8000 * scale
        v.ivNY10.cameraDistance = 8000 * scale
        v.ivNY10b.cameraDistance = 8000 * scale
        v.ivNY11.cameraDistance = 8000 * scale
        v.ivNY11b.cameraDistance = 8000 * scale
        v.ivNY12.cameraDistance = 8000 * scale
        v.ivNY12b.cameraDistance = 8000 * scale

        cardAnimsFront = Array(12) { AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet }
        cardAnimsBack = Array(12) { AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet }

        nums = arrayOfNulls<Int?>(12)

        for (i in 0..11) {
            nums[i] = Random.nextInt(0..77)
            if (i > 0 && nums[i] != null) {
                for (y in 0..i) {
                    if (i == y) continue
                    while (nums[i] == nums[y]) nums[i] = Random.nextInt(0..77)
                }
            }
        }

        val util = CardUtil(this)
        util.loadCards()

        cards = Array(12) { util.cardList[nums[it]!!] }

        v.ivNY1b.setOnClickListener{
            v.ivNY1.setImageDrawable(AppCompatResources.getDrawable(this, cards[0].art))
            cardAnimsFront[0].setTarget(v.ivNY1b)
            cardAnimsBack[0].setTarget(v.ivNY1)
            cardAnimsFront[0].start()
            cardAnimsBack[0].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY1b.visibility = View.GONE }, 1000)
        }

        v.ivNY1.setOnLongClickListener{
            util.showDetails(this, cards[0])
            return@setOnLongClickListener true
        }

        v.ivNY2b.setOnClickListener{
            v.ivNY2.setImageDrawable(AppCompatResources.getDrawable(this, cards[1].art))
            cardAnimsFront[1].setTarget(v.ivNY2b)
            cardAnimsBack[1].setTarget(v.ivNY2)
            cardAnimsFront[1].start()
            cardAnimsBack[1].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY2b.visibility = View.GONE }, 1000)
        }

        v.ivNY2.setOnLongClickListener{
            util.showDetails(this, cards[1])
            return@setOnLongClickListener true
        }

        v.ivNY3b.setOnClickListener{
            v.ivNY3.setImageDrawable(AppCompatResources.getDrawable(this, cards[2].art))
            cardAnimsFront[2].setTarget(v.ivNY3b)
            cardAnimsBack[2].setTarget(v.ivNY3)
            cardAnimsFront[2].start()
            cardAnimsBack[2].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY3b.visibility = View.GONE }, 1000)
        }

        v.ivNY3.setOnLongClickListener{
            util.showDetails(this, cards[2])
            return@setOnLongClickListener true
        }

        v.ivNY4b.setOnClickListener{
            v.ivNY4.setImageDrawable(AppCompatResources.getDrawable(this, cards[3].art))
            cardAnimsFront[3].setTarget(v.ivNY4b)
            cardAnimsBack[3].setTarget(v.ivNY4)
            cardAnimsFront[3].start()
            cardAnimsBack[3].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY4b.visibility = View.GONE }, 1000)
        }

        v.ivNY4.setOnLongClickListener{
            util.showDetails(this, cards[3])
            return@setOnLongClickListener true
        }

        v.ivNY5b.setOnClickListener{
            v.ivNY5.setImageDrawable(AppCompatResources.getDrawable(this, cards[4].art))
            cardAnimsFront[4].setTarget(v.ivNY5b)
            cardAnimsBack[4].setTarget(v.ivNY5)
            cardAnimsFront[4].start()
            cardAnimsBack[4].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY5b.visibility = View.GONE }, 1000)
        }

        v.ivNY5.setOnLongClickListener{
            util.showDetails(this, cards[4])
            return@setOnLongClickListener true
        }

        v.ivNY6b.setOnClickListener{
            v.ivNY6.setImageDrawable(AppCompatResources.getDrawable(this, cards[5].art))
            cardAnimsFront[5].setTarget(v.ivNY6b)
            cardAnimsBack[5].setTarget(v.ivNY6)
            cardAnimsFront[5].start()
            cardAnimsBack[5].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY6b.visibility = View.GONE }, 1000)
        }

        v.ivNY6.setOnLongClickListener{
            util.showDetails(this, cards[5])
            return@setOnLongClickListener true
        }

        v.ivNY7b.setOnClickListener{
            v.ivNY7.setImageDrawable(AppCompatResources.getDrawable(this, cards[6].art))
            cardAnimsFront[6].setTarget(v.ivNY7b)
            cardAnimsBack[6].setTarget(v.ivNY7)
            cardAnimsFront[6].start()
            cardAnimsBack[6].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY7b.visibility = View.GONE }, 1000)
        }

        v.ivNY7.setOnLongClickListener{
            util.showDetails(this, cards[6])
            return@setOnLongClickListener true
        }

        v.ivNY8b.setOnClickListener{
            v.ivNY8.setImageDrawable(AppCompatResources.getDrawable(this, cards[7].art))
            cardAnimsFront[7].setTarget(v.ivNY8b)
            cardAnimsBack[7].setTarget(v.ivNY8)
            cardAnimsFront[7].start()
            cardAnimsBack[7].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY8b.visibility = View.GONE }, 1000)
        }

        v.ivNY8.setOnLongClickListener{
            util.showDetails(this, cards[7])
            return@setOnLongClickListener true
        }

        v.ivNY9b.setOnClickListener{
            v.ivNY9.setImageDrawable(AppCompatResources.getDrawable(this, cards[8].art))
            cardAnimsFront[8].setTarget(v.ivNY9b)
            cardAnimsBack[8].setTarget(v.ivNY9)
            cardAnimsFront[8].start()
            cardAnimsBack[8].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY9b.visibility = View.GONE }, 1000)
        }

        v.ivNY9.setOnLongClickListener{
            util.showDetails(this, cards[8])
            return@setOnLongClickListener true
        }

        v.ivNY10b.setOnClickListener{
            v.ivNY10.setImageDrawable(AppCompatResources.getDrawable(this, cards[9].art))
            cardAnimsFront[9].setTarget(v.ivNY10b)
            cardAnimsBack[9].setTarget(v.ivNY10)
            cardAnimsFront[9].start()
            cardAnimsBack[9].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY10b.visibility = View.GONE }, 1000)
        }

        v.ivNY10.setOnLongClickListener{
            util.showDetails(this, cards[9])
            return@setOnLongClickListener true
        }

        v.ivNY11b.setOnClickListener{
            v.ivNY11.setImageDrawable(AppCompatResources.getDrawable(this, cards[10].art))
            cardAnimsFront[10].setTarget(v.ivNY11b)
            cardAnimsBack[10].setTarget(v.ivNY11)
            cardAnimsFront[10].start()
            cardAnimsBack[10].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY11b.visibility = View.GONE }, 1000)
        }

        v.ivNY11.setOnLongClickListener{
            util.showDetails(this, cards[10])
            return@setOnLongClickListener true
        }

        v.ivNY12b.setOnClickListener{
            v.ivNY12.setImageDrawable(AppCompatResources.getDrawable(this, cards[11].art))
            cardAnimsFront[11].setTarget(v.ivNY12b)
            cardAnimsBack[11].setTarget(v.ivNY12)
            cardAnimsFront[11].start()
            cardAnimsBack[11].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivNY12b.visibility = View.GONE }, 1000)
        }

        v.ivNY12.setOnLongClickListener{
            util.showDetails(this, cards[11])
            return@setOnLongClickListener true
        }

        Toast.makeText(this, "Tap to flip - Hold to read", Toast.LENGTH_SHORT).show()

        setContentView(v.root)
    }
}