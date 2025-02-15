package io.github.serpro69.kfaker.provider

import io.github.serpro69.kfaker.faker
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldMatch

class AddressIT : DescribeSpec({
    describe("Address Provider") {
        val address: (locale: String) -> Address = { faker { fakerConfig { locale = it } }.address }

        context("nb-NO locale") {
            it("city() does NOT throw NoSuchElementException") {
                shouldNotThrow<NoSuchElementException> { address("nb-NO").city() }
            }
        }

        context("vi locale") {
            it("city() does NOT throw NoSuchElementException") {
                shouldNotThrow<NoSuchElementException> { address("vi").city() }
            }
        }

        context("lv locale") {
            it("city() does NOT throw NoSuchElementException") {
                shouldNotThrow<NoSuchElementException> { address("lv").city() }
            }
        }

        context("nl locale") {
            it("should generate a valid postcode") {
                address("nl").postcode() shouldMatch Regex("""[1-9]\d{3} \w{2}""")
            }
        }

        context("en-SG locale") {
            it("should generate a valid streetName") {
                address("en-SG").streetName() shouldNotBe ""
            }
        }

        context("ar locale") {
            it("should generate a valid streetName") {
                address("ar").streetName() shouldNotBe ""
            }
        }

        context("fr locale") {
            it("#138 Parameter 'zip_code' not found in 'ADDRESS' category for 'fr' locale") {
                address("fr").fullAddress() shouldNotBe ""
                address("fr").fullAddress() shouldContain Regex("""\d{5}""")
            }
        }
    }
})
