package com.gildedrose

/**
 * <p>BackstageItem</p>
 */
class BackstageItem(name: String, sellIn: Int, quality: Int) : AbstractItem(name, sellIn, quality) {
    override fun updateQuality() {
        increaseQuality()
        if (sellIn < 11) {
            increaseQuality()
        }
        if (sellIn < 6) {
            increaseQuality()
        }
        decreaseSellin()
        if (sellIn < 0) {
            quality = 0
        }
    }

}