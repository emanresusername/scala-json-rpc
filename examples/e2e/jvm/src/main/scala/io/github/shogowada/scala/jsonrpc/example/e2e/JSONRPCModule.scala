package io.github.shogowada.scala.jsonrpc.example.e2e

import io.github.shogowada.scala.jsonrpc.serializers.UpickleJSONSerializer
import io.github.shogowada.scala.jsonrpc.server.JSONRPCServer

import scala.concurrent.ExecutionContext.Implicits.global

object JSONRPCModule {
  lazy val loggerAPI: LoggerAPI = new LoggerAPIImpl

  lazy val jsonRPCServer: JSONRPCServer[UpickleJSONSerializer] = {
    val server = JSONRPCServer(UpickleJSONSerializer())
    server.bindAPI[CalculatorAPI](new CalculatorAPIImpl)
    server.bindAPI[EchoAPI](new EchoAPIImpl)
    server.bindAPI[LoggerAPI](loggerAPI)
    server
  }
}
