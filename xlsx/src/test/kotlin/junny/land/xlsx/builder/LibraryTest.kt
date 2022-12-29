package junny.land.xlsx.builder

import junny.land.xlsx.builder.output.Type
import junny.land.xlsx.builder.type.ExtractType
import junny.land.xlsx.samples.SampleKt
import org.junit.jupiter.api.Test
import java.io.OutputStream

class LibraryTest {
    val lists = listOf(
        SampleKt("junny", 25, 1),
        SampleKt(age = 26, noAnno = 2),
        SampleKt("junny3", 27),
    )

    @Test
    fun extractTest() {
        val build= Library.create(lists)
            .classType(SampleKt::class.java)
            .type(ExtractType.CSV)
            .name("jay")
            .temporary()
            .output(Type.BYTE)
            .path("./")
            .build<ByteArray>()

        println("build = ${build}")
    }
    @Test
    fun extractTest2() {
        val build= Library.create(lists)
            .classType(SampleKt::class.java)
            .type(ExtractType.CSV)
            .name("jay")
            .temporary()
            .output(Type.OUTPUT_STEAM)
            .path("./")
            .build<OutputStream>()

        println("build = ${build}")
    }

}