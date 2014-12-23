package net.koofr

import org.scalatest._

class MimemapTest extends FunSpec with Matchers {

  describe("Mimemap") {

    val mimeMap = Mimemap()

    it("should return mimetype for .mp4") {
      mimeMap("video.mp4") should equal ("video/mp4")
    }

    it("should return mimetype for .JPG") {
      mimeMap("image.JPG") should equal ("image/jpeg")
    }

    it("should return mimetype for .JPEG") {
      mimeMap("image.JPEG") should equal ("image/jpeg")
    }

    it("should return mimetype for .scala") {
      mimeMap("video.scala") should equal ("text/x-scala")
    }

    it("should return default mimetype for unknown extension") {
      mimeMap("file.unknown") should equal ("application/octet-stream")
    }

    it("should return custom mimetype for unknown extension") {
      mimeMap("file.unknown", "application/x-unknown") should equal ("application/x-unknown")
    }

    it("should return default mimetype for file without extension") {
      mimeMap("file") should equal ("application/octet-stream")
    }

    it("should return custom mimetype for file without extension") {
      mimeMap("file", "application/x-custom") should equal ("application/x-custom")
    }

  }

}
