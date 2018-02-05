package com.gildedrose

/**
 * <p>ConjuredItem</p>
 */
class ConjuredItem(name: String, sellIn: Int, quality: Int) : AbstractItem(name, sellIn, quality) {
    override fun updateQuality() {
        decreaseQuality()
        decreaseSellin()
        if (sellIn < 0) {
            decreaseQuality()
        }
        // TODO Modifier pour adapter aux nouvelles règles métier
    }

}