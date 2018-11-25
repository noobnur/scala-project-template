package org.ledrone

import org.scalatest.{FlatSpec, Matchers}
import org.ledrone.LeDroneMain._

class LeDroneMainTest extends FlatSpec with Matchers {

  "Running LeDroneMain" should "print out 'ledrone starting'" in {
      returnOk() shouldBe "ledrone starting"
  }

}
