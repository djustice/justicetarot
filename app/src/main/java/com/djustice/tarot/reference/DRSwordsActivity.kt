package com.djustice.tarot.reference

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.djustice.tarot.R
import com.djustice.tarot.card.Card
import com.djustice.tarot.card.CardUtil

class DRSwordsActivity : Activity() {

    private lateinit var s1: Button
    private lateinit var s2: Button
    private lateinit var s3: Button
    private lateinit var s4: Button
    private lateinit var s5: Button
    private lateinit var s6: Button
    private lateinit var s7: Button
    private lateinit var s8: Button
    private lateinit var s9: Button
    private lateinit var s10: Button
    private lateinit var s11: Button
    private lateinit var s12: Button
    private lateinit var s13: Button
    private lateinit var s14: Button

    private lateinit var util: CardUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drswords)

        util = CardUtil(this)
        util.loadCards()

        val swordsList: MutableList<Card> = mutableListOf()
        for ( i in 49..63) swordsList.add(util.cardList[i])

        s1 = findViewById(R.id.DRs01Button)
        s1.setOnClickListener { util.showDetails(this, swordsList[1]) }
        s2 = findViewById(R.id.DRs02Button)
        s2.setOnClickListener { util.showDetails(this, swordsList[2]) }
        s3 = findViewById(R.id.DRs03Button)
        s3.setOnClickListener { util.showDetails(this, swordsList[3]) }
        s4 = findViewById(R.id.DRs04Button)
        s4.setOnClickListener { util.showDetails(this, swordsList[4]) }
        s5 = findViewById(R.id.DRs05Button)
        s5.setOnClickListener { util.showDetails(this, swordsList[5]) }
        s6 = findViewById(R.id.DRs06Button)
        s6.setOnClickListener { util.showDetails(this, swordsList[6]) }
        s7 = findViewById(R.id.DRs07Button)
        s7.setOnClickListener { util.showDetails(this, swordsList[7]) }
        s8 = findViewById(R.id.DRs08Button)
        s8.setOnClickListener { util.showDetails(this, swordsList[8]) }
        s9 = findViewById(R.id.DRs09Button)
        s9.setOnClickListener { util.showDetails(this, swordsList[9]) }
        s10 = findViewById(R.id.DRs10Button)
        s10.setOnClickListener { util.showDetails(this, swordsList[10]) }
        s11 = findViewById(R.id.DRs11Button)
        s11.setOnClickListener { util.showDetails(this, swordsList[11]) }
        s12 = findViewById(R.id.DRs12Button)
        s12.setOnClickListener { util.showDetails(this, swordsList[12]) }
        s13 = findViewById(R.id.DRs13Button)
        s13.setOnClickListener { util.showDetails(this, swordsList[13]) }
        s14 = findViewById(R.id.DRs14Button)
        s14.setOnClickListener { util.showDetails(this, swordsList[14]) }
    }
}