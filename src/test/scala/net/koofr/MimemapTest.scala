import org.scalatest.Spec
import org.scalatest.matchers.MustMatchers

import net.koofr.Mimemap

class MimemapTest extends Spec with MustMatchers {

  describe("Mimemap") {

    val mimeMap = Mimemap()

    it("should return mimetype for .mp4") {
      mimeMap("video.mp4") must equal ("video/mp4")
    }

    it("should return mimetype for .scala") {
      mimeMap("video.scala") must equal ("text/x-scala")
    }

    it("should return default mimetype for unknown extension") {
      mimeMap("file.unknown") must equal ("application/octet-stream")
    }

    it("should return custom mimetype for unknown extension") {
      mimeMap("file.unknown", "application/x-unknown") must equal ("application/x-unknown")
    }

    it("should return default mimetype for file without extension") {
      mimeMap("file") must equal ("application/octet-stream")
    }

    it("should return custom mimetype for file without extension") {
      mimeMap("file", "application/x-custom") must equal ("application/x-custom")
    }

  }

}
