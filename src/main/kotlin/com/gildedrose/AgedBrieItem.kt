package com.gildedrose

/**
 * <p>AgedBrieItem</p>
 */
class AgedBrieItem(name: String, sellIn: Int, quality: Int) : AbstractItem(name, sellIn, quality) {
    override fun updateQuality() {
        increaseQuality()
        decreaseSellin()
        if (sellIn < 0) {
            increaseQuality()
        }
    }
}