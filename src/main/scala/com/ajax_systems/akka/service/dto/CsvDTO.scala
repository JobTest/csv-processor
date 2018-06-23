package com.ajax_systems.akka.service.dto


@SerialVersionUID(1L)
case class CsvDTO(var writer: String, var value: String, var row: Int) extends Serializable {
  def this() = this(null, null, 0)

  override def toString = "CsvDTO{" +
                  "writer='" + writer + '\'' +
                  ", value='" + value + '\'' +
                  ", row=" + row +
                  '}'
}