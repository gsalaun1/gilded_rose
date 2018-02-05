package com.gildedrose

import org.junit.Test
import kotlin.test.assertEquals

class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("fixme", app.items[0].name)

    }

    @Test
    fun `legacy and new app should update the same way`() {
        val itemsLegacy = arrayOf(Item("+5 Dexterity Vest", 10, 20), //
                Item("Aged Brie", 2, 0), //
                Item("Elixir of the Mongoose", 5, 7), //
                Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                Item("Sulfuras, Hand of Ragnaros", -1, 80),
                Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                Item("Conjured Mana Cake", 3, 6))
        val items = arrayOf(Item("+5 Dexterity Vest", 10, 20), //
                Item("Aged Brie", 2, 0), //
                Item("Elixir of the Mongoose", 5, 7), //
                Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                Item("Sulfuras, Hand of Ragnaros", -1, 80),
                Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                Item("Conjured Mana Cake", 3, 6))
        val appLegacy = GildedRoseLegacy(itemsLegacy)
        val app = GildedRose(items)

        for(i in 1..500){
            appLegacy.updateQuality()
            app.updateQuality()
            for((item,itemLegacy) in items.zip(itemsLegacy)){
                assertEquals(item,itemLegacy)
            }
        }


    }

}


