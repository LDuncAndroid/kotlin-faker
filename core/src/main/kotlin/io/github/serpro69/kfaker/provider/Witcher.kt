package io.github.serpro69.kfaker.provider

import io.github.serpro69.kfaker.*
import io.github.serpro69.kfaker.dictionary.*
import io.github.serpro69.kfaker.provider.unique.LocalUniqueDataProvider
import io.github.serpro69.kfaker.provider.unique.UniqueProviderDelegate

/**
 * [FakeDataProvider] implementation for [YamlCategory.GAMES] category.
 */
@Suppress("unused")
class Witcher internal constructor(fakerService: FakerService) : YamlFakeDataProvider<Witcher>(fakerService) {
    override val yamlCategory = YamlCategory.GAMES
    override val secondaryCategory: Category = Category.ofName("WITCHER")
    override val localUniqueDataProvider = LocalUniqueDataProvider<Witcher>()
    override val unique by UniqueProviderDelegate(localUniqueDataProvider)

    init {
        fakerService.load(yamlCategory, secondaryCategory)
    }

    fun characters() = resolve("witcher", "characters")
    fun witchers() = resolve("witcher", "witchers")
    fun schools() = resolve("witcher", "schools")
    fun locations() = resolve("witcher", "locations")
    fun quotes() = resolve("witcher", "quotes")
    fun monsters() = resolve("witcher", "monsters")
    fun signs() = resolve("witcher", "signs")
    fun potions() = resolve("witcher", "potions")
    fun books() = resolve("witcher", "books")
}
