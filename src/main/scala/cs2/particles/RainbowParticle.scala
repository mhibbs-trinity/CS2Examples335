package cs2.particles

import scalafx.scene.paint.Color
import cs2.util.Vec2

class RainbowParticle(p:Vec2, v:Vec2) extends RoundParticle(p,v) {
    private var hue:Double = 0.0

    override def timeStep():Unit = {
        super.timeStep
        col = Color.hsb(hue, 1.0,1.0)
        hue += 10.0
    }
}