package io.github.serpro69.kfaker.provider

import io.github.serpro69.kfaker.*
import io.github.serpro69.kfaker.dictionary.*
import io.github.serpro69.kfaker.provider.unique.LocalUniqueDataProvider
import io.github.serpro69.kfaker.provider.unique.UniqueProviderDelegate

/**
 * [FakeDataProvider] implementation for [YamlCategory.INTERNET] category.
 */
@Suppress("unused")
class Internet internal constructor(fakerService: FakerService) : YamlFakeDataProvider<Internet>(fakerService) {
    override val yamlCategory = YamlCategory.INTERNET
    override val localUniqueDataProvider = LocalUniqueDataProvider<Internet>()
    override val unique by UniqueProviderDelegate(localUniqueDataProvider)

    init {
        fakerService.load(yamlCategory)
    }

    fun domain() = resolve("free_email")

    @JvmOverloads
    fun email(name: String = ""): String {
        val localName = if (name.trim() == "") {
            fakerService.faker.name.name()
                .replace(".", "")
                .replace(" ", ".")
                .lowercase()
        } else name.replace(" ", "")

        return "$localName@${domain()}"
    }

    @JvmOverloads
    fun safeEmail(name: String = "") = "${email(name).substringBeforeLast(".")}.test"

    fun slug(): String = resolve("slug")

    fun domainSuffix() = resolve("domain_suffix")
    fun userAgent(browserType: String) = resolve("user_agent", browserType.lowercase())
}
