package domainTest

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe

class TestDomain : StringSpec(
    {
        "a simple test" {
            true shouldNotBe false
        }
    },
)
