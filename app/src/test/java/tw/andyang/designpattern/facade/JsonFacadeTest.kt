package tw.andyang.designpattern.facade

import org.junit.Assert
import org.junit.Test

class JsonFacadeTest {

    @Test
    fun test_JsonFacadeTest_serialize_and_deserialize() {
        val target = TestJsonModel("andyang", 30)
        val json = JsonFacade.serialize(target)
        val excepted: TestJsonModel = JsonFacade.deserialize(json)
        Assert.assertEquals(excepted, target)
    }
}