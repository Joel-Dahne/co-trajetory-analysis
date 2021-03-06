class MeasurementTest extends org.scalatest.FunSuite {
  test("Measurement.partition") {

    Array.range(0, 10, 1).foreach {
      i =>
      val m = Measurement(i, Location(Array(i)))
      val p = MeasurementPartition(i, LocationPartition(Array(i)))

      assert(m.partition((1, 1)) === p)
    }

    Array.range(0, 10, 2).foreach {
      i =>
      val m = Measurement(i, Location(Array(i + 1, i + 2, i + 3)))
      val p = MeasurementPartition(i/2, LocationPartition(Array(i + 1, i + 2, i + 3)))

      assert(m.partition((2, 1)) === p)
    }
  }
}

class MeasurementIDTest extends org.scalatest.FunSuite {
  test("MeasurementID.partition") {

    Array.range(0, 10, 1).foreach {
      i =>
      val m = MeasurementID(0, Measurement(i, Location(Array(i))))
      val p = MeasurementPartitionID(0, MeasurementPartition(i, LocationPartition(Array(i))))

      assert(m.partition((1, 1)) === p)
    }

    Array.range(0, 10, 2).foreach {
      i =>
      val m = MeasurementID(0, Measurement(i, Location(Array(i + 1, i + 2, i + 3))))
      val p = MeasurementPartitionID(0, MeasurementPartition(i/2, LocationPartition(Array(i + 1, i + 2, i + 3))))

      assert(m.partition((2, 1)) === p)
    }
  }
}
