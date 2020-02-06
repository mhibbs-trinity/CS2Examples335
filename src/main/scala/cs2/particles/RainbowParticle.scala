package cs2.particles

import scalafx.scene.paint.Color
import cs2.util.Vec2

class RainbowParticle(p:Vec2, v:Vec2) extends RoundParticle(p,v) 
        with ColorRotation {
    override def timeStep():Unit = {
        super.timeStep
        col = stepColor
    }
}