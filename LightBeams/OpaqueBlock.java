//Lindsay Barton
package LightBeams;

public class OpaqueBlock extends LightBlocks{

    //name
    public String getName(){ return "*";}

    //name color - orange in this case because it's easy to see
    public java.awt.Color getNameColor()
    {
        return java.awt.Color.orange;
    }



    public Illumination illuminate (Illumination input)
    {
	Illumination result = new Illumination();
	result.N = new LightColor();
	result.S = new LightColor();
	result.W = new LightColor();
	result.E = new LightColor();
	return result;
    }



    public String getCategory() {return "Opaque";}

}