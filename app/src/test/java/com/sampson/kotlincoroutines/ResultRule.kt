package com.sampson.kotlincoroutines

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.math.BigInteger
import kotlin.jvm.Throws

class ResultRule : TestRule {
    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                FactorialNumber.result = BigInteger.ONE
                try {
                    base?.evaluate()
                } finally {
                    FactorialNumber.result = BigInteger.ONE
                }
            }
        }

    }
}