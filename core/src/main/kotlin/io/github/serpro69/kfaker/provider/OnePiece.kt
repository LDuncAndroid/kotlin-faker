package io.github.serpro69.kfaker.provider

import io.github.serpro69.kfaker.*
import io.github.serpro69.kfaker.dictionary.*
import io.github.serpro69.kfaker.provider.unique.LocalUniqueDataProvider
import io.github.serpro69.kfaker.provider.unique.UniqueProviderDelegate

/**
 * [FakeDataProvider] implementation for [YamlCategory.ONE_PIECE] category.
 */
@Suppress("unused")
class OnePiece internal constructor(fakerService: FakerService) : YamlFakeDataProvider<OnePiece>(fakerService) {
    override val yamlCategory = YamlCategory.ONE_PIECE
    override val localUniqueDataProvider = LocalUniqueDataProvider<OnePiece>()
    override val unique by UniqueProviderDelegate(localUniqueDataProvider)

    init {
        fakerService.load(yamlCategory)
    }

    fun characters() = resolve("characters")
    fun seas() = resolve("seas")
    fun islands() = resolve("islands")
    fun locations() = resolve("locations")
    fun quotes() = resolve("quotes")
    fun akumasNoMi() = resolve("akumas_no_mi")
}
