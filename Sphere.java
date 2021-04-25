/*Lindsay Barton
** CS350
** 09-05-2020
*/
package polyhedra;

import java.util.Scanner;

/**
 * Polyhedron representing a sphere.
 */
public class Sphere extends Polyhedron {

    private double radius;

    public Sphere()
    {
        this(1);
    }

    public Sphere(double r)
    {
        super("Sphere");
        this.radius = r;

        double d = this.getDiameter();
        this.boundingBox.setUpperRightVertex(d, d, d);
    }
    public double getRadius()
    {
        return this.radius;
    }

 
    public void setRadius(double r)
    {
        this.radius = radius;

        double d = getDiameter();
        boundingBox.setUpperRightVertex(d, d, d);
    }

    public final double getDiameter()
    {
        return 2 * this.radius;
    }

    @Override
    public void read(Scanner scanner)
    {
        this.radius = scanner.nextDouble();

        double d = this.getDiameter();
        boundingBox.setUpperRightVertex(d, d, d);
    }

    @Override
    public void scale(double scalingFactor)
    {
        this.radius *= scalingFactor;
        this.boundingBox.scale(scalingFactor);
    }

    @Override
    public Polyhedron clone()
    {
        return new Sphere(this.radius);
    }

    @Override
    public String toString()
    {
        return super.toString()
             + "Radius: " + this.radius
             + " "
             + "Diameter: " + this.getDiameter();
    }
}
