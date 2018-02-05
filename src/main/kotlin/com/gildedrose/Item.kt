package com.gildedrose

class Item(name: String, sellIn: Int, quality: Int) : AbstractItem(name, sellIn, quality) {
    override fun updateQuality() {
        decreaseQuality()
        decreaseSellin()
        if (sellIn < 0) {
            decreaseQuality()
        }
    }
}