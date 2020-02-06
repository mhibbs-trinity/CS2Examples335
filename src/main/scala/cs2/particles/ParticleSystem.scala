package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class ParticleSystem(protected var origin:Vec2) {
    protected var particles:List[Particle] = Nil

    def addParticle():Unit = {
        particles ::= new RainbowParticle(origin.clone,
                     new Vec2(math.random * 10 -5,
                              math.random * 10 -5))
        /*
        particles ::= new SquareParticle(origin.clone,
                     new Vec2(math.random * 10 -5,
                              math.random * 10 -5))
        */
        println(particles.length)
    }

    def display(g:GraphicsContext):Unit = {
        for(part <- particles) {
            part.display(g)
        }
    }

    def timeStep():Unit = {
        particles.foreach(_.timeStep())
    }

    def applyForce(acc:Vec2):Unit = {
        for(part <- particles) {
            part.applyForce(acc)
        }
    }


}