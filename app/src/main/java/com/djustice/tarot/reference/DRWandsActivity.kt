package com.djustice.tarot.reference

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.djustice.tarot.R
import com.djustice.tarot.card.Card
import com.djustice.tarot.card.CardUtil

class DRWandsActivity : Activity() {

    private lateinit var w1: Button
    private lateinit var w2: Button
    private lateinit var w3: Button
    private lateinit var w4: Button
    private lateinit var w5: Button
    private lateinit var w6: Button
    private lateinit var w7: Button
    private lateinit var w8: Button
    private lateinit var w9: Button
    private lateinit var w10: Button
    private lateinit var w11: Button
    private lateinit var w12: Button
    private lateinit var w13: Button
    private lateinit var w14: Button

    private lateinit var util: CardUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drwands)

        util = CardUtil(this)
        util.loadCards()

        val wandsList: MutableList<Card> = mutableListOf()
        for ( i in 63..77) wandsList.add(util.cardList[i])

        w1 = findViewById(R.id.DRw01Button)
        w1.setOnClickListener { util.showDetails(this, wandsList[1]) }
        w2 = findViewById(R.id.DRw02Button)
        w2.setOnClickListener { util.showDetails(this, wandsList[2]) }
        w3 = findViewById(R.id.DRw03Button)
        w3.setOnClickListener { util.showDetails(this, wandsList[3]) }
        w4 = findViewById(R.id.DRw04Button)
        w4.setOnClickListener { util.showDetails(this, wandsList[4]) }
        w5 = findViewById(R.id.DRw05Button)
        w5.setOnClickListener { util.showDetails(this, wandsList[5]) }
        w6 = findViewById(R.id.DRw06Button)
        w6.setOnClickListener { util.showDetails(this, wandsList[6]) }
        w7 = findViewById(R.id.DRw07Button)
        w7.setOnClickListener { util.showDetails(this, wandsList[7]) }
        w8 = findViewById(R.id.DRw08Button)
        w8.setOnClickListener { util.showDetails(this, wandsList[8]) }
        w9 = findViewById(R.id.DRw09Button)
        w9.setOnClickListener { util.showDetails(this, wandsList[9]) }
        w10 = findViewById(R.id.DRw10Button)
        w10.setOnClickListener { util.showDetails(this, wandsList[10]) }
        w11 = findViewById(R.id.DRw11Button)
        w11.setOnClickListener { util.showDetails(this, wandsList[11]) }
        w12 = findViewById(R.id.DRw12Button)
        w12.setOnClickListener { util.showDetails(this, wandsList[12]) }
        w13 = findViewById(R.id.DRw13Button)
        w13.setOnClickListener { util.showDetails(this, wandsList[13]) }
        w14 = findViewById(R.id.DRw14Button)
        w14.setOnClickListener { util.showDetails(this, wandsList[14]) }
    }
}