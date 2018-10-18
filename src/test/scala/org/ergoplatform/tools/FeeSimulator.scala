package org.ergoplatform.tools

import org.ergoplatform.settings.{Constants, Parameters}

object FeeSimulator extends App {
  import org.ergoplatform.settings.Parameters._
  import org.ergoplatform.settings.Constants._

  //standard output size is about 80 bytes
  val StdSize = 80

  lazy val perOutputFee = StdSize * K * StoragePeriod / CoinsInOneErgo.toDouble
  println("Storage fee for ordinary output: " + perOutputFee)

  val bitcoinUtxos = 60000000
  println("Reward per block: " + perOutputFee * (bitcoinUtxos / StoragePeriod))

  val minStdDust = Parameters.MinValuePerByte * StdSize / CoinsInOneErgo.toDouble
  println(s"Min dust value of standard-size box: $minStdDust")
}
