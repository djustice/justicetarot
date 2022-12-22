package com.djustice.tarot.spread

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.djustice.tarot.R
import com.djustice.tarot.card.Card
import com.djustice.tarot.card.CardUtil
import com.djustice.tarot.databinding.ActivityPastPresentFutureBinding
import kotlin.random.Random

class PastPresentFuture : Activity() {

    private lateinit var card1: Card
    private lateinit var card2: Card
    private lateinit var card3: Card

    private lateinit var card1animf: AnimatorSet
    private lateinit var card1animb: AnimatorSet
    private lateinit var card2animf: AnimatorSet
    private lateinit var card2animb: AnimatorSet
    private lateinit var card3animf: AnimatorSet
    private lateinit var card3animb: AnimatorSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = ActivityPastPresentFutureBinding.inflate(layoutInflater)

        var scale = resources.displayMetrics.scaledDensity
        v.ivPPF1.cameraDistance = 8000 * scale
        v.ivPPF1b.cameraDistance = 8000 * scale
        v.ivPPF2.cameraDistance = 8000 * scale
        v.ivPPF2b.cameraDistance = 8000 * scale
        v.ivPPF3.cameraDistance = 8000 * scale
        v.ivPPF3b.cameraDistance = 8000 * scale

        card1animf = AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet
        card1animb = AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet
        card2animf = AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet
        card2animb = AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet
        card3animf = AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet
        card3animb = AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet

        val num1 = Random.nextInt(0, 77)
        var num2 = Random.nextInt(0, 77)
        var num3 = Random.nextInt(0, 77)
        while (num2 == num1) { num2 = Random.nextInt(0,77) }
        while (num3 == num1) { num3 = Random.nextInt(0,77) }
        while (num3 == num2) { num3 = Random.nextInt(0,77) }

        val util = CardUtil(this)
        util.loadCards()

        card1 = util.cardList[num1]
        card2 = util.cardList[num2]
        card3 = util.cardList[num3]

        v.ivPPF1b.setOnClickListener{
            v.ivPPF1.setImageDrawable(AppCompatResources.getDrawable(this, card1.art))
            card1animf.setTarget(v.ivPPF1b)
            card1animb.setTarget(v.ivPPF1)
            card1animf.start()
            card1animb.start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivPPF1b.visibility = View.GONE
            }, 1000)
        }

        v.ivPPF1.setOnLongClickListener{
            util.showDetails(this, card1)
            return@setOnLongClickListener true
        }

        v.ivPPF2b.setOnClickListener{
            v.ivPPF2.setImageDrawable(AppCompatResources.getDrawable(this, card2.art))
            card2animf.setTarget(v.ivPPF2b)
            card2animb.setTarget(v.ivPPF2)
            card2animf.start()
            card2animb.start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivPPF2b.visibility = View.GONE
            }, 1000)
        }

        v.ivPPF2.setOnLongClickListener{
            util.showDetails(this, card2)
            return@setOnLongClickListener true
        }

        v.ivPPF3b.setOnClickListener{
            v.ivPPF3.setImageDrawable(AppCompatResources.getDrawable(this, card3.art))
            card3animf.setTarget(v.ivPPF3b)
            card3animb.setTarget(v.ivPPF3)
            card3animf.start()
            card3animb.start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivPPF3b.visibility = View.GONE
            }, 1000)
        }

        v.ivPPF3.setOnLongClickListener{
            util.showDetails(this, card3)
            return@setOnLongClickListener true
        }

        Toast.makeText(this, "Tap to flip - Hold to read", Toast.LENGTH_SHORT).show()

        setContentView(v.root)
    }
}