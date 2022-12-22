package com.djustice.tarot.reference

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.djustice.tarot.R
import com.djustice.tarot.card.Card
import com.djustice.tarot.card.CardUtil

class DRDisksActivity : Activity() {

    private lateinit var d1: Button
    private lateinit var d2: Button
    private lateinit var d3: Button
    private lateinit var d4: Button
    private lateinit var d5: Button
    private lateinit var d6: Button
    private lateinit var d7: Button
    private lateinit var d8: Button
    private lateinit var d9: Button
    private lateinit var d10: Button
    private lateinit var d11: Button
    private lateinit var d12: Button
    private lateinit var d13: Button
    private lateinit var d14: Button

    private lateinit var util: CardUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drdisks)

        util = CardUtil(this)
        util.loadCards()

        val disksList: MutableList<Card> = mutableListOf()
        for ( i in 35..49) disksList.add(util.cardList[i])

        d1 = findViewById(R.id.DRd01Button)
        d1.setOnClickListener { util.showDetails(this, disksList[1]) }
        d2 = findViewById(R.id.DRd02Button)
        d2.setOnClickListener { util.showDetails(this, disksList[2]) }
        d3 = findViewById(R.id.DRd03Button)
        d3.setOnClickListener { util.showDetails(this, disksList[3]) }
        d4 = findViewById(R.id.DRd04Button)
        d4.setOnClickListener { util.showDetails(this, disksList[4]) }
        d5 = findViewById(R.id.DRd05Button)
        d5.setOnClickListener { util.showDetails(this, disksList[5]) }
        d6 = findViewById(R.id.DRd06Button)
        d6.setOnClickListener { util.showDetails(this, disksList[6]) }
        d7 = findViewById(R.id.DRd07Button)
        d7.setOnClickListener { util.showDetails(this, disksList[7]) }
        d8 = findViewById(R.id.DRd08Button)
        d8.setOnClickListener { util.showDetails(this, disksList[8]) }
        d9 = findViewById(R.id.DRd09Button)
        d9.setOnClickListener { util.showDetails(this, disksList[9]) }
        d10 = findViewById(R.id.DRd10Button)
        d10.setOnClickListener { util.showDetails(this, disksList[10]) }
        d11 = findViewById(R.id.DRd11Button)
        d11.setOnClickListener { util.showDetails(this, disksList[11]) }
        d12 = findViewById(R.id.DRd12Button)
        d12.setOnClickListener { util.showDetails(this, disksList[12]) }
        d13 = findViewById(R.id.DRd13Button)
        d13.setOnClickListener { util.showDetails(this, disksList[13]) }
        d14 = findViewById(R.id.DRd14Button)
        d14.setOnClickListener { util.showDetails(this, disksList[14]) }
    }
}