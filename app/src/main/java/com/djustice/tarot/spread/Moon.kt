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
import com.djustice.tarot.databinding.ActivityMoonBinding
import kotlin.random.Random
import kotlin.random.nextInt

class Moon : Activity() {

    private lateinit var cards: Array<Card>
    private lateinit var cardAnimsFront: Array<AnimatorSet>
    private lateinit var cardAnimsBack: Array<AnimatorSet>
    private lateinit var nums: Array<Int?>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = ActivityMoonBinding.inflate(layoutInflater)
        
        val scale = resources.displayMetrics.scaledDensity
        v.ivM1.cameraDistance = 8000 * scale
        v.ivM1b.cameraDistance = 8000 * scale
        v.ivM2.cameraDistance = 8000 * scale
        v.ivM2b.cameraDistance = 8000 * scale
        v.ivM3.cameraDistance = 8000 * scale
        v.ivM3b.cameraDistance = 8000 * scale
        v.ivM4.cameraDistance = 8000 * scale
        v.ivM4b.cameraDistance = 8000 * scale
        v.ivM5.cameraDistance = 8000 * scale
        v.ivM5b.cameraDistance = 8000 * scale
        v.ivM6.cameraDistance = 8000 * scale
        v.ivM6b.cameraDistance = 8000 * scale

        cardAnimsFront = Array<AnimatorSet>(6) { AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet }
        cardAnimsBack = Array<AnimatorSet>(6) { AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet }

        nums = arrayOfNulls<Int?>(6)

        for (i in 0..5) {
            nums[i] = Random.nextInt(0..77)
            if (i > 0 && nums[i] != null) {
                for (y in 0..i) {
                    if (i == y) continue
                    while (nums[i] == nums[y]) {
                        nums[i] = Random.nextInt(0..77)
                    }
                }
            }
        }

        val util = CardUtil(this)
        util.loadCards()

        cards = Array(6) {
            util.cardList[nums[it]!!]
        }

        v.ivM1b.setOnClickListener{
            v.ivM1.setImageDrawable(AppCompatResources.getDrawable(this, cards[0].art))
            cardAnimsFront[0].setTarget(v.ivM1b)
            cardAnimsBack[0].setTarget(v.ivM1)
            cardAnimsFront[0].start()
            cardAnimsBack[0].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivM1b.visibility = View.GONE }, 1000)
        }

        v.ivM1.setOnLongClickListener{
            util.showDetails(this, cards[0])
            return@setOnLongClickListener true
        }

        v.ivM2b.setOnClickListener{
            v.ivM2.setImageDrawable(AppCompatResources.getDrawable(this, cards[1].art))
            cardAnimsFront[1].setTarget(v.ivM2b)
            cardAnimsBack[1].setTarget(v.ivM2)
            cardAnimsFront[1].start()
            cardAnimsBack[1].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivM2b.visibility = View.GONE }, 1000)
        }

        v.ivM2.setOnLongClickListener{
            util.showDetails(this, cards[1])
            return@setOnLongClickListener true
        }

        v.ivM3b.setOnClickListener{
            v.ivM3.setImageDrawable(AppCompatResources.getDrawable(this, cards[2].art))
            cardAnimsFront[2].setTarget(v.ivM3b)
            cardAnimsBack[2].setTarget(v.ivM3)
            cardAnimsFront[2].start()
            cardAnimsBack[2].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivM3b.visibility = View.GONE }, 1000)
        }

        v.ivM3.setOnLongClickListener{
            util.showDetails(this, cards[2])
            return@setOnLongClickListener true
        }

        v.ivM4b.setOnClickListener{
            v.ivM4.setImageDrawable(AppCompatResources.getDrawable(this, cards[3].art))
            cardAnimsFront[3].setTarget(v.ivM4b)
            cardAnimsBack[3].setTarget(v.ivM4)
            cardAnimsFront[3].start()
            cardAnimsBack[3].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivM4b.visibility = View.GONE }, 1000)
        }

        v.ivM4.setOnLongClickListener{
            util.showDetails(this, cards[3])
            return@setOnLongClickListener true
        }

        v.ivM5b.setOnClickListener{
            v.ivM5.setImageDrawable(AppCompatResources.getDrawable(this, cards[4].art))
            cardAnimsFront[4].setTarget(v.ivM5b)
            cardAnimsBack[4].setTarget(v.ivM5)
            cardAnimsFront[4].start()
            cardAnimsBack[4].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivM5b.visibility = View.GONE }, 1000)
        }

        v.ivM5.setOnLongClickListener{
            util.showDetails(this, cards[4])
            return@setOnLongClickListener true
        }

        v.ivM6b.setOnClickListener{
            v.ivM6.setImageDrawable(AppCompatResources.getDrawable(this, cards[5].art))
            cardAnimsFront[5].setTarget(v.ivM6b)
            cardAnimsBack[5].setTarget(v.ivM6)
            cardAnimsFront[5].start()
            cardAnimsBack[5].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivM6b.visibility = View.GONE }, 1000)
        }

        v.ivM6.setOnLongClickListener{
            util.showDetails(this, cards[5])
            return@setOnLongClickListener true
        }

        Toast.makeText(this, "Tap to flip - Hold to read", Toast.LENGTH_SHORT).show()

        setContentView(v.root)
    }
}