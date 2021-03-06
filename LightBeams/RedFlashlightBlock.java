package LightBeams;

/**
 *  A flashlight block emits light on its east side. It is transparent 
    to all incoming light.
 */
public class RedFlashlightBlock extends LightBlocks
{
    /**
     *  Identify what kind of block this is (for display purposes).
     */
    public String getName()
    {
	return "[";
    }
    

    /**
     *  Indicate what color that name should be displayed in.
     */
    public java.awt.Color getNameColor()
    {
	return java.awt.Color.red;
    }


    /**
     *  Indicate how this block reacts when illuminated.
     *  "input" shows whether light is shining on each of the 4 sides
     *     of the block.
     *  The return value must indicate which sides of the block light
     *     is shining from.
     */
    public Illumination illuminate (Illumination input)
    {
	LightColor shining = new LightColor(java.awt.Color.red);
	Illumination result = new Illumination();
	result.N = input.S;
	result.S = input.N;
	result.W = input.E;
	result.E = new LightColor(shining.getRed(),
				  input.W.getGreen(),
				  input.W.getBlue());
	return result;
    }
    
    /**
     * The category is a simple text string used to group related 
     * blocks together when presenting choices in the GUI
     */
    public String getCategory() {return "Flashlights";}
}
