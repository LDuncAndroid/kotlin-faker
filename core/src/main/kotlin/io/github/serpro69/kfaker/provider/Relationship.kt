package io.github.serpro69.kfaker.provider

import io.github.serpro69.kfaker.*
import io.github.serpro69.kfaker.dictionary.*
import io.github.serpro69.kfaker.provider.unique.LocalUniqueDataProvider
import io.github.serpro69.kfaker.provider.unique.UniqueProviderDelegate

/**
 * [FakeDataProvider] implementation for [YamlCategory.RELATIONSHIP] category.
 */
@Suppress("unused")
class Relationship internal constructor(fakerService: FakerService) : YamlFakeDataProvider<Relationship>(fakerService) {
    override val yamlCategory = YamlCategory.RELATIONSHIP
    override val localUniqueDataProvider = LocalUniqueDataProvider<Relationship>()
    override val unique by UniqueProviderDelegate(localUniqueDataProvider)

    init {
        fakerService.load(yamlCategory)
    }

    fun familialDirect() = resolve("familial", "direct")
    fun familialExtended() = resolve("familial", "extended")
    fun familial() = resolve("familial", "")
    fun inLaw() = resolve("in_law")
    fun spouse() = resolve("spouse")
    fun parent() = resolve("parent")
    fun sibling() = resolve("sibling")
}
