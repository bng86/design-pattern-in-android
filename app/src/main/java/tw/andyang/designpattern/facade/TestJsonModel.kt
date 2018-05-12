package tw.andyang.designpattern.facade

data class TestJsonModel(
        val name: String,
        val age: Int
) {
    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}