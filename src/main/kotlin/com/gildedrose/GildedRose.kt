package com.gildedrose

class GildedRose(var items: Array<AbstractItem>) {

    fun updateQuality() {
        for (item in items) {
            item.updateQuality()
        }
    }

}

