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
import com.djustice.tarot.databinding.ActivityRelationshipBinding
import kotlin.random.Random
import kotlin.random.nextInt

class Relationship : Activity() {

    private lateinit var cards: Array<Card>
    private lateinit var cardAnimsFront: Array<AnimatorSet>
    private lateinit var cardAnimsBack: Array<AnimatorSet>
    private lateinit var nums: Array<Int?>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = ActivityRelationshipBinding.inflate(layoutInflater)

        val scale = resources.displayMetrics.scaledDensity
        v.ivR1.cameraDistance = 8000 * scale
        v.ivR1b.cameraDistance = 8000 * scale
        v.ivR2.cameraDistance = 8000 * scale
        v.ivR2b.cameraDistance = 8000 * scale
        v.ivR3.cameraDistance = 8000 * scale
        v.ivR3b.cameraDistance = 8000 * scale
        v.ivR4.cameraDistance = 8000 * scale
        v.ivR4b.cameraDistance = 8000 * scale
        v.ivR5.cameraDistance = 8000 * scale
        v.ivR5b.cameraDistance = 8000 * scale
        v.ivR6.cameraDistance = 8000 * scale
        v.ivR6b.cameraDistance = 8000 * scale
        v.ivR7.cameraDistance = 8000 * scale
        v.ivR7b.cameraDistance = 8000 * scale

        cardAnimsFront = Array(7) { AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet }
        cardAnimsBack = Array(7) { AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet }

        nums = arrayOfNulls<Int?>(7)

        for (i in 0..6) {
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

        cards = Array(7) {
            util.cardList[nums[it]!!]
        }
        
        v.ivR1b.setOnClickListener{
            v.ivR1.setImageDrawable(AppCompatResources.getDrawable(this, cards[0].art))
            cardAnimsFront[0].setTarget(v.ivR1b)
            cardAnimsBack[0].setTarget(v.ivR1)
            cardAnimsFront[0].start()
            cardAnimsBack[0].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivR1b.visibility = View.GONE }, 1000)
        }

        v.ivR1.setOnLongClickListener{
            util.showDetails(this, cards[0])
            return@setOnLongClickListener true
        }

        v.ivR2b.setOnClickListener{
            v.ivR2.setImageDrawable(AppCompatResources.getDrawable(this, cards[1].art))
            cardAnimsFront[1].setTarget(v.ivR2b)
            cardAnimsBack[1].setTarget(v.ivR2)
            cardAnimsFront[1].start()
            cardAnimsBack[1].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivR2b.visibility = View.GONE }, 1000)
        }

        v.ivR2.setOnLongClickListener{
            util.showDetails(this, cards[1])
            return@setOnLongClickListener true
        }

        v.ivR3b.setOnClickListener{
            v.ivR3.setImageDrawable(AppCompatResources.getDrawable(this, cards[2].art))
            cardAnimsFront[2].setTarget(v.ivR3b)
            cardAnimsBack[2].setTarget(v.ivR3)
            cardAnimsFront[2].start()
            cardAnimsBack[2].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivR3b.visibility = View.GONE }, 1000)
        }

        v.ivR3.setOnLongClickListener{
            util.showDetails(this, cards[2])
            return@setOnLongClickListener true
        }

        v.ivR4b.setOnClickListener{
            v.ivR4.setImageDrawable(AppCompatResources.getDrawable(this, cards[3].art))
            cardAnimsFront[3].setTarget(v.ivR4b)
            cardAnimsBack[3].setTarget(v.ivR4)
            cardAnimsFront[3].start()
            cardAnimsBack[3].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivR4b.visibility = View.GONE }, 1000)
        }

        v.ivR4.setOnLongClickListener{
            util.showDetails(this, cards[3])
            return@setOnLongClickListener true
        }

        v.ivR5b.setOnClickListener{
            v.ivR5.setImageDrawable(AppCompatResources.getDrawable(this, cards[4].art))
            cardAnimsFront[4].setTarget(v.ivR5b)
            cardAnimsBack[4].setTarget(v.ivR5)
            cardAnimsFront[4].start()
            cardAnimsBack[4].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivR5b.visibility = View.GONE }, 1000)
        }

        v.ivR5.setOnLongClickListener{
            util.showDetails(this, cards[4])
            return@setOnLongClickListener true
        }

        v.ivR6b.setOnClickListener{
            v.ivR6.setImageDrawable(AppCompatResources.getDrawable(this, cards[5].art))
            cardAnimsFront[5].setTarget(v.ivR6b)
            cardAnimsBack[5].setTarget(v.ivR6)
            cardAnimsFront[5].start()
            cardAnimsBack[5].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivR6b.visibility = View.GONE }, 1000)
        }

        v.ivR6.setOnLongClickListener{
            util.showDetails(this, cards[5])
            return@setOnLongClickListener true
        }

        v.ivR7b.setOnClickListener{
            v.ivR7.setImageDrawable(AppCompatResources.getDrawable(this, cards[6].art))
            cardAnimsFront[6].setTarget(v.ivR7b)
            cardAnimsBack[6].setTarget(v.ivR7)
            cardAnimsFront[6].start()
            cardAnimsBack[6].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivR7b.visibility = View.GONE }, 1000)
        }

        v.ivR7.setOnLongClickListener{
            util.showDetails(this, cards[6])
            return@setOnLongClickListener true
        }

        Toast.makeText(this, "Tap to flip - Hold to read", Toast.LENGTH_SHORT).show()

        setContentView(v.root)
    }
}