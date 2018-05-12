package tw.andyang.designpattern.facade

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

class JsonFacade {

    companion object {
        inline fun <reified T> deserialize(json: String): T {
            val clazz: Class<T> = T::class.java
//            using gson deserialize json
//            return Gson().fromJson(json, clazz)
//            using jackson deserialize json
            return ObjectMapper().registerKotlinModule().readValue(json, clazz)
        }

        fun <T> serialize(instance: T): String {
//            using gson serialize json
//            return Gson().toJson(instance)
//            using jackson serialize json
            return ObjectMapper().registerKotlinModule().writeValueAsString(instance)
        }
    }
}