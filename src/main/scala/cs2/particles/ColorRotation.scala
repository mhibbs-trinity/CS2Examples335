package cs2.particles

import scalafx.scene.paint.Color

trait ColorRotation {
    private var hue:Double = 0.0

    def stepColor():Color = {
        hue += 5.0
        Color.hsb(hue, 1.0,1.0)
    }
}