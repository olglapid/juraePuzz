package de.htwg.se.juraePuzz.model.model

import de.htwg.se.juraePuzz.model.Grid
import de.htwg.se.juraePuzz.model.Piece
import de.htwg.se.juraePuzz.model.Rotation
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class GridSpec extends WordSpec with Matchers {
    "A grid" should {
      val g = Grid(2)
      "have a size" in {
        g.getSize() should be(2)
      }
      "have Pieces" in {
        g.init()
        g.matrix.get(0, 0) should be(Piece("0", Rotation(0)))
        g.matrix.get(0, 1) should be(Piece("0", Rotation(0)))
        g.matrix.get(1, 0) should be(Piece("0", Rotation(0)))
        g.matrix.get(1, 1) should be(Piece("0", Rotation(0)))
      }

      "have Curves" in {
        for (i <- 0 until g.getSize(); j <- 0 until g.getSize()){
          g.matrix.fill(Piece("K", Rotation(0)), i, j)
        }
        g.matrix.get(0, 0) should be(Piece("K", Rotation(0)))
        g.matrix.get(0, 1) should be(Piece("K", Rotation(0)))
        g.matrix.get(1, 0) should be(Piece("K", Rotation(0)))
        g.matrix.get(1, 1) should be(Piece("K", Rotation(0)))
      }
      "be edited" in {
        g.init()
        g.fill(Piece("K", Rotation(0)), 1, 1)
        g.checkMove(1, 1, 1, 0) should be(true)
        g.checkMove(0, 0, 1, 1) should be(false)
        g.checkMove(1,1, 0, 1) should be(true)
        g.checkMove(2,1,2,0) should be(false)
        g.fill(Piece("S", Rotation(0)), 0, 0)
        g.checkMove(0, 0, 0, 1) should be(false)
      }
      "move correct" in {
        g.init()
        g.fill(Piece("K", Rotation(0)), 0, 0)
        g.move(0, 0, 0, 1)
        g.matrix.get(0,0) should be(Piece("0", Rotation(0)))
        g.matrix.get(0, 1) should be (Piece("K", Rotation(0)))
        g.move(0,0, 1,0) should be (())
      }
      "renderd" in {
        g.render() should be(())
      }
    }
}
