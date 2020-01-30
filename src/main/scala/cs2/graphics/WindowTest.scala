package cs2.graphics

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent

object WindowTest extends JFXApp {
    stage = new JFXApp.PrimaryStage {
        title = "Window!"
        scene = new Scene(600,600) {
            val canvas = new Canvas(600,600)
            content = canvas
            val g = canvas.graphicsContext2D

            canvas.onMouseDragged = (e:MouseEvent) => {
                g.strokeLine(300,300, e.x,e.y)
            }

            /*
            for(x <- 0 until 600 by 20) {
                for(y <- 0 until 600 by 20) {
                    g.setFill(Color.rgb(x*255/600,y*255/600,0))
                    g.fillOval(x,y, 20,20)
                }
            }
            */

            /*
            g.setFill(Color.OLIVEDRAB)
            g.strokeRect(100,200, 300,100)
            g.fillOval(100,200, 300,100)
            g.fillText("Hello world!", 100,200)
            g.setStroke(Color.rgb(255,0,0))
            g.strokeLine(100,200, 600,600)
            */
        }
    }
}