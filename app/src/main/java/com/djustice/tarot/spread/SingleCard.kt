package com.djustice.tarot.spread

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.djustice.tarot.R
import com.djustice.tarot.card.Card
import com.djustice.tarot.card.CardUtil
import com.djustice.tarot.databinding.ActivitySingleCardBinding
import kotlin.random.Random

class SingleCard : Activity() {

    private lateinit var card1: Card

    private lateinit var card1_frontAnim: AnimatorSet
    private lateinit var card1_backAnim: AnimatorSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val v = ActivitySingleCardBinding.inflate(layoutInflater)

        var scale = resources.displayMetrics.scaledDensity
        v.ivSingleCard1.cameraDistance = 8000 * scale
        v.ivSingleCard1b.cameraDistance = 8000 * scale

        card1_frontAnim = AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet
        card1_backAnim = AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet

        val num = Random.nextInt(0, 77)
        val util = CardUtil(this)
        util.loadCards()
        card1 = util.cardList[num]

        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

        } else {
            v.ivSingleCard1.visibility = View.VISIBLE
            v.ivSingleCard1b.layoutParams.height = v.ivSingleCard1.height
            v.ivSingleCard1b.requestLayout()
            v.ivSingleCard1.visibility = View.GONE
        }

        v.ivSingleCard1b.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.card_back))

        v.ivSingleCard1b.setOnClickListener{
            v.ivSingleCard1.setImageDrawable(AppCompatResources.getDrawable(this, card1.art))
            v.ivSingleCard1.visibility = View.VISIBLE
            card1_frontAnim.setTarget(v.ivSingleCard1b)
            card1_backAnim.setTarget(v.ivSingleCard1)
            card1_frontAnim.start()
            card1_backAnim.start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivSingleCard1b.visibility = View.GONE
            }, 1000)
        }

        v.ivSingleCard1.setOnLongClickListener{
            util.showDetails(this, card1)
            return@setOnLongClickListener true
        }

        Toast.makeText(this, "Tap to flip - Hold to read", Toast.LENGTH_SHORT).show()

        setContentView(v.root)
    }
}