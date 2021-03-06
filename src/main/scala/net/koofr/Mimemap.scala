package net.koofr

import scala.io.Source

object Mimemap {

  def apply() = new Mimemap

}

class Mimemap {

  def apply(fileName: String, default: String = DEFAULT): String = {
    val ext = getExtension(fileName)
    mimeMap.get(ext).getOrElse(default)
  }

  // private

  val DEFAULT = "application/octet-stream"

  // knownMimes and knownFiles are derived from Python's mimetypes library

  val knownMimes = Seq(
    "3gp" -> "video/3gpp",
    "3gpp" -> "video/3gpp",
    "7z" -> "application/x-7z-compressed",
    "a" -> "application/octet-stream",
    "ai" -> "application/postscript",
    "aif" -> "audio/x-aiff",
    "aifc" -> "audio/x-aiff",
    "aiff" -> "audio/x-aiff",
    "asf" -> "video/x-ms-asf",
    "asx" -> "video/x-ms-asf",
    "atom" -> "application/atom+xml",
    "au" -> "audio/basic",
    "avi" -> "video/x-msvideo",
    "bat" -> "text/plain",
    "bcpio" -> "application/x-bcpio",
    "bin" -> "application/octet-stream",
    "bmp" -> "image/x-ms-bmp",
    "c" -> "text/plain",
    "cco" -> "application/x-cocoa",
    "cdf" -> "application/x-cdf",
    "cpio" -> "application/x-cpio",
    "crt" -> "application/x-x509-ca-cert",
    "csh" -> "application/x-csh",
    "css" -> "text/css",
    "deb" -> "application/octet-stream",
    "der" -> "application/x-x509-ca-cert",
    "dll" -> "application/octet-stream",
    "dmg" -> "application/octet-stream",
    "doc" -> "application/msword",
    "docx" -> "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
    "dot" -> "application/msword",
    "dvi" -> "application/x-dvi",
    "ear" -> "application/java-archive",
    "eml" -> "message/rfc822",
    "eot" -> "application/vnd.ms-fontobject",
    "eps" -> "application/postscript",
    "etx" -> "text/x-setext",
    "exe" -> "application/octet-stream",
    "flv" -> "video/x-flv",
    "gif" -> "image/gif",
    "gtar" -> "application/x-gtar",
    "gz" -> "application/gzip",
    "h" -> "text/plain",
    "hdf" -> "application/x-hdf",
    "hqx" -> "application/mac-binhex40",
    "htc" -> "text/x-component",
    "htm" -> "text/html",
    "html" -> "text/html",
    "ico" -> "image/x-icon",
    "ief" -> "image/ief",
    "img" -> "application/octet-stream",
    "iso" -> "application/octet-stream",
    "jad" -> "text/vnd.sun.j2me.app-descriptor",
    "jar" -> "application/java-archive",
    "jardiff" -> "application/x-java-archive-diff",
    "jng" -> "image/x-jng",
    "jnlp" -> "application/x-java-jnlp-file",
    "jpe" -> "image/jpeg",
    "jpeg" -> "image/jpeg",
    "jpg" -> "image/jpeg",
    "js" -> "application/javascript",
    "kar" -> "audio/midi",
    "kml" -> "application/vnd.google-earth.kml+xml",
    "kmz" -> "application/vnd.google-earth.kmz",
    "ksh" -> "text/plain",
    "latex" -> "application/x-latex",
    "m1v" -> "video/mpeg",
    "m4a" -> "audio/x-m4a",
    "m4v" -> "video/x-m4v",
    "man" -> "application/x-troff-man",
    "me" -> "application/x-troff-me",
    "mht" -> "message/rfc822",
    "mhtml" -> "message/rfc822",
    "mid" -> "audio/midi",
    "midi" -> "audio/midi",
    "mif" -> "application/x-mif",
    "mml" -> "text/mathml",
    "mng" -> "video/x-mng",
    "mov" -> "video/quicktime",
    "movie" -> "video/x-sgi-movie",
    "mp2" -> "audio/mpeg",
    "mp3" -> "audio/mpeg",
    "mp4" -> "video/mp4",
    "mpa" -> "video/mpeg",
    "mpe" -> "video/mpeg",
    "mpeg" -> "video/mpeg",
    "mpg" -> "video/mpeg",
    "ms" -> "application/x-troff-ms",
    "msi" -> "application/octet-stream",
    "msm" -> "application/octet-stream",
    "msp" -> "application/octet-stream",
    "nc" -> "application/x-netcdf",
    "nws" -> "message/rfc822",
    "o" -> "application/octet-stream",
    "obj" -> "application/octet-stream",
    "oda" -> "application/oda",
    "ogg" -> "audio/ogg",
    "p12" -> "application/x-pkcs12",
    "p7c" -> "application/pkcs7-mime",
    "pbm" -> "image/x-portable-bitmap",
    "pct" -> "image/pict",
    "pdb" -> "application/x-pilot",
    "pdf" -> "application/pdf",
    "pem" -> "application/x-x509-ca-cert",
    "pfx" -> "application/x-pkcs12",
    "pgm" -> "image/x-portable-graymap",
    "pic" -> "image/pict",
    "pict" -> "image/pict",
    "pl" -> "text/plain",
    "pm" -> "application/x-perl",
    "png" -> "image/png",
    "pnm" -> "image/x-portable-anymap",
    "pot" -> "application/vnd.ms-powerpoint",
    "ppa" -> "application/vnd.ms-powerpoint",
    "ppm" -> "image/x-portable-pixmap",
    "pps" -> "application/vnd.ms-powerpoint",
    "ppt" -> "application/vnd.ms-powerpoint",
    "pptx" -> "application/vnd.openxmlformats-officedocument.presentationml.presentation",
    "prc" -> "application/x-pilot",
    "ps" -> "application/postscript",
    "pwz" -> "application/vnd.ms-powerpoint",
    "py" -> "text/x-python",
    "pyc" -> "application/x-python-code",
    "pyo" -> "application/x-python-code",
    "qt" -> "video/quicktime",
    "ra" -> "audio/x-pn-realaudio",
    "ram" -> "application/x-pn-realaudio",
    "rar" -> "application/x-rar-compressed",
    "ras" -> "image/x-cmu-raster",
    "rdf" -> "application/xml",
    "rgb" -> "image/x-rgb",
    "roff" -> "application/x-troff",
    "rpm" -> "application/x-redhat-package-manager",
    "rss" -> "application/rss+xml",
    "rtf" -> "application/rtf",
    "rtx" -> "text/richtext",
    "run" -> "application/x-makeself",
    "sea" -> "application/x-sea",
    "sgm" -> "text/x-sgml",
    "sgml" -> "text/x-sgml",
    "sh" -> "application/x-sh",
    "shar" -> "application/x-shar",
    "shtml" -> "text/html",
    "sit" -> "application/x-stuffit",
    "snd" -> "audio/basic",
    "so" -> "application/octet-stream",
    "src" -> "application/x-wais-source",
    "sv4cpio" -> "application/x-sv4cpio",
    "sv4crc" -> "application/x-sv4crc",
    "svg" -> "image/svg+xml",
    "svgz" -> "image/svg+xml",
    "swf" -> "application/x-shockwave-flash",
    "t" -> "application/x-troff",
    "tar" -> "application/x-tar",
    "tcl" -> "application/x-tcl",
    "tex" -> "application/x-tex",
    "texi" -> "application/x-texinfo",
    "texinfo" -> "application/x-texinfo",
    "tif" -> "image/tiff",
    "tiff" -> "image/tiff",
    "tk" -> "application/x-tcl",
    "tr" -> "application/x-troff",
    "tsv" -> "text/tab-separated-values",
    "txt" -> "text/plain",
    "ustar" -> "application/x-ustar",
    "vcf" -> "text/x-vcard",
    "war" -> "application/java-archive",
    "wav" -> "audio/x-wav",
    "wbmp" -> "image/vnd.wap.wbmp",
    "webm" -> "video/webm",
    "webp" -> "image/webp",
    "wiz" -> "application/msword",
    "wml" -> "text/vnd.wap.wml",
    "wmlc" -> "application/vnd.wap.wmlc",
    "wmv" -> "video/x-ms-wmv",
    "woff" -> "application/font-woff",
    "wsdl" -> "application/xml",
    "xbm" -> "image/x-xbitmap",
    "xhtml" -> "application/xhtml+xml",
    "xlb" -> "application/vnd.ms-excel",
    "xls" -> "application/vnd.ms-excel",
    "xlsx" -> "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
    "xml" -> "text/xml",
    "xpdl" -> "application/xml",
    "xpi" -> "application/x-xpinstall",
    "xpm" -> "image/x-xpixmap",
    "xsl" -> "application/xml",
    "xul" -> "text/xul",
    "xwd" -> "image/x-xwindowdump",
    "zip" -> "application/zip"
  )

  val knownFiles = Seq(
    "/etc/mime.types",
    "/etc/httpd/mime.types",                    // Mac OS X
    "/etc/httpd/conf/mime.types",               // Apache
    "/etc/apache/mime.types",                   // Apache 1
    "/etc/apache2/mime.types",                  // Apache 2
    "/usr/local/etc/httpd/conf/mime.types",
    "/usr/local/lib/netscape/mime.types",
    "/usr/local/etc/httpd/conf/mime.types",     // Apache 1.2
    "/usr/local/etc/mime.types"                 // Apache 1.3
  )

  def readSources() = {
    knownFiles.map(file =>
      try {
        Some(Source.fromFile(file))
      } catch {
        case _: Exception => None
      }
    ).flatten
  }

  def parseSource(src: Source) = {
    src.getLines
      .map(_.trim)
      .filter(!_.startsWith("#"))
      .filter(!_.isEmpty)
      .map(_.replaceAll("\t", " "))
      .map(_.split("[ ]+").toList)
      .filter(!_.tail.isEmpty)
      .flatMap {
        case mime :: exts => exts.map(_ -> mime)
        case Nil => Seq()
      }
  }

  def getMimeMap(): Map[String, String] = {
    val pairs = readSources
      .flatMap(parseSource)

    Map(knownMimes ++ pairs: _*)
  }

  def getExtension(fileName: String) = fileName.split("\\.").last.toLowerCase

  lazy val mimeMap = getMimeMap

}
